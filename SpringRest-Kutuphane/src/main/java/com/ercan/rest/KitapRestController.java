package com.ercan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ercan.domain.Kitap;
import com.ercan.service.KitapService;

@RestController
@RequestMapping("/api")
public class KitapRestController {

	@Autowired
	private KitapService kitapService;

	@GetMapping("/rest-kitap")
	public List<Kitap> kitaplar(Model model) {
		List<Kitap> kitapList = kitapService.getKitaplar();
		model.addAttribute("kitaplar", kitapList);
		return kitapList;
	}
	@GetMapping("/rest-kitap/{kitapId}")
	public Kitap kitap(@PathVariable int kitapId) {
		return kitapService.getKitap(kitapId);
	}

}
