package com.ercan.domain;

public class Kitap {

	private Integer id;

	private String kitap_adi;

	private String kitap_yazari;

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

	@Override
	public String toString() {
		return "Kitap [id=" + id + ", kitap_adi=" + kitap_adi + ", kitap_yazari=" + kitap_yazari + ", ogrenci_id="
				+ ogrenci_id + "]";
	}

}
