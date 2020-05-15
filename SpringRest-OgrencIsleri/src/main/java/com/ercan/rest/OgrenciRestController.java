package com.ercan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ercan.domain.Ogrenci;
import com.ercan.service.OgrenciService;

@RestController
@RequestMapping("/api")
public class OgrenciRestController {

	@Autowired
	private OgrenciService ogrenciService;

	@GetMapping("/rest-ogrenciler")
	public List<Ogrenci> ogrenciler(Model model) {
		List<Ogrenci> ogrenciList = ogrenciService.getOgrenciler();
		model.addAttribute("restOgrenciler", ogrenciList);
		return ogrenciList;
	}

	@GetMapping("/rest-ogrenciler/{ogrId}")
	public Ogrenci ogrenci(@PathVariable int ogrId) {
		return ogrenciService.getOgrenci(ogrId);
	}

}
