package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.bike;
import co.usa.mintic.retotres.repository.bikeRepositorio;


@Service
public class bikeServicio {

    @Autowired
    private bikeRepositorio bikeRepositorio;
    public List<bike>getAll(){
        return bikeRepositorio.getAll();
    }

    public Optional<bike>getBike(int id){
        return bikeRepositorio.getBike(id);
    }

    public bike save(bike audi){
        if(audi.getId()==null){
            return bikeRepositorio.save(audi);
        }else{Optional<bike> consulta=bikeRepositorio.getBike(audi.getId());
            if(consulta.isEmpty()){
                return bikeRepositorio.save(audi);
            }else{
                return audi;
            }
        
        }
    }

    public boolean deleteBike(int numId){

        Optional<bike> consulta=bikeRepositorio.getBike(numId);

        if(!consulta.isEmpty()){

            bikeRepositorio.delete(consulta.get());

            return true;

        }
        return false;
    }
    
    public bike update(bike bike){
        if(bike.getId()!=null){
            Optional<bike> consulta=bikeRepositorio.getBike(bike.getId());
            if(!consulta.isEmpty()){
                if(bike.getName()!=null){
                    consulta.get().setName(bike.getName());
                }
            if(bike.getbrand()!=null){
                consulta.get().setbrand(bike.getbrand());
                }
            if(bike.getYear()!=null){
                consulta.get().setYear(bike.getYear());
                }
            if(bike.getDescription()!=null){
                consulta.get().setDescription(bike.getDescription());
            }
            return bikeRepositorio.save(consulta.get());
            }
        }
        return bike;
    }

    // private Integer id; //brand
    // private String name;
    // private String brand;
    // private Integer year; 
    // private String description;
}
