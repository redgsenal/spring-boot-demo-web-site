package com.sample.web.springboot.demo.site.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.web.springboot.demo.site.model.Person;

@Controller
public class MainController {

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("title", "Hello There!");
        model.addAttribute("year", "Copyright ".concat(getCurrentYear()).concat(" General public domain"));
        return "index";
    }

    @GetMapping("/people")
    public String getPeople(@RequestParam(required = false) boolean showFullDetails,  Model model) {
        List<Person> people = Arrays.asList(
                new Person("1", "Jon", "Doe", "1980-02-01", "Singapore", "m"),
                new Person("2", "Sally", "Deen", "1972-03-02", "Taiwan", "f"),
                new Person("3", "Jane", "Kite", "1993-11-21", "Philippines", "f"),
                new Person("4", "Tylor", "Moe", "1979-10-14", "Malaysia", "f"),
                new Person("5", "May", "Locks", "1983-06-17", "Indonesia", "m"));
        model.addAttribute("title", "List of Persons");
        model.addAttribute("showFullDetails", showFullDetails);
        model.addAttribute("people", people);
        return "people";
    }

    private String getCurrentYear() {
        Calendar cal = Calendar.getInstance();
        return String.valueOf(cal.get(Calendar.YEAR));
    }

}