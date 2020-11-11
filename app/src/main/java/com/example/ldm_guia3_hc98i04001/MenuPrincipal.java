package com.example.ldm_guia3_hc98i04001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Button btnL  = findViewById(R.id.btn_Lista);
        Button btnA = findViewById(R.id.btn_AgregarN);
        Button btnM = findViewById(R.id.btn_MisDatos);

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent VerLista = new Intent(MenuPrincipal.this,VerLista.class);
                startActivity(VerLista);
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AgregarNombre = new Intent(MenuPrincipal.this,AgregarNombre.class);
                startActivity(AgregarNombre);
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Datos = new Intent(MenuPrincipal.this,MisDatos.class);
                startActivity(Datos);
            }
        });


    }
}