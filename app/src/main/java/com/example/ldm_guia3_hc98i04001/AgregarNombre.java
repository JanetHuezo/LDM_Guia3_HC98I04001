package com.example.ldm_guia3_hc98i04001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AgregarNombre extends AppCompatActivity {
    private List<TaskModel> taskList;
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nombre);
        final EditText nombre = findViewById(R.id.txtNom);
        Button agregar = findViewById(R.id.btnGuardarRegistro);
        taskList = PrefConfig.readListFromPref(this);

        if (taskList == null)
            taskList = new ArrayList<>();

        adapter = new TaskAdapter(getApplicationContext(), taskList);



        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vnombre = nombre.getText().toString().trim();
                boolean valido = true;
                if(vnombre.equals("")){
                   nombre.setError("Nombre requerido");
                    valido = false;
                }
                if(valido){
                    final ProgressBar progressBar = findViewById(R.id.progressBar);
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    final Handler handler = new Handler();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int progreso = 0;
                            while (progreso < 100){
                                //simular proceso

                                try{
                                    Thread.sleep(100);
                                }
                                catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                                progreso++;

                                //actualizar progresbar
                                final int finalProgreso = progreso;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(finalProgreso);
                                        progressBar.getProgress();
                                        if (finalProgreso==100){
                                            Toast.makeText(AgregarNombre.this," Nombre agredado con éxito" ,Toast.LENGTH_SHORT).show();
                                            TaskModel taskModel = new TaskModel(nombre.getText().toString());
                                            taskList.add(taskModel);
                                            PrefConfig.writeListInPref(getApplicationContext(), taskList);
                                            Collections.reverse(taskList);
                                            adapter.setTaskModelList(taskList);
                                            finish();
                                        }

                                    }
                                });

                            }
                        }
                    }).start();

                }


            }
        });

    }
}
