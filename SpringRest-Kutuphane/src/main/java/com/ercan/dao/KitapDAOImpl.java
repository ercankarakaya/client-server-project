package com.ercan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.ercan.domain.Kitap;
import com.ercan.domain.Ogrenci;

@Repository
public class KitapDAOImpl implements KitapDAO {

	@Autowired
	SessionFactory sessionFactory;

	final String serverUrl = "http://localhost:8081/SpringRest-OgrencIsleri/api/rest-ogrenciler/";
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public Ogrenci getOgrenci(int ogrId) {

		return restTemplate.getForObject(serverUrl + ogrId, Ogrenci.class);
	}

	@Override
	public List<Ogrenci> getOgrenciler() {

		ResponseEntity<List<Ogrenci>> respEntity = restTemplate.exchange(serverUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Ogrenci>>() {
				});
		return respEntity.getBody();
	}

	@Override
	public List<Kitap> getKitaplar() {
		Session session = sessionFactory.getCurrentSession();
		List<Kitap> kitaplar;
		Query<Kitap> query = session.createQuery("from Kitap", Kitap.class);
		kitaplar = query.getResultList();

		return kitaplar;
	}

	@Override
	public Kitap getKitap(int kitapId) {
		Session session = sessionFactory.getCurrentSession();
		Kitap kitap = session.get(Kitap.class, kitapId);
		return kitap;
	}

	@Override
	public void saveKitap(Kitap kitap) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(kitap);

	}

}
