package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.Message;
import co.usa.mintic.retotres.repository.MessageRepositorio;

@Service
public class MessageServicio {

    @Autowired
    private MessageRepositorio messageRepositorio;

    public List<Message> getAll(){
        return messageRepositorio.getAll();
    }

    public Optional<Message> getMensaje(int id){
        return messageRepositorio.getMensaje(id);
    }
    
    
    public Message save(Message mensaje){
        if(mensaje.getIdMessage()==null){
            return messageRepositorio.save(mensaje);
        }else{
            Optional<Message> consulta=messageRepositorio.getMensaje(mensaje.getIdMessage());
            if(consulta.isEmpty()){
                return messageRepositorio.save(mensaje);
            }else{
                return mensaje;
            }
        }
    }

    public boolean deleteMessage(int numId){

        Optional<Message> consulta=messageRepositorio.getMensaje(numId);

        if(!consulta.isEmpty()){

            messageRepositorio.delete(consulta.get());
            
            return true;
        }
        return false;
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> consulta=messageRepositorio.getMensaje(message.getIdMessage());
            if(!consulta.isEmpty()){
                if(message.getMessageText()!=null){
                    consulta.get().setMessageText(message.getMessageText());
                }
            return messageRepositorio.save(consulta.get());
            }
        }
        return message;
    }


    // private Integer idMessage;
    // private String messageText;
}
