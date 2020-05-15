package com.ercan.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ercan.dao.OgrenciDAO;
import com.ercan.domain.Kitap;
import com.ercan.domain.Ogrenci;

@Service
public class OgrenciServiceImpl implements OgrenciService {

	@Autowired
	private OgrenciDAO ogrenciDao;

	@Transactional
	@Override
	public List<Ogrenci> getOgrenciler() {

		return ogrenciDao.getOgrenciler();
	}

	@Transactional
	@Override
	public Ogrenci getOgrenci(int ogrenciId) {

		return ogrenciDao.getOgrenci(ogrenciId);
	}

	@Override
	public List<Kitap> getKitaplar(){
		
		return ogrenciDao.getKitaplar();
	}
	@Transactional
	@Override
	public void saveOgrenci(Ogrenci ogr) {
		ogrenciDao.saveOgrenci(ogr);		
	}

}
