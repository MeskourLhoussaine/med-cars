package ma.project.controllers.implementations;

import lombok.AllArgsConstructor;
import ma.project.models.implemantations.Contact;
import ma.project.services.implementations.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class ContactController {
    private ContactService contactService;

    @GetMapping(path = "/contact")
    public String contactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping (path = "/contact/save")
    public String contactPage(@ModelAttribute("contact") Contact contact, RedirectAttributes redirectAttributes) {
        Contact contact1 = contactService.save(contact);
        redirectAttributes.addFlashAttribute("message", "Your message " + contact1.getSubject() + " it is send for success! 'Thank you for contact us'");
        return "redirect:/contact";
    }

    @GetMapping(path = "/dashboard/contact")
    public String dashboardContactPage(Model model){
        model.addAttribute("contacts", contactService.findAll());
        return "admin/contact";
    }
}
