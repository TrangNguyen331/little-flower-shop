package com.thuytrang.littleflowershop.controller.web;

import com.thuytrang.littleflowershop.controller.DesignControler;
import com.thuytrang.littleflowershop.payload.request.DesignRequest;
import com.thuytrang.littleflowershop.payload.response.DesignResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/designs")
public class DesignWebController extends DesignControler {
    @Override
    public ModelAndView retrievalDesigns() {
        ModelAndView response = new ModelAndView("/design/list");
        List<DesignResponse> designs = designService.retrievalDesigns();
        response.addObject("designs", designs);

        return response;
    }

    @Override
    public ModelAndView detailDesign(Long id) {
        return null;
    }

    @Override
    public RedirectView createDesign(
        @ModelAttribute DesignRequest body
    ) {
        return null;
    }

    @Override
    public RedirectView updateDesign(
        Long id,
        @ModelAttribute DesignRequest body) {
        return null;
    }

    @Override
    public RedirectView deleteDesign(Long id) {
        return null;
    }
}
