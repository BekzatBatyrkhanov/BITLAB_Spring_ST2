package com.example.BITLAB.SprintTask2.controller;

import com.example.BITLAB.SprintTask2.model.ApplicationRequest;
import com.example.BITLAB.SprintTask2.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RequestRepository appRequests;

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        List<ApplicationRequest> requests = appRequests.findAll();
        model.addAttribute("zapros",requests);
        return "index";
    }

    @GetMapping(value = "/add")
    public String addPage() {
        return "addpage";
    }

    @PostMapping(value = "/add-request")
    public String addReq(ApplicationRequest request) {
        appRequests.save(request);
        return "redirect:/";
    }

    @GetMapping(value = "/new")
    public String newReq(Model model) {
        List<ApplicationRequest> requests = appRequests.findAllByHandledIsFalse();
        model.addAttribute("zapros", requests);
        return "index";
    }

    @GetMapping(value = "/old")
    public String oldReq(Model model) {
        List<ApplicationRequest> requests = appRequests.findAllByHandledIsTrue();
        model.addAttribute("zapros",requests);
        return "index";
    }

    @PostMapping(value = "/save-request")
    public String saveRequest(ApplicationRequest applicationRequest){
        appRequests.save(applicationRequest);
        return "redirect:/"; // response.sendRedirect("/");
    }

    @PostMapping(value = "/delete-request")
    public String deleteReq(@RequestParam(name = "id") Long id) {
        appRequests.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{requestId}")
    public String requestDetails(@PathVariable(name = "requestId") Long id, Model model){
        ApplicationRequest applicationRequest = appRequests.findById(id).orElse(null);
        model.addAttribute("zapros", applicationRequest);
        return "details";
    }



}
