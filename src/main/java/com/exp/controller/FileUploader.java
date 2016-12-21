package com.exp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileUploader {
	
	@RequestMapping("/pic")
	public String showForm(){
		return "picUpload";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadPic(){
		return "picture";
	}
}
