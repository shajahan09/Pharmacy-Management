package com.test.pharmecyproject.rest;

import com.test.pharmecyproject.model.Company;
import com.test.pharmecyproject.model.Medicine;
import com.test.pharmecyproject.model.Sale;
import com.test.pharmecyproject.model.Staff;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("/SpringWithHibernate/company")
    Call<List<Company>> getCompany();

    @POST("/SpringWithHibernate/saveCompanyList/")
    Call<Company> insertStaffList(@Body Company company);


    @GET("/SpringWithHibernate/sale")
    Call<List<Sale>> getSale();

    @POST("/SpringWithHibernate/saveSaleList/")
    Call<Sale> insertSaleList(@Body Sale sale);


    @GET("/SpringWithHibernate/staff")
    Call<List<Staff>> getStaff();

    @POST("/SpringWithHibernate/saveStaffList/")
    Call<Staff> insertStaffList(@Body Staff staff);


    @GET("/SpringWithHibernate/medicine")
    Call<List<Medicine>> getMedicine();

    @POST("/SpringWithHibernate/saveMedicineList/")
    Call<Medicine> insertMedeineList(@Body Medicine medicine);

    @PUT("/updateMedicine/id")
    Call<Medicine> updateMedicine(@Path("id") int id, @Body Medicine medicine);

    @DELETE("/deleteMedicine/(id)")
    Call<Medicine> deleteMedicine(@Path("id") int id);


}
