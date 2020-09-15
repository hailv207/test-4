package app.controllers;

import app.models.City;
import app.services.CityService;
import app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;


    @GetMapping("/")
    public ModelAndView showCities(@RequestParam(value = "searchKey", required = false) String searchKey) {
        ModelAndView modelAndView = new ModelAndView("home");
        if (searchKey != null && !searchKey.equals("")) {
            modelAndView.addObject("cities", cityService.findAllByNameContain(searchKey));
        } else {
            modelAndView.addObject("cities", cityService.findAll());
        }
        modelAndView.addObject("searchKey", searchKey);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("countries", countryService.findAll());
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute("city") City city, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {

            return new ModelAndView("create")
                    .addObject("countries",countryService.findAll());
        } else {
            cityService.save(city);
            return new ModelAndView("redirect:/");
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("countries",countryService.findAll());
        modelAndView.addObject("city", cityService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Validated @ModelAttribute("city") City city, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("edit")
                    .addObject("countries",countryService.findAll());
        } else {
            cityService.save(city);
            return new ModelAndView("redirect:/");
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("city", cityService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        cityService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("city", cityService.findById(id).get());
        return modelAndView;
    }
}
