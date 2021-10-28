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

import co.usa.mintic.retotres.model.Message;
import co.usa.mintic.retotres.service.MessageServicio;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class MessageControlador {
    
    @Autowired
    private MessageServicio messageServicio;
    @GetMapping("/all")
    public List<Message>getMensajes(){
        return messageServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message>getMensaje(@PathVariable("id") int id){
        return messageServicio.getMensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message mensaje){
        return messageServicio.save(mensaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public boolean deleteMessage(@PathVariable("id")int numId){

        return messageServicio.deleteMessage(numId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message mensaje) {
        return messageServicio.update(mensaje);
    }
}
