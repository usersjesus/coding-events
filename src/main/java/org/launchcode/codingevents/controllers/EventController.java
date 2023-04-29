package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static  HashMap<String, String> events = new HashMap();

    @GetMapping
    public String displayAllEvents(Model model) {
        events.put("Name of Event One", "Description of Event One");
        events.put("Name of Event Two", "Description of Event Two");
        events.put("Name of Event Three", "Description of Event Three");
       model.addAttribute("events", events);
        return "events/index";
    }

//    lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

//    lives at /events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription) {
        events.put(eventName, eventDescription);
        return "redirect:";
    }
}
