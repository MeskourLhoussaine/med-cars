package ma.project.services.implementations;

import ma.project.Repositories.implemantations.ReservationRepository;
import ma.project.models.implemantations.Reservation;
import ma.project.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService extends GenericService<Reservation> {
    public ReservationService(ReservationRepository reservationRepository) {
        super(reservationRepository);
    }
}
