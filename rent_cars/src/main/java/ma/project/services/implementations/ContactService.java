package ma.project.services.implementations;

import ma.project.Repositories.implemantations.ContactRepository;
import ma.project.models.implemantations.Contact;
import ma.project.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactService extends GenericService<Contact> {
    public ContactService(ContactRepository contactRepository) {
        super(contactRepository);
    }
}
