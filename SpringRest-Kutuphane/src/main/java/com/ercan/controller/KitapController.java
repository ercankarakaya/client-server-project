package com.ercan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ercan.domain.Kitap;
import com.ercan.domain.Ogrenci;
import com.ercan.service.KitapService;

@Controller
@RequestMapping("/")
public class KitapController {

	@Autowired
	KitapService kitapService;

	@GetMapping("/")
	public String home() {
		return "home";

	}

	@GetMapping("/kitaplar")
	public String kitaplar(Model model) {
		List<Kitap> kitapList = kitapService.getKitaplar();
		model.addAttribute("kitaplar", kitapList);
		return "home";
	}

	@GetMapping("/ogrenci-kitap-form")
	public String kitapVer(@RequestParam("kitapId") int kitapId, Model model) {

		Kitap kitap = kitapService.getKitap(kitapId);
		model.addAttribute("kitap", kitap);

		return "kitap-form";
	}

	@PostMapping("/kitap-kaydet")
	public String kitapKaydet(@ModelAttribute("kitap") Kitap kitap, Model model) {
		List<Ogrenci> ogrList = kitapService.getOgrenciler();
		int sayac = 0;
		for (Ogrenci ogrenci : ogrList) {

			if (ogrenci.getId() == kitap.getOgrenci_id() && (ogrenci.getMezuniyet()==null)
					|| kitap.getOgrenci_id() == null) {

				System.out.println(ogrenci.getMezuniyet());
				sayac++;

			}
		}
		if (sayac > 0) {
			model.addAttribute("message", "Kitap verildi..");
			kitapService.saveKitap(kitap);
			return "redirect:/kitaplar";
		} else {
			model.addAttribute("message", " Böyle bir öğrenci yok!!!");
			return "kitap-form";
		}

	}

}
