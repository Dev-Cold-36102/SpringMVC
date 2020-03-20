package convert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class convert {
    @GetMapping("/convert")
    public String covertUSD(@RequestParam int USD, Model model){
        model.addAttribute("vnd",USD*20000);
        return "view";
    }
}
