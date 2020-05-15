package com.ercan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ercan.domain.Kitap;
import com.ercan.domain.Ogrenci;
import com.ercan.service.OgrenciService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	OgrenciService ogrenciService;
	String status;

	@GetMapping("/")
	public String home() {
		status = null;
		return "home";
	}

	@GetMapping("/ogrenciler")
	public String ogrenciList(Model model) {
		List<Ogrenci> ogrenci_listesi = ogrenciService.getOgrenciler();
		model.addAttribute("ogrenciler", ogrenci_listesi);
		model.addAttribute("status", status);
		return "home";
	}

	@GetMapping("/ogrenci-mezun-et")
	public String mezunEt(@RequestParam("ogrenciId") int ogrId, Model model) {
		Ogrenci ogrenci = ogrenciService.getOgrenci(ogrId);
		List<Kitap> kitap = ogrenciService.getKitaplar();
		int sayac = 0;
		int i = 0;

		for (Kitap kitapList : kitap) {
			if (kitapList.getOgrenci_id() != null) {
				if (kitapList.getOgrenci_id() == ogrenci.getId()) {
					sayac++;

				}
			}
		}
		if (sayac == 0) {
			if (ogrenci.getMezuniyet() == null) {
				ogrenci.setMezuniyet("mezun");
				ogrenciService.saveOgrenci(ogrenci);
				status = "SUCCESS : Mezun edildi...";
				return "redirect:/ogrenciler";
			} else {
				status = "WARNING : Zaten mezun edildi...";
				return "redirect:/ogrenci-status";
			}
		} else {
			status = "ERROR :Kütüphane ile ilişiği bulunmaktadır! Mezun edilemedi...";
			return "redirect:/ogrenciler";
		}

	}

	@GetMapping("/ogrenci-status")
	public String statusOgrenci(Model model) {

		model.addAttribute("status", status);

		return "redirect:/ogrenciler";
	}

}
