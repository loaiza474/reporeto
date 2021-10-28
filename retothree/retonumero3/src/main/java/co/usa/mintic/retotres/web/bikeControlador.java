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

import co.usa.mintic.retotres.model.bike;
import co.usa.mintic.retotres.service.bikeServicio;

@RestController
@RequestMapping("/api/Bike")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class bikeControlador {
    @Autowired
    private bikeServicio bikeServicio;
    @GetMapping("/all")
    public List<bike>getBikes(){
        return bikeServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<bike>getBike(@PathVariable("id") int id){
        return bikeServicio.getBike(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public bike save(@RequestBody bike audi){
        return bikeServicio.save(audi);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public boolean deleteBike(@PathVariable("id")int numId){

        return bikeServicio.deleteBike(numId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public bike update(@RequestBody bike audi) {
        return bikeServicio.update(audi);
    }
}