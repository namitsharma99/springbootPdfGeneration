package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.PdfGenerateService;

@RestController
public class DemoController {
	
	@Autowired
    private PdfGenerateService pdfGenerateService;
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "demo";
	}
	
	@RequestMapping("/home")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo.html");
        return modelAndView;
    }  
	
	@RequestMapping("/generatePdf")
	@ResponseBody
	public String generatePdf() {
		// https://simplesolution.dev/spring-boot-generate-pdf-file-from-html-template/
		
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("test", "test");
		pdfGenerateService.generatePdfFile("demo", data, "demo.pdf");

	    
		return "Done!!";
	}
}
