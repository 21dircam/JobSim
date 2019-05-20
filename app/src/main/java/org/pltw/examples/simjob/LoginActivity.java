package org.pltw.examples.simjob;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;



import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private Button btLogin;
    private Button btSignup;
    private EditText etName;
    private EditText etEmailAddress;
    private EditText etPassword;
    private TextView tvSignup;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btLogin = findViewById(R.id.bt_login);
        etName = findViewById(R.id.et_name);
        etEmailAddress = findViewById(R.id.et_email_address);
        etPassword = findViewById(R.id.et_password);
        tvSignup = findViewById(R.id.tv_signup);
        btSignup = findViewById(R.id.bt_signup);

        Backendless.initApp(
                getString(R.string.backendless_app_id),
                getString(R.string.backendless_android_api_key));

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btLogin.getVisibility() == View.VISIBLE) {
                    btLogin.setVisibility(View.GONE);
                    etName.setVisibility(View.VISIBLE);
                    btSignup.setVisibility(View.VISIBLE);
                    tvSignup.setText(R.string.cancel_sign_up);
                } else {
                    btLogin.setVisibility(View.VISIBLE);
                    etName.setVisibility(View.GONE);
                    btSignup.setVisibility(View.GONE);
                    tvSignup.setText(R.string.sign_me_up);
                }
            }
        });

        btSignup.setOnClickListener(new SignUpOnClickListener());

        btLogin.setOnClickListener(new LoginOnClickListener());
    }



    private class SignUpOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String emailAddress = etEmailAddress.getText().toString();
            String name = etName.getText().toString();
            String password = etPassword.getText().toString();

            emailAddress = emailAddress.trim();
            name = name.trim();
            password = password.trim();

            if(validateEmail(emailAddress) == false ){
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage(R.string.error_invalid_email);
                builder.setTitle(R.string.authentication_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog;
                dialog = builder.create();
                dialog.show();
            } else if(validatePassword(password) == false){
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage(R.string.error_invalid_password);
                builder.setTitle(R.string.authentication_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog;
                dialog = builder.create();
                dialog.show();
            }
            else if (!emailAddress.isEmpty() && !name.isEmpty() && !password.isEmpty()) {

                BackendlessUser user = new BackendlessUser();
                user.setEmail(emailAddress);
                user.setPassword(password);
                user.setProperty("name", name);

                Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Log.i(TAG, "User was successfully registered");

                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Log.i(TAG, fault.getMessage());

                    }

                });
            }else{
                Log.i(TAG, "There was a problem with signing up");
                //warnUser(getString(R.string.authentication_error_title));

                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage(R.string.empty_field_signup_error);
                builder.setTitle(R.string.authentication_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog;
                dialog = builder.create();
                dialog.show();

            }
        }
    }

    private void warnUser(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage(R.string.empty_field_signup_error);
        builder.setTitle(R.string.authentication_error_title);
        builder.setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog;
        dialog = builder.create();
        dialog.show();
    }
    public boolean validateEmail(String email){
        String emailAddress = etEmailAddress.getText().toString();
        boolean isValidEmail = false;
        // Input the string for validation
        // String email = "xyz@.com";
        // Set the email pattern string
        Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);

        // Match the given string with the pattern
        Matcher m = p.matcher(email);

        // check whether match is found
        boolean matchFound = m.matches();

        StringTokenizer st = new StringTokenizer(email, ".");
        String lastToken = null;
        while (st.hasMoreTokens()) {
            lastToken = st.nextToken();
        }
        if (matchFound && lastToken.length() >= 2
                && email.length() - 1 != lastToken.length()) {


            // validate the country code
            isValidEmail = true;
        }
        else isValidEmail = false;

        return isValidEmail;
    }
    public boolean validatePassword(String password) {
        boolean isValidPassword = false;


        if ( password.length() >= 6) {


            // validate the country code
            isValidPassword = true;
        }
        else isValidPassword = false;

        return isValidPassword;
    }

    private class LoginOnClickListener implements View.OnClickListener {
        public void onClick(View view) {
            String emailAddress = etEmailAddress.getText().toString();
            String password = etPassword.getText().toString();

            emailAddress = emailAddress.trim();
            password = password.trim();

            if (!emailAddress.isEmpty() && !password.isEmpty()) {

                BackendlessUser user = new BackendlessUser();
                user.setEmail(emailAddress);
                user.setPassword(password);


                Backendless.UserService.login(emailAddress, password, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Log.i(TAG, "login successful");
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Log.i(TAG, fault.getMessage());

                    }
                });
            } else {
                //warnUser(getString(R.string.authentication_error_title));
                Log.i(TAG, "There was a problem with signing up");

                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage(R.string.empty_field_signup_error);
                builder.setTitle(R.string.authentication_error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog;
                dialog = builder.create();
                dialog.show();
            }
        }
    }

}



