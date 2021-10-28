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

import co.usa.mintic.retotres.model.ReservationRating;
import co.usa.mintic.retotres.service.ReservationRatingServicio;

@RestController
@RequestMapping("/api/ReservationRating")
@CrossOrigin(origins = "*",methods = {RequestMethod .GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ReservationRatingControlador {
    @Autowired
    private ReservationRatingServicio reservationRatingServicio;
    @GetMapping("/all")
    public List<ReservationRating>getMensajes(){
        return reservationRatingServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ReservationRating>getMensaje(@PathVariable("id") int id){
        return reservationRatingServicio.getMensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationRating save(@RequestBody ReservationRating mensaje){
        return reservationRatingServicio.save(mensaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public boolean deleteReservarionRating(@PathVariable("id")int numId){

        return reservationRatingServicio.deleteReservationRating(numId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationRating update(@RequestBody ReservationRating mensaje) {
        return reservationRatingServicio.update(mensaje);
    }
}
