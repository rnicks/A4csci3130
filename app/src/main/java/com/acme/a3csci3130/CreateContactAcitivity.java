package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * class for the Activity used to create a new business in the database
 */
public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, emailField, businessNumField, primaryBusinessField, addressField, provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        businessNumField = (EditText) findViewById(R.id.business_number);
        primaryBusinessField = (EditText) findViewById(R.id.primary_business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

    }

    /**
     * action performed by submit button
     * creates a new Business object based on user input, inserts to database
     * @param v
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String bID = appState.firebaseReference.push().getKey();
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
}
