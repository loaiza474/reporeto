package co.usa.mintic.retotres.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.mintic.retotres.model.ReservationRating;
import co.usa.mintic.retotres.repository.crud.ReservationRatingCrudRepositorio;

@Repository
public class ReservationRatingRepositorio {
    @Autowired
    private ReservationRatingCrudRepositorio reservationRatingCrudRepositorio;

    public List<ReservationRating>getAll(){
        return (List<ReservationRating>)reservationRatingCrudRepositorio.findAll();
    }

    public Optional<ReservationRating>getMensaje(int id){
        return reservationRatingCrudRepositorio.findById(id);
    }

    public ReservationRating save(ReservationRating reservaCalificacion){
        return reservationRatingCrudRepositorio.save(reservaCalificacion);
    }

    public void delete(ReservationRating reservaCalificacion){
        reservationRatingCrudRepositorio.delete(reservaCalificacion);
    }
}
