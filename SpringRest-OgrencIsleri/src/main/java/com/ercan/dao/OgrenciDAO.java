package com.ercan.dao;

import java.util.List;

import com.ercan.domain.Kitap;
import com.ercan.domain.Ogrenci;

public interface OgrenciDAO {

	public List<Ogrenci> getOgrenciler();

	public Ogrenci getOgrenci(int ogrenciId);

	public List<Kitap> getKitaplar();
	
	public void saveOgrenci(Ogrenci ogr);
}
