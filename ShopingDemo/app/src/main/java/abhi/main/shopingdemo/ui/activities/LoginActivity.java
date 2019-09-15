package abhi.main.shopingdemo.ui.activities;

import abhi.main.shopingdemo.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUserEmail,etUserPassword;
    Button btnLogin;
    TextView tv_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_fragment_layout);
        etUserEmail = findViewById(R.id.userEmail);
        etUserPassword = findViewById(R.id.userPassword);
        tv_sign_up = findViewById(R.id.tv_sign_up);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        tv_sign_up.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.tv_sign_up:
                startActivity(new Intent(this,RegActivity.class));
                break;
            case R.id.tv_forgot_password:
                break;
            case R.id.btn_login:
              //  handleLogin();
                break;


        }
    }
}
