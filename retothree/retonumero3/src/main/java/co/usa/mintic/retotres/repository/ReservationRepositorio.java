package co.usa.mintic.retotres.repository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.mintic.retotres.model.Reservation;
import co.usa.mintic.retotres.repository.crud.ReservationCrudRepositorio;

@Repository
public class ReservationRepositorio {
    @Autowired
    private ReservationCrudRepositorio reservationCrudRepositorio;

    public List<Reservation>getAll(){
        return (List<Reservation>)reservationCrudRepositorio.findAll();
    }

    public Optional<Reservation>getMensaje(int id){
        return reservationCrudRepositorio.findById(id);
    }

    public Reservation save(Reservation reserva){
        return reservationCrudRepositorio.save(reserva);
    }

    public void delete(Reservation reserva){
        reservationCrudRepositorio.delete(reserva);
    }
}
