package com.ercan.service;

import java.util.List;

import com.ercan.domain.Kitap;
import com.ercan.domain.Ogrenci;

public interface OgrenciService {

	public List<Ogrenci> getOgrenciler();

	public Ogrenci getOgrenci(int ogrenciId);

	public List<Kitap> getKitaplar();

	public void saveOgrenci(Ogrenci ogr);
}
