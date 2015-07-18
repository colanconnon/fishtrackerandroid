package com.colanconnon.fishtrackerandroid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.colanconnon.fishtrackerandroid.AsyncTasks.SignUpAsyncTask;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;


public class SignUpActivity extends Activity {

    private EditText emailTxt;
    private EditText passwordTxt;
    private EditText confirmPasswordTxt;
    private Button signUpBtn;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        emailTxt = (EditText) findViewById(R.id.txtEmailRegister);
        passwordTxt = (EditText) findViewById(R.id.txtPasswordRegister);
        confirmPasswordTxt = (EditText) findViewById(R.id.txtPasswordConfirmRegister);
        signUpBtn = (Button) findViewById(R.id.btnSignUpRegister);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpAsyncTask signUpAsyncTask= new SignUpAsyncTask(emailTxt.getText().toString(),passwordTxt.getText().toString(),confirmPasswordTxt.getText().toString());
                try {
                    progress = ProgressDialog.show(SignUpActivity.this , "Processing Login",
                        "Please wait....", true);

                    JSONObject json = signUpAsyncTask.execute().get();
                    progress.hide();
                    if(json.getInt("success") == 1){
                        Toast.makeText(SignUpActivity.this, "You are now registered", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        SignUpActivity.this.startActivity(intent);
                    }
                    else{
                        String error = json.getString("error");
                        Toast.makeText(SignUpActivity.this, "Error: " + error, Toast.LENGTH_SHORT).show();
                    }


                } catch (Exception e) {
                    Toast.makeText(SignUpActivity.this, "The sign operation has failed, please try again", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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
