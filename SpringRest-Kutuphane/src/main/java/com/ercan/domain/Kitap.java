package com.ercan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kitap")
public class Kitap {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "kitap_adi")
	private String kitap_adi;
	@Column(name = "kitap_yazari")
	private String kitap_yazari;
	
	@Column(name = "ogrenci_id")
	private Integer ogrenci_id;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKitap_adi() {
		return kitap_adi;
	}

	public void setKitap_adi(String kitap_adi) {
		this.kitap_adi = kitap_adi;
	}

	public String getKitap_yazari() {
		return kitap_yazari;
	}

	public void setKitap_yazari(String kitap_yazari) {
		this.kitap_yazari = kitap_yazari;
	}

	

	public Integer getOgrenci_id() {
		return ogrenci_id;
	}

	public void setOgrenci_id(Integer ogrenci_id) {
		this.ogrenci_id = ogrenci_id;
	}

	
}
