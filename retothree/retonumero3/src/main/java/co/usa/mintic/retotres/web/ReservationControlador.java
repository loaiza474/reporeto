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

import co.usa.mintic.retotres.model.Reservation;
import co.usa.mintic.retotres.service.ReservationServicio;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ReservationControlador {
    @Autowired
    private ReservationServicio reservationServicio;
    @GetMapping("/all")
    public List<Reservation>getMensajes(){
        return reservationServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation>getMensaje(@PathVariable("id") int id){
        return reservationServicio.getMensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reserva){
        return reservationServicio.save(reserva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public boolean deleteReservation(@PathVariable("id")int numId){

        return reservationServicio.deleteReservation(numId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reserva) {
        return reservationServicio.update(reserva);
    }
}
