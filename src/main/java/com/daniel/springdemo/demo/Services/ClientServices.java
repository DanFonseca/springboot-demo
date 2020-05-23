package com.daniel.springdemo.demo.Services;

import com.daniel.springdemo.demo.Entities.Client;
import com.daniel.springdemo.demo.Repositories.ClientRepository;
import com.daniel.springdemo.demo.Services.Excpetions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll (){
        return clientRepository.findAll();
    }

    public Client findById (Integer id){
        Optional<Client> user = clientRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Client insert (Client client){
        return clientRepository.save(client);
    }

    public void removeById(Integer id) {
        clientRepository.deleteById(id);
    }
    public Client update (Client client, Integer id){
        Client entity = clientRepository.getOne(id);
        doUpdate(entity, client);
        return clientRepository.save(entity);
    }

    private void doUpdate(Client entity, Client client) {
        entity.setName(client.getName());
        entity.setEmail(client.getEmail());
        entity.setPhone(client.getPhone());
    }
}
