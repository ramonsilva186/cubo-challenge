package com.example.cubochallenge.Controller;

import com.example.cubochallenge.Entity.Client;
import com.example.cubochallenge.Entity.dto.ClientDTO;
import com.example.cubochallenge.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.saveClient(clientDTO);
        return ResponseEntity.ok().body(client);
    }
    @GetMapping("/listAll")
    public ResponseEntity<List<Client>> listAllClients() {
        List<Client> clientList = clientService.listAllClients();
        return ResponseEntity.ok().body(clientList);
    }
}
