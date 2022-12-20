package com.thuytrang.littleflowershop.controller.web;

import com.thuytrang.littleflowershop.payload.request.OccasionRequest;
import com.thuytrang.littleflowershop.payload.response.OccasionResponse;
import com.thuytrang.littleflowershop.service.OccasionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/occasions")
public class OccasionWebController {
    @Autowired
    private OccasionService occasionService;

    @GetMapping("/form")
    public ModelAndView showFormCreate() {
        ModelAndView response = new ModelAndView("/admin/occasion/form");
        response.addObject("occasion", new OccasionRequest());
        response.addObject("action", "create");

        return response;
    }

    @GetMapping("/filter")
    public ModelAndView filterOccasions(
            @RequestParam(name = "by") String by,
            @RequestParam(name = "keyword") String keyword
    ) {
        ModelAndView response = new ModelAndView("admin/occasion/list");
        List<OccasionResponse> occasions = occasionService.filterOccasions(by, keyword);
        response.addObject("occasions", occasions);

        return  response;
    }

    @GetMapping
    public ModelAndView retrievalOccasions() {
        ModelAndView response = new ModelAndView("admin/occasion/list");
        List<OccasionResponse> occasions = occasionService.retrievalOccasions();
        response.addObject("occasions", occasions);

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView detailOccasion(
            @PathVariable(name = "id") Long id
    ) {
        ModelAndView response = new ModelAndView("admin/occasion/form");
        OccasionResponse occasion = occasionService.detailOccasion(id);
        response.addObject("occasion", occasion);
        response.addObject("action", "edit");

        return response;
    }

    @PostMapping("/create")
    public RedirectView createDesign(
            @ModelAttribute OccasionRequest body
    ) {
        occasionService.createOccasion(body);

        return new RedirectView("/occasions");
    }

    @PostMapping("/update/{id}")
    public RedirectView updateOccasion(
            @PathVariable(name = "id") Long id,
            @ModelAttribute OccasionRequest body
    ) {
        occasionService.updateOccasion(id, body);

        return new RedirectView("/occasions");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteOccasion(
            @PathVariable(name = "id") Long id
    ) {
        occasionService.deleteOccasion(id);

        return new RedirectView("/occasions");
    }
}
