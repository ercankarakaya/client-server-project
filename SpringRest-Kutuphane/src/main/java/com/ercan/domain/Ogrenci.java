package com.ercan.domain;

public class Ogrenci {

	private Integer id;

	private String isim;

	private String soyisim;

	private int ogrenci_no;

	private String mezuniyet;

	public Ogrenci(String isim, String soyisim, int ogrenci_no, String mezuniyet) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.ogrenci_no = ogrenci_no;
		this.mezuniyet = mezuniyet;
	}

	public Ogrenci() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public int getOgrenci_no() {
		return ogrenci_no;
	}

	public void setOgrenci_no(int ogrenci_no) {
		this.ogrenci_no = ogrenci_no;
	}

	public String getMezuniyet() {
		return mezuniyet;
	}

	public void setMezuniyetTarihi(String mezuniyet) {
		this.mezuniyet = mezuniyet;
	}

	@Override
	public String toString() {
		return "Ogrenci [id=" + id + ", isim=" + isim + ", soyisim=" + soyisim + ", ogrenci_no=" + ogrenci_no
				+ ", mezuniyetTarihi=" + mezuniyet + "]";
	}

}
