package com.exp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploader {

	private final Path rootLoc = Paths.get("uploadImages");

	@RequestMapping("/pic")
	public String showForm() {
		return "picUpload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadPic(@RequestBody MultipartFile file, RedirectAttributes redirectAttributes) {
		// String rootPath = System.getProperty("catalina.home");
		// System.out.println(rootPath);

		// System.out.println(rootPath);
		// File dir = new File(rootPath + File.separator + "uploadedImages");

		// System.out.println(dir.getAbsolutePath());
		// File fl = new
		// File(dir.getAbsolutePath()+File.separator+file.getOriginalFilename());
		System.out.println(this.rootLoc.resolve(file.getOriginalFilename()));
		try {

			Files.copy(file.getInputStream(), this.rootLoc.resolve(file.getOriginalFilename()));
			redirectAttributes.addFlashAttribute("message", "File " + file.getOriginalFilename() + " saved.");
			// System.out.println(this.rootLoc.resolve(file.getOriginalFilename()));
			// file.transferTo(fl);
		} catch (IllegalStateException | IOException e) {

			redirectAttributes.addFlashAttribute("message", "File " + file.getOriginalFilename() + "not saved.");
			e.printStackTrace();
		}
		return "redirect:/pic";
	}

	@RequestMapping("/view")
	public String viewPicList(ModelMap map) {

		File dir = new File(this.rootLoc.toString());
		String[] files = dir.list();
		map.addAttribute("filesList", files);
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
		return "picture";
	}
	
	@RequestMapping(value="/view/{fileName}/")
	public String selectPic(@PathVariable("fileName") String file,ModelMap map){
		map.addAttribute("file", file);
		return "img";
	}
	
	@RequestMapping(value="/{fileName}/")
	@ResponseBody
	public byte[] viewPic(@PathVariable("fileName") String file ){
		byte[] bytes= null ;
		String trueName = file;
		System.out.println("file name"+trueName);
		try {
			bytes = Files.readAllBytes(this.rootLoc.resolve(trueName));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}

}
