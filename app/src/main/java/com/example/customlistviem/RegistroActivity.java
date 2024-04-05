package com.example.customlistviem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroActivity extends AppCompatActivity {

    public Button btn_registro,btn_login;
    public TextView nombres,apellidos,email,password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mAuth = FirebaseAuth.getInstance();

        btn_registro = findViewById(R.id.btn_registro);
        btn_login = findViewById(R.id.btn_login);
        nombres = findViewById(R.id.nombres);
        apellidos = findViewById(R.id.apellidos);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm = nombres.getText().toString().trim();
                String ape = apellidos.getText().toString().trim();
                String ema = email.getText().toString().trim();
                String pwd = password.getText().toString().trim();

                registro(ema,pwd);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regist = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(regist);
            }
        });
    }

    public void registro(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(this, "El registro exitoso", Toast.LENGTH_SHORT).show();
                        Intent home = new Intent(this, MainActivity.class);
                        startActivity(home);
                    } else {
                        Toast.makeText(this, "El registro fallo", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}