package ma.project.controllers.implementations;

import lombok.AllArgsConstructor;
import ma.project.models.implemantations.Client;
import ma.project.models.implemantations.Reservation;
import ma.project.services.implementations.ClientService;
import ma.project.services.implementations.ReservationService;
import ma.project.services.implementations.VehiculeServcie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@AllArgsConstructor
public class ReservationController {
    private ReservationService reservationService;
    private VehiculeServcie vehiculeServcie;
    private ClientService clientService;

    @GetMapping(path = "/reservation/{id}")
    public String reservationPage(@PathVariable Long id, Model model) {
        model.addAttribute("vehicule", vehiculeServcie.findById(id));
        model.addAttribute("client", new Client());
        return "reservation";
    }

    @PostMapping (path = "/reservation/{id}/save")
    public String reservationSave(@PathVariable Long id, Model model, @ModelAttribute("client") Client client,
                                  @RequestParam("dateDebut") Date dateDebut, @RequestParam("dateFin") Date dateFin) {
        Reservation reservation = new Reservation();
        reservation.setClient(clientService.save(client));
        reservation.setPickUpDate(dateDebut);
        reservation.setRetournDate(dateFin);
        reservation.setVehicule(vehiculeServcie.findById(id));

        reservationService.save(reservation);
        return "redirect:/cars";
    }
}
