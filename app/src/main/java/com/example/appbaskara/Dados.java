package com.example.appbaskara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Dados extends AppCompatActivity {

    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        txtResultado = (TextView)findViewById(R.id.txtResultado);

        Intent recebeDados = getIntent();
        Bundle bundle = recebeDados.getExtras();
        txtResultado.setText(bundle.getString("dados"));
    }
}
