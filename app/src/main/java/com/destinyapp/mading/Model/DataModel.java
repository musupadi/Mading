package com.destinyapp.mading.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    //Berita
    @SerializedName("id_berita")
    @Expose
    public String id_berita;

    @SerializedName("judul_berita")
    @Expose
    public String judul_berita;

    @SerializedName("berita")
    @Expose
    public String berita;

    @SerializedName("id_kategori")
    @Expose
    public String id_kategori;

    @SerializedName("gambar")
    @Expose
    public String gambar;

    //Kategori Berita
    @SerializedName("kategori")
    @Expose
    public String kategori;

    //Jurusan
    @SerializedName("id_jurusan")
    @Expose
    public String id_jurusan;

    @SerializedName("nama_jurusan")
    @Expose
    public String nama_jurusan;

    //Kelas
    @SerializedName("id_kelas")
    @Expose
    public String id_kelas;

    @SerializedName("nama_kelas")
    @Expose
    public String nama_kelas;

    @SerializedName("program")
    @Expose
    public String program;

    @SerializedName("class")
    @Expose
    public String Classy;

    //Matkul
    @SerializedName("id_matkul")
    @Expose
    public String id_matkul;

    @SerializedName("nama_matkul")
    @Expose
    public String nama_matkul;

    //User
    @SerializedName("id_user")
    @Expose
    public String id_user;

    @SerializedName("nama")
    @Expose
    public String nama;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("jenis_kelamin")
    @Expose
    public String jenis_kelamin;

    @SerializedName("kontak")
    @Expose
    public String kontak;

    @SerializedName("level")
    @Expose
    public String level;

    @SerializedName("photo")
    @Expose
    public String photo;

    //Jadwal Pelajaran
    @SerializedName("id_jadwal")
    @Expose
    public String id_jadwal;

    @SerializedName("hari")
    @Expose
    public String hari;

    @SerializedName("mulai")
    @Expose
    public String mulai;

    @SerializedName("akhir")
    @Expose
    public String akhir;

    @SerializedName("selesai")
    @Expose
    public String selesai;

    //Ruang
    @SerializedName("id_ruang")
    @Expose
    public String id_ruang;

    @SerializedName("nama_ruang")
    @Expose
    public String nama_ruang;

    //Dosen
    @SerializedName("id_dosen")
    @Expose
    public String id_dosen;

    @SerializedName("nama_dosen")
    @Expose
    public String nama_dosen;

    //Jadwal Ujian
    @SerializedName("id_ujian")
    @Expose
    public String id_ujian;

    @SerializedName("tanggal")
    @Expose
    public String tanggal;

    @SerializedName("jenis_ujian")
    @Expose
    public String jenis_ujian;

    @SerializedName("status")
    @Expose
    public String status;

    public String getId_berita() {
        return id_berita;
    }

    public void setId_berita(String id_berita) {
        this.id_berita = id_berita;
    }

    public String getJudul_berita() {
        return judul_berita;
    }

    public void setJudul_berita(String judul_berita) {
        this.judul_berita = judul_berita;
    }

    public String getBerita() {
        return berita;
    }

    public void setBerita(String berita) {
        this.berita = berita;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getId_jurusan() {
        return id_jurusan;
    }

    public void setId_jurusan(String id_jurusan) {
        this.id_jurusan = id_jurusan;
    }

    public String getNama_jurusan() {
        return nama_jurusan;
    }

    public void setNama_jurusan(String nama_jurusan) {
        this.nama_jurusan = nama_jurusan;
    }

    public String getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getClassy() {
        return Classy;
    }

    public void setClassy(String classy) {
        Classy = classy;
    }

    public String getId_matkul() {
        return id_matkul;
    }

    public void setId_matkul(String id_matkul) {
        this.id_matkul = id_matkul;
    }

    public String getNama_matkul() {
        return nama_matkul;
    }

    public void setNama_matkul(String nama_matkul) {
        this.nama_matkul = nama_matkul;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getMulai() {
        return mulai;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public String getAkhir() {
        return akhir;
    }

    public void setAkhir(String akhir) {
        this.akhir = akhir;
    }

    public String getSelesai() {
        return selesai;
    }

    public void setSelesai(String selesai) {
        this.selesai = selesai;
    }

    public String getId_ruang() {
        return id_ruang;
    }

    public void setId_ruang(String id_ruang) {
        this.id_ruang = id_ruang;
    }

    public String getNama_ruang() {
        return nama_ruang;
    }

    public void setNama_ruang(String nama_ruang) {
        this.nama_ruang = nama_ruang;
    }

    public String getId_dosen() {
        return id_dosen;
    }

    public void setId_dosen(String id_dosen) {
        this.id_dosen = id_dosen;
    }

    public String getNama_dosen() {
        return nama_dosen;
    }

    public void setNama_dosen(String nama_dosen) {
        this.nama_dosen = nama_dosen;
    }

    public String getId_ujian() {
        return id_ujian;
    }

    public void setId_ujian(String id_ujian) {
        this.id_ujian = id_ujian;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJenis_ujian() {
        return jenis_ujian;
    }

    public void setJenis_ujian(String jenis_ujian) {
        this.jenis_ujian = jenis_ujian;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
