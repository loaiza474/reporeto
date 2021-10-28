
package co.usa.mintic.retotres.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.mintic.retotres.model.client;
import co.usa.mintic.retotres.service.clientServicio;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class clientControlador {
    
    @Autowired
    private clientServicio clientServicio;
    @GetMapping("/all")
    public List<client>getClientes(){
        return clientServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<client>getDepartamento(@PathVariable("id") int id){
        return clientServicio.getCliente(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public client save(@RequestBody client clt){
        return clientServicio.save(clt);
    }


    @DeleteMapping("/{id}")

    @ResponseStatus(HttpStatus.NO_CONTENT)

    public boolean deleteClient(@PathVariable("id")int numId){

        return clientServicio.deleteClient(numId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public client update(@RequestBody client clt) {
        return clientServicio.update(clt);
    }
}