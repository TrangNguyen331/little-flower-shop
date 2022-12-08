package com.thuytrang.littleflowershop.controller.web;

import com.thuytrang.littleflowershop.payload.request.DesignRequest;
import com.thuytrang.littleflowershop.payload.response.DesignResponse;
import com.thuytrang.littleflowershop.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/designs")
public class DesignWebController {
    @Autowired
    private DesignService designService;

    @GetMapping("/form")
    public ModelAndView showFormCreate() {
        ModelAndView response = new ModelAndView("/admin/design/form");
        response.addObject("design", new DesignRequest());
        response.addObject("action", "create");

        return response;
    }

    @GetMapping("/list")
    public ModelAndView retrievalDesigns() {
        ModelAndView response = new ModelAndView("/admin/design/list");
        List<DesignResponse> designs = designService.retrievalDesigns();
        response.addObject("designs", designs);

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView detailDesign(
        @PathVariable(name = "id") Long id
    ) {
        ModelAndView response = new ModelAndView("/admin/design/form");
        DesignResponse design = designService.detailDesign(id);
        response.addObject("design", design);
        response.addObject("action", "edit");

        return response;
    }

    @PostMapping("/create")
    public RedirectView createDesign(
        @ModelAttribute DesignRequest body
    ) {
        designService.createDesign(body);

        return new RedirectView("/designs/list");
    }

    @PostMapping("update/{id}")
    public RedirectView updateDesign(
        @PathVariable(name = "id") Long id,
        @ModelAttribute DesignRequest body
    ) {
        designService.updateDesign(id, body);

        return new RedirectView("/designs/list");
    }

    @GetMapping("delete/{id}")
    public RedirectView deleteDesign(
        @PathVariable(name = "id") Long id
    ) {
        designService.deleteDesign(id);

        return new RedirectView("/designs/list");
    }
}
