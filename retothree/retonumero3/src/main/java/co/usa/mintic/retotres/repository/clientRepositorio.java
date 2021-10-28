package co.usa.mintic.retotres.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.mintic.retotres.model.client;
import co.usa.mintic.retotres.repository.crud.clientCrudRepositorio;

@Repository
public class clientRepositorio {
    @Autowired
    private clientCrudRepositorio clientCrudRepositorio;

    public List<client> getAll(){
        return (List<client>)clientCrudRepositorio.findAll();
    }
    
    public Optional<client>getClient(int id){
        return clientCrudRepositorio.findById(id);
    }

    public client save(client client){
        return clientCrudRepositorio.save(client);
    }
    public void delete(client client){
        clientCrudRepositorio.delete(client);
    }

}