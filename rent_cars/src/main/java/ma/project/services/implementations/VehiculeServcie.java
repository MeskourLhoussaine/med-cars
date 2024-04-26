package ma.project.services.implementations;

import ma.project.Repositories.implemantations.VehiculeRepository;
import ma.project.models.implemantations.Vehicule;
import ma.project.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehiculeServcie extends GenericService<Vehicule> {

    public VehiculeServcie(VehiculeRepository vehiculeRepository) {
        super(vehiculeRepository);
    }
}
