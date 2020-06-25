package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView shoForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("/validate")
    public ModelAndView check(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("result");
            return modelAndView;
        }

    }
}
