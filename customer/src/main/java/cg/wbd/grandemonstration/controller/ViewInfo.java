package cg.wbd.grandemonstration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewInfo {
    @GetMapping("/viewinfo")
    public String viewInfo(@RequestParam long id, Model model){
        model.addAttribute("id",id);
        return "info";
    }
}
