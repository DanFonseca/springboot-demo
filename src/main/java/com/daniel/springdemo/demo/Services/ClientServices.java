package com.daniel.springdemo.demo.Services;

import com.daniel.springdemo.demo.Entities.Client;
import com.daniel.springdemo.demo.Repositories.ClientRepository;
import com.daniel.springdemo.demo.Services.Excpetions.DatabaseException;
import com.daniel.springdemo.demo.Services.Excpetions.NumberFormatException;
import com.daniel.springdemo.demo.Services.Excpetions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Integer id) {
        Optional<Client> user = clientRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Client insert(Client client) {
        return clientRepository.save(client);
    }

    public void removeById(Integer id) {
        try {
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public Client update(Client client, Integer id) {
        Client entity = null;

        try {
            entity = clientRepository.getOne(id);
            doUpdate(entity, client);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }catch (NumberFormatException e){
            throw new NumberFormatException(id);
        }

        return clientRepository.save(entity);
    }

    private void doUpdate(Client entity, Client client) throws EntityNotFoundException, NumberFormatException {
        entity.setName(client.getName());
        entity.setEmail(client.getEmail());
        entity.setPhone(client.getPhone());
    }
}
