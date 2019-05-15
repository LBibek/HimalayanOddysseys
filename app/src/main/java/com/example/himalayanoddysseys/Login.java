package com.example.himalayanoddysseys;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmailAddress, etPassword;
    private Button btnLogin,btnSinnup,btn_appflow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        etEmailAddress = findViewById(R.id.et_login_email_address);
        etPassword = findViewById(R.id.et_login_pwd);
        btn_appflow = findViewById(R.id.btn_appflow);
        btnLogin = findViewById(R.id.btn_login);
        btnSinnup=findViewById(R.id.btn_signup);
        btnLogin.setOnClickListener(this);
        btnSinnup.setOnClickListener(this);
        btn_appflow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            if (validateFields()) {
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Softwaria");
                progressDialog.setMessage("Please Wait!");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setCanceledOnTouchOutside(true);
                progressDialog.show();
                progressDialog.setCancelable(true);
            }
        }
        if (v.getId() == R.id.btn_signup) {
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit this app!!")
                    .setTitle("HimalayanOddessy")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Login.this.finish();
                        }
                    })
                    .setNegativeButton("Cancil", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            builder.show();
        }

        if (v.getId() == R.id.btn_appflow) {


        }

    }


    private boolean validateFields() {
        if (TextUtils.isEmpty(etEmailAddress.getText().toString())) {
            etEmailAddress.setError("Enter Email Address");
            etEmailAddress.requestFocus();
            return false;

        } else if(TextUtils.isEmpty(etPassword.getText().toString())){
            etPassword.setError("Enter Password");
            etPassword.requestFocus();
            return false;

        }
        else {
            return true;
        }
    }

}
