package perscholas.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import perscholas.service.ExtraService;

@Controller
public class ExtraController {
    private final ExtraService extraService;
    @Autowired
    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @GetMapping("/extra")
    public String quickMath(@RequestParam(required = false) String answer, Model model) {
        answer = extraService.doMath(answer);
        model.addAttribute("answer", answer);
        return "extra/extra";
    }

}
