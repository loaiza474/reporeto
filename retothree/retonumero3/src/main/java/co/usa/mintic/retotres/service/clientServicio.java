package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.client;
import co.usa.mintic.retotres.repository.clientRepositorio;

@Service
public class clientServicio {

    @Autowired
    private clientRepositorio clientRepositorio;

    public List<client> getAll(){
        return clientRepositorio.getAll();
    }

    public Optional<client>getCliente(int id){
        return clientRepositorio.getClient(id);
    }

    
    
    public client save(client clt){
        if(clt.getIdClient()==null){
            return clientRepositorio.save(clt);
        }else{
            Optional<client> consulta=clientRepositorio.getClient(clt.getIdClient());
            if(consulta.isEmpty()){
                return clientRepositorio.save(clt);
            }else{
                return clt;
            }
        }
    }

    public boolean deleteClient(int numId){

        Optional<client> consulta=clientRepositorio.getClient(numId);

        if(!consulta.isEmpty()){

            clientRepositorio.delete(consulta.get());
            
            return true;
        }
        return false;
    }   

    public client update(client client){
        if(client.getIdClient()!=null){
            Optional<client> consulta=clientRepositorio.getClient(client.getIdClient());
            if(!consulta.isEmpty()){
                if(client.getName()!=null){
                    consulta.get().setName(client.getName());
                }
            if(client.getEmail()!=null){
                consulta.get().setEmail(client.getEmail());
                }
            if(client.getPassword()!=null){
                consulta.get().setPassword(client.getPassword());
                }
            if(client.getName()!=null){
                consulta.get().setName(client.getName());
                }
            if(client.getAge()!=null){
                consulta.get().setAge(client.getAge());
            }
            return clientRepositorio.save(consulta.get());
            }
        }
        return client;
    }


    // private Integer idClient;
    // private String email;
    // private String password;
    // private String name;
    // private Integer age;

    
}
