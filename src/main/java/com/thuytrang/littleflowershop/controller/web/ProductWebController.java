package com.thuytrang.littleflowershop.controller.web;

import com.thuytrang.littleflowershop.payload.request.ProductRequest;
import com.thuytrang.littleflowershop.payload.response.DesignResponse;
import com.thuytrang.littleflowershop.payload.response.FlowerResponse;
import com.thuytrang.littleflowershop.payload.response.OccasionResponse;
import com.thuytrang.littleflowershop.payload.response.ProductResponse;
import com.thuytrang.littleflowershop.service.DesignService;
import com.thuytrang.littleflowershop.service.FlowerService;
import com.thuytrang.littleflowershop.service.OccasionService;
import com.thuytrang.littleflowershop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/products")
public class ProductWebController {
    @Autowired
    private ProductService productService;

    @Autowired
    private DesignService designService;

    @Autowired
    private FlowerService flowerService;

    @Autowired
    private OccasionService occasionService;

    @GetMapping("/form")
    public ModelAndView showFormCreate() {
        ModelAndView response = new ModelAndView("/admin/product/form");
        List<DesignResponse> designs = designService.retrievalDesigns();
        List<FlowerResponse> flowers = flowerService.retrievalFlowers();
        List<OccasionResponse> occasions = occasionService.retrievalOccasions();

        response.addObject("product", new ProductRequest());
        response.addObject("designs", designs);
        response.addObject("flowers", flowers);
        response.addObject("occasions", occasions);
        response.addObject("action", "create");

        return response;
    }

    @GetMapping("/filter")
    public ModelAndView filterFlowers(
        @RequestParam(name = "by") String by,
        @RequestParam(name = "keyword") String keyword
    ) {
        ModelAndView response = new ModelAndView("/admin/product/list");
        List<ProductResponse> products = productService.filterProducts(by, keyword);
        List<DesignResponse> designs = designService.retrievalDesigns();

        response.addObject("products", products);
        response.addObject("designs", designs);

        return response;
    }

    @GetMapping("/list")
    public ModelAndView retrievalProducts() {
        ModelAndView response = new ModelAndView(("/admin/product/list"));
        List<ProductResponse> products = productService.retrievalProducts();
        List<DesignResponse> designs = designService.retrievalDesigns();

        response.addObject("products", products);
        response.addObject("designs", designs);

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView detailProduct(
        @PathVariable(name = "id") Long id
    ) {
        ModelAndView response = new ModelAndView("/admin/product/form");
        ProductResponse product = productService.detailProduct(id);
        List<DesignResponse> designs = designService.retrievalDesigns();
        List<OccasionResponse> occasions = occasionService.retrievalOccasions();
        List<FlowerResponse> flowers = flowerService.retrievalFlowers();

        response.addObject("product", product);
        response.addObject("designs", designs);
        response.addObject("flowers", flowers);
        response.addObject("occasions", occasions);
        response.addObject("action", "edit");

        return response;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProduct(
        @PathVariable(name = "id") Long id
    ) {
        ModelAndView response = new ModelAndView("/admin/product/view");
        ProductResponse product = productService.detailProduct(id);

        response.addObject("product", product);

        return response;
    }

    @PostMapping("/create")
    public RedirectView createProduct(
        @ModelAttribute ProductRequest body
    ) {
        productService.createProduct(body);

        return new RedirectView("/products/list");
    }

    @PostMapping("/update/{id}")
    public RedirectView updateProduct(
        @PathVariable(name = "id") Long id,
        @ModelAttribute ProductRequest body
    ) {
        productService.updateProduct(id, body);

        return new RedirectView("/products/list");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteProduct(
        @PathVariable(name = "id") Long id
    ) {
        productService.deleteProduct(id);

        return new RedirectView("/products/list");
    }
}
