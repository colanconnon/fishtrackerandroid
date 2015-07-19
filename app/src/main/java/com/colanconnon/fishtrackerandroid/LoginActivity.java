package com.colanconnon.fishtrackerandroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.colanconnon.fishtrackerandroid.AsyncTasks.LoginAsyncTask;

import org.json.JSONObject;




public class LoginActivity extends Activity {

    private Button btnLogin;
    private Button btnSignUp;
    private EditText emailTxt;
    private EditText passwordTxt;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        emailTxt = (EditText) findViewById(R.id.txtEmail);
        passwordTxt = (EditText) findViewById(R.id.txtPassword);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public void onClick(View v) {
                LoginAsyncTask loginAsyncTask = new LoginAsyncTask(emailTxt.getText().toString(), passwordTxt.getText().toString());
                try
                {
                    progress = ProgressDialog.show(LoginActivity.this , "Processing Login",
                            "Please wait....", true);
                    JSONObject json = loginAsyncTask.execute().get();
                    progress.hide();
                    String token = json.getString("access_token");
                    SharedPreferences prefs = LoginActivity.this.getSharedPreferences(
                            "com.colanconnon.fishtrackerandroid", Context.MODE_PRIVATE);
                    prefs.edit().putString("Token", token).commit();
                    Toast.makeText(LoginActivity.this, "You are now logged in!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, FishCatchesActivity.class);
                    LoginActivity.this.startActivity(intent);

                } catch (Exception e)
                {
                    Toast.makeText(LoginActivity.this, "The login has failed, please check connection and try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
