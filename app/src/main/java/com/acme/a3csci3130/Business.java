package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * class to define how business data will be stored in firebase database
 * Created by robertnickerson on 2018-03-13.
 */

public class Business implements Serializable {
    public int businessNumber;
    public String name;
    public String email;
    public String primaryBusiness;
    public String address;
    public String province;

    public Business()
    {

    }

    public Business(int businessNumber, String name, String email, String primaryBusiness, String address, String province)
    {
        this.businessNumber = businessNumber;
        this.name = name;
        this.email = email;
        this.primaryBusiness = primaryBusiness;
        this.address = address;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("businessNumber", businessNumber);
        result.put("name", name);
        result.put("email", email);
        result.put("primaryBusiness", primaryBusiness);
        result.put("address", address);
        result.put("province", province);

        return result;
    }

}
