package ma.project.services.implementations;

import lombok.AllArgsConstructor;
import ma.project.iservices.IMainApis;
import ma.project.models.implemantations.Reservation;
import ma.project.models.implemantations.Vehicule;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

//PayPik

@Service
@AllArgsConstructor
public class MainApisService implements IMainApis {
    private ClientService clientService;
    private ReservationService reservationService;
    private VehiculeServcie vehiculeServcie;

    @Override
    public List<Vehicule> searchReservation(Date departDate, Date retourDate, String marque) {
        return reservationService.findAll().stream()
                .filter(v ->
                        (retourDate.after(v.getRetournDate()) && departDate.after(v.getRetournDate()))
                                && v.getVehicule().getMarque().equals(marque)
                )
                .map(Reservation::getVehicule).toList();
    }

    @Override
    public Reservation effectuerClinetOnReservation(Long clientId, Long vehiculeId, Reservation reservation) {
        return reservationService.save(
                Reservation.builder()
                        .client(clientService.findById(clientId))
                        .vehicule(vehiculeServcie.findById(vehiculeId))
                        .pickUpDate(reservation.getPickUpDate())
                        .retournDate(reservation.getRetournDate())
                        .build()
        );
    }
}
