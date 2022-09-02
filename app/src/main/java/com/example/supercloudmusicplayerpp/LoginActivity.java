package com.example.supercloudmusicplayerpp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private Button createAccButton;
    private TextView clientResponse;
    private CheckBox rememberMe;
    private TextInputEditText user;
    private TextInputEditText password;
    private SharedPreferences sharedPref;
    private static final String USER_KEY = "USERNAME";
    private static final String PASS_KEY = "PASSWORD";
    private static final String CHECKED_KEY = "CHECKED";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginButton = (Button) findViewById(R.id.Login);
        createAccButton = (Button) findViewById(R.id.create_account);
        clientResponse = (TextView) findViewById(R.id.clientResponse);
        rememberMe = (CheckBox) findViewById(R.id.rememberCheckBox);
        user = (TextInputEditText) findViewById(R.id.userLogin);
        password = (TextInputEditText) findViewById(R.id.passLogin);
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        user.setText(sharedPref.getString(USER_KEY, ""));
        password.setText(sharedPref.getString(PASS_KEY, ""));
        rememberMe.setChecked(sharedPref.getBoolean(CHECKED_KEY, false));
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();


    }

    public void onLoginButton(View view) {
        TextView clientResponse = (TextView) findViewById(R.id.clientResponse);
        String username = Objects.requireNonNull(user.getText()).toString();
        String pass = Objects.requireNonNull(password.getText()).toString();
        if (username.toString().isEmpty() || pass.toString().isEmpty()) {
            clientResponse.setText(R.string.login);
        } else {
            signIn(username, pass);
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if(currentUser != null){
                startMain(1, username, pass);
            }
            // savePreferences();
        }
    }

    public void onCreateAccountButton(View view){
        TextView clientResponse = (TextView) findViewById(R.id.clientResponse);
        String username = Objects.requireNonNull(user.getText()).toString();
        String pass = Objects.requireNonNull(password.getText()).toString();
        if (username.toString().isEmpty() || pass.toString().isEmpty()) {
            clientResponse.setText(R.string.login);
        } else {
            createAccount(username, pass);
            startMain(1, username, pass);
            // savePreferences();
        }
    }

    public void startMain(int userid, String username, String password) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("userid", userid);
        intent.putExtra("current_username", username);
        startActivity(intent);
    }


    private void createAccount(String email, String password){
        boolean res;
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("createAccount", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("createAccount", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });
    }

    private void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("signIn", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("signIn", "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void savePreferences()
    {
        SharedPreferences.Editor editor = sharedPref.edit();
        if(rememberMe.isChecked())
        {
            editor.putBoolean(CHECKED_KEY,true);
            editor.putString(USER_KEY, Objects.requireNonNull(user.getText()).toString());
            editor.putString(PASS_KEY, Objects.requireNonNull(password.getText()).toString());
        }
        else
        {
            editor.putBoolean(CHECKED_KEY,false);
            editor.putString(USER_KEY,"");
            editor.putString(PASS_KEY, "");
        }
        editor.apply();
    }
}
