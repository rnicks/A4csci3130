package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField, businessNumField, primaryBusinessField, addressField, provinceField;
    Business receivedBusinessInfo;
    private MyApplicationData appState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");
        appState = ((MyApplicationData) getApplicationContext());


        businessNumField = (EditText) findViewById(R.id.business_number);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        primaryBusinessField = (EditText) findViewById(R.id.primary_business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);


        if(receivedBusinessInfo != null){
            businessNumField.setText(receivedBusinessInfo.businessNumber);
            nameField.setText(receivedBusinessInfo.name);
            emailField.setText(receivedBusinessInfo.email);
            primaryBusinessField.setText(receivedBusinessInfo.primaryBusiness);
            addressField.setText(receivedBusinessInfo.address);
            provinceField.setText(receivedBusinessInfo.province);

        }
    }

    /**
     * updates the current business info based on the newly provided info
     * retrieves the existing bID in order to overwrite the existing record
     * @param v
     */
    public void updateContact(View v){

        String bID = receivedBusinessInfo.bID;
        String businessNumber = businessNumField.getText().toString();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String primaryBusiness = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Business business = new Business(bID, businessNumber, name, email, primaryBusiness, address, province);

        appState.firebaseReference.child(bID).setValue(business);

        finish();
    }

    public void eraseContact(View v)
    {

        String bID = receivedBusinessInfo.bID;
        appState.firebaseReference.child(bID).removeValue();
        finish();
    }
}
