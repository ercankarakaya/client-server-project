package com.ercan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ercan.dao.KitapDAO;
import com.ercan.domain.Kitap;
import com.ercan.domain.Ogrenci;

@Service
public class KitapServiceImpl implements KitapService {
	@Autowired
	private KitapDAO kitapDao;

	@Transactional
	@Override
	public List<Kitap> getKitaplar() {

		return kitapDao.getKitaplar();
	}

	@Transactional
	@Override
	public Kitap getKitap(int kitapId) {

		return kitapDao.getKitap(kitapId);
	}

	@Override
	public Ogrenci getOgrenci(int ogrId) {

		return kitapDao.getOgrenci(ogrId);
	}

	@Override
	public List<Ogrenci> getOgrenciler() {

		return kitapDao.getOgrenciler();
	}

	@Transactional
	@Override
	public void saveKitap(Kitap kitap) {
		kitapDao.saveKitap(kitap);

	}

}
