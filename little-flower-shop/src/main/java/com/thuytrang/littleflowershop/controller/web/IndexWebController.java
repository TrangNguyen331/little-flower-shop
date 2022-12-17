package com.thuytrang.littleflowershop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexWebController {
    @GetMapping
    public ModelAndView IndexWebView(){
        return new ModelAndView("redirect:/products/list");
    }
}
