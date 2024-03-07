package com.example.cubochallenge.Service;

import com.example.cubochallenge.Entity.Client;
import com.example.cubochallenge.Entity.dto.ClientDTO;
import com.example.cubochallenge.Repository.ClientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRespository clientRespository;

    public Client saveClient(ClientDTO clientDTO) {
        Client client = new Client();

        client.setFirstName(clientDTO.firstName());
        client.setLastName(clientDTO.lastName());
        client.setParticipation(clientDTO.participation());
        if (client.getFirstName() == null || client.getLastName() == null || client.getParticipation() == null) {
            throw new IllegalArgumentException();
        }
        return clientRespository.save(client);
    }

    public List<Client> listAllClients() {
        if (clientRespository.findAll().isEmpty()) {
            throw new IllegalStateException();
        }
        return clientRespository.findAll();
    }
}
