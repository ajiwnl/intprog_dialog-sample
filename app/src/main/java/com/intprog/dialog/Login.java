package com.intprog.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends AppCompatActivity {

    public static String username = "bonk";
    public static String password = "alvin123";
    EditText user, pass;
    Button btn;

    private void showInvalidUsernameDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Invalid Username")
                .setMessage("The username you entered is incorrect. Please try again.")
                .setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // Method to show a dialog for invalid password
    private void showInvalidPasswordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Invalid Password")
                .setMessage("The password you entered is incorrect. Please try again.")
                .setNegativeButton("Cancel", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.userid);
        pass = findViewById(R.id.passid);
        btn = findViewById(R.id.btn1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inUser = user.getText().toString();
                String inPass = pass.getText().toString();


                if(inUser.equals(username) && inPass.equals(password)) {
                    Intent navprofile = new Intent(Login.this,Dashboard.class);
                    startActivity(navprofile);
                }else {
                    if (!inUser.equals(username)) {
                        showInvalidUsernameDialog();
                    } else {
                        showInvalidPasswordDialog();
                    }
                }
            }
        });


    }
}