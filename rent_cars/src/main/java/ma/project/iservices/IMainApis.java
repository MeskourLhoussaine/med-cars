package ma.project.iservices;

import ma.project.models.implemantations.Reservation;
import ma.project.models.implemantations.Vehicule;

import java.util.Date;
import java.util.List;

public interface IMainApis {
    List<Vehicule> searchReservation(Date departDate, Date retourDate, String marque);

    Reservation effectuerClinetOnReservation(Long clientId, Long vehiculeId, Reservation reservation);
}
