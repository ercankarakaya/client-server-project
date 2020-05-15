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
public class OgrenciDAOImpl implements OgrenciDAO {

	@Autowired
	SessionFactory sessionFactory;

	final String serverUrl = "http://localhost:8081/SpringRest-Kutuphane/api/rest-kitap/";
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Kitap> getKitaplar() {

		ResponseEntity<List<Kitap>> respEntity = restTemplate.exchange(serverUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Kitap>>() {
				});
		return respEntity.getBody();
	}

	@Override
	public List<Ogrenci> getOgrenciler() {
		List<Ogrenci> ogrenciler;
		Session session = sessionFactory.getCurrentSession();
		Query<Ogrenci> query = session.createQuery("from Ogrenci", Ogrenci.class);
		ogrenciler = query.getResultList();
		return ogrenciler;
	}

	@Override
	public Ogrenci getOgrenci(int ogrenciId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Ogrenci.class, ogrenciId);
	}

	@Override
	public void saveOgrenci(Ogrenci ogr) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ogr);

	}

}
