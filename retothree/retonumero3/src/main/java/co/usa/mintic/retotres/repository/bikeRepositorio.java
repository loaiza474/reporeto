package co.usa.mintic.retotres.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.mintic.retotres.model.bike;
import co.usa.mintic.retotres.repository.crud.bikeCrudRepositorio;

@Repository
public class bikeRepositorio {
    @Autowired
    private bikeCrudRepositorio bikeCrudRepositorio;

    public List<bike>getAll(){
        return (List<bike>)bikeCrudRepositorio.findAll();
    }

    public Optional<bike>getBike(int id){
        return bikeCrudRepositorio.findById(id);
    }

    public bike save(bike audi){
        return bikeCrudRepositorio.save(audi);
    }

    public void delete(bike audi){
        bikeCrudRepositorio.delete(audi);
    }
}
