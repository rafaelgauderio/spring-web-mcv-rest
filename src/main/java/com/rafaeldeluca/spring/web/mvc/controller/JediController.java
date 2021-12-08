package com.rafaeldeluca.spring.web.mvc.controller;


import com.rafaeldeluca.spring.web.mvc.model.Jedi;
import com.rafaeldeluca.spring.web.mvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class JediController {

    @Autowired
    private JediRepository repositoy;

    @GetMapping("/Jedi")
    public ModelAndView jedi() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        final Jedi luke = new Jedi("Luke","Skywalker");
        modelAndView.addObject("allJedi", List.of(luke));
        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");
        modelAndView.addObject("jedi", new Jedi());
        return  modelAndView;

    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "new-jedi";
        }
        repositoy.add(jedi);
        redirectAttributes.addFlashAttribute("Message", "Jedi successfully create");
        return "redirect:jedi";
    }


}
