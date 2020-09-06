package com.destinyapp.mading.API;


import com.destinyapp.mading.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest {
    @FormUrlEncoded
    @POST("Login")
    Call<ResponseModel> login(@Field("username") String username,
                              @Field("password") String password);

    @GET("Data/AllJurusan")
    Call<ResponseModel> AllJurusan();


    @GET("Berita/AllBerita")
    Call<ResponseModel> AllBerita();

    @GET("Berita/Berita")
    Call<ResponseModel> Berita();

    @GET("Data/TahunAjaran")
    Call<ResponseModel> TahunAjaran();

    @FormUrlEncoded
    @POST("Data/Kelas")
    Call<ResponseModel> Kelas(@Field("id_jurusan") String id_jurusan,
                              @Field("program") String program,
                              @Field("class") String classy);

    @FormUrlEncoded
    @POST("Feedback")
    Call<ResponseModel> FeedBack(@Field("feedback") String feedback,
                                    @Field("tanggal") String tanggal);

    @FormUrlEncoded
    @POST("Jadwal/Pelajaran")
    Call<ResponseModel> JadwalPelajaran(@Field("id_jurusan") String id_jurusan,
                                        @Field("id_kelas") String id_kelas,
                                        @Field("hari") String hari);

    @FormUrlEncoded
    @POST("Jadwal/Ujian")
    Call<ResponseModel> JadwalUjian(@Field("id_jurusan") String id_jurusan,
                                        @Field("id_kelas") String id_kelas,
                                        @Field("tanggal") String tanggal,
                                        @Field("jenis_ujian") String jenis_ujian);

    @FormUrlEncoded
    @POST("Checkabsen")
    Call<ResponseModel> CheckAbsen(@Field("id_karyawan") String id_karyawan,
                                   @Field("tanggal") String tanggal);

    @FormUrlEncoded
    @POST("Insertabsen")
    Call<ResponseModel> InsertAbsen(@Field("id_karyawan") String id_karyawan,
                                    @Field("status") String status,
                                    @Field("tanggal") String tanggal);

    @FormUrlEncoded
    @POST("Editabsen")
    Call<ResponseModel> UpdateAbsen(@Field("id_absensi") String id_absensi,
                                    @Field("status") String status);

    @FormUrlEncoded
    @POST("Insertkaryawan")
    Call<ResponseModel> InsertKaryawan(@Field("username") String username,
                                       @Field("password") String password,
                                       @Field("nama_karyawan") String nama_karyawan,
                                       @Field("divisi") String divisi);


    @FormUrlEncoded
    @POST("Checkemail")
    Call<ResponseModel> CheckEmail(@Field("email") String email);

    @FormUrlEncoded
    @POST("Register")
    Call<ResponseModel> register(@Field("email") String email,
                                 @Field("password") String password,
                                 @Field("nama") String nama,
                                 @Field("alamat") String alamat,
                                 @Field("telpon") String telpon,
                                 @Field("nik") String nik);
}
