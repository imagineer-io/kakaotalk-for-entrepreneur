package io.imagineer.imagineertalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mConfirmButton;

    private String mPageType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mEmailEditText = (EditText) findViewById(R.id.emailEditText);
        mPasswordEditText = (EditText) findViewById(R.id.passwordEditText);
        mConfirmButton = (Button) findViewById(R.id.confirmButton);

        Intent intent = getIntent();
        boolean isSignUp = intent.getBooleanExtra("isSignUp", false);
        if (isSignUp) {
            mPageType = "Sign Up";
        } else {
            mPageType = "Log In";
        }

        mConfirmButton.setText(mPageType);
    }
}
