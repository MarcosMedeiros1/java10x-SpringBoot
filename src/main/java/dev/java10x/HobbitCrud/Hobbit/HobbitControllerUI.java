package dev.java10x.HobbitCrud.Hobbit;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hobbits/ui")
public class HobbitControllerUI {

    private final HobbitService hobbitService;

    public HobbitControllerUI(HobbitService hobbitService) {
        this.hobbitService = hobbitService;
    }

    @GetMapping("/all")
    public String getAllHobbits(Model model) {
        List<HobbitDTO> hobbits = hobbitService.getAllHobbits();
        model.addAttribute("hobbits", hobbits);
        return "ListHobbits";
    }
}
