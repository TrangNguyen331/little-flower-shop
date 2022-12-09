package com.thuytrang.littleflowershop.controller.web;

import com.thuytrang.littleflowershop.model.EColor;
import com.thuytrang.littleflowershop.payload.request.FlowerRequest;
import com.thuytrang.littleflowershop.payload.response.FlowerResponse;
import com.thuytrang.littleflowershop.service.FlowerService;
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
@RequestMapping("/flowers")
public class FlowerWebController {
    @Autowired
    private FlowerService flowerService;

    @GetMapping("/form")
    public ModelAndView showFormCreate() {
        ModelAndView response = new ModelAndView("/admin/flower/form");
        response.addObject("flower", new FlowerRequest());
        response.addObject("colors", EColor.values());
        response.addObject("action", "create");

        return response;
    }

    @GetMapping("/filter")
    public  ModelAndView filterFlowers(
        @RequestParam(name = "by") String by,
        @RequestParam(name = "keyword") String keyword
    ) {
        ModelAndView response = new ModelAndView("/admin/flower/list");
        List<FlowerResponse> flowers = flowerService.filterFlowers(by, keyword);
        response.addObject("flowers", flowers);
        response.addObject("colors", EColor.values());

        return  response;
    }

    @GetMapping("/list")
    public ModelAndView retrievalFlowers() {
        ModelAndView response = new ModelAndView("/admin/flower/list");
        List<FlowerResponse> flowers = flowerService.retrievalFlowers();
        response.addObject("flowers", flowers);
        response.addObject("colors", EColor.values());

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView detailFlower(
        @PathVariable(name = "id") Long id
    ) {
        ModelAndView response = new ModelAndView("/admin/flower/form");
        FlowerResponse flower = flowerService.detailFlower(id);
        response.addObject("flower", flower);
        response.addObject("colors", EColor.values());
        response.addObject("action", "edit");

        return response;
    }

    @PostMapping("/create")
    public RedirectView createFlower(
        @ModelAttribute FlowerRequest body
    ) {
        flowerService.createFlower(body);

        return new RedirectView("/flowers/list");
    }

    @PostMapping("/update/{id}")
    public RedirectView updateFlower(
        @PathVariable(name = "id") Long id,
        @ModelAttribute FlowerRequest body
    ) {
        flowerService.updateFlower(id, body);

        return new RedirectView("/flowers/list");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteFlower(
        @PathVariable(name = "id") Long id
    ) {
        flowerService.deleteFlower(id);

        return new RedirectView("/flowers/list");
    }
}
