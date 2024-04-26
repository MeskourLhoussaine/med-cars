package ma.project.services.implementations;

import ma.project.Repositories.implemantations.ClientRepository;
import ma.project.models.implemantations.Client;
import ma.project.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService extends GenericService<Client> {
    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
    }
}
