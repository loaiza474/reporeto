package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.Reservation;
import co.usa.mintic.retotres.repository.ReservationRepositorio;



@Service
public class ReservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepositorio;

    public List<Reservation> getAll(){
        return reservationRepositorio.getAll();
    }

    public Optional<Reservation> getMensaje(int id){
        return reservationRepositorio.getMensaje(id);
    }
    
    
    public Reservation save(Reservation reserva){
        if(reserva.getIdReservation()==null){
            return reservationRepositorio.save(reserva);
        }else{
            Optional<Reservation> consulta=reservationRepositorio.getMensaje(reserva.getIdReservation());
            if(consulta.isEmpty()){
                return reservationRepositorio.save(reserva);
            }else{
                return reserva;
            }
        }
    }
    
    public boolean deleteReservation(int numId){

        Optional<Reservation> consulta=reservationRepositorio.getMensaje(numId);

        if(!consulta.isEmpty()){

            reservationRepositorio.delete(consulta.get());
            
            return true;
        }
        return false;
    }


    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> consulta=reservationRepositorio.getMensaje(reservation.getIdReservation());
            if(!consulta.isEmpty()){
                if(reservation.getStartDate()!=null){
                    consulta.get().setStartDate(reservation.getStartDate());
                }
            if(reservation.getDevolutionDate()!=null){
                consulta.get().setDevolutionDate(reservation.getDevolutionDate());
                }
            if(reservation.getStatus()!=null){
                consulta.get().setStatus(reservation.getStatus());
                }
            return reservationRepositorio.save(consulta.get());
            }
        }
        return reservation;
    }

    // private Integer idReservation;
    // private Date startDate;
    // private Date devolutionDate;
    // private String status="created";
}
