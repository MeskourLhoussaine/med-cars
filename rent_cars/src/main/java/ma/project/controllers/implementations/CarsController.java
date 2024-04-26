package ma.project.controllers.implementations;

import lombok.AllArgsConstructor;
import ma.project.models.implemantations.Vehicule;
import ma.project.services.implementations.VehiculeServcie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
@AllArgsConstructor
public class CarsController {
    private VehiculeServcie vehiculeServcie;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/uploads/cars/";


    @GetMapping(path = "/cars")
    public String carsPage(Model model) {
        model.addAttribute("cars", vehiculeServcie.findAll());
        return "cars";
    }


    @GetMapping(path = "/dashboard/cars")
    public String carsDashboard(Model model) {
        model.addAttribute("vehicules", vehiculeServcie.findAll());
        return "admin/cars";
    }

    @PostMapping(path = "/dashboard/cars/save")
    public String carsDashboardSave(@RequestParam("matricule") String matricule, @RequestParam("model") Integer model,
                                    @RequestParam("marque") String marque, @RequestParam("color") String color,
                                    @RequestParam("vetisse") Character vetisse, @RequestParam("place") Integer place,
                                    @RequestParam("port") Integer port, @RequestParam("carburent") Character carburent,
                                    @RequestParam("climatiseur") Boolean climatiseur, @RequestParam("prix") Double prix,
                                    @RequestParam("image") MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            assert fileName != null;
            String imageName = "cars_" + new Date().toString().replace(" ", "_")
                    .replace(":", "_") + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
            Path path = Paths.get(UPLOAD_DIRECTORY + imageName);
            Files.write(path, multipartFile.getBytes());

            Vehicule vehicule = new Vehicule();
            vehicule.setImage("/static/uploads/cars/" + imageName);
            vehicule.setSerialNumber(matricule);
            vehicule.setMarque(marque);
            vehicule.setModel(model);
            vehicule.setColor(color);
            vehicule.setBoiteVetisse(vetisse);
            vehicule.setPlaceNumber(place);
            vehicule.setNombrePort(port);
            vehicule.setCarburant(carburent);
            vehicule.setClimatiseur(climatiseur);
            vehicule.setPriceDay(prix);
            vehiculeServcie.save(vehicule);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/dashboard/cars";
    }
}
