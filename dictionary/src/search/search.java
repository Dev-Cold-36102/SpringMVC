package search;

import dic.constuctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class search {
    @GetMapping("/search")
    public String search(@RequestParam String input, Model model){
        HashMap<String,String> dichashmap= constuctor.dicNew();
        if (dichashmap.containsKey(input)) {
            model.addAttribute("output",dichashmap.get(input));
        } else
            model.addAttribute("output","404");
        return "home";
    }
}
