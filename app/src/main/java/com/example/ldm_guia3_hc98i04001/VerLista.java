package com.example.ldm_guia3_hc98i04001;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VerLista extends AppCompatActivity {

    private Button btnAdd;
    private EditText etTaskEntry;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;

    private List<TaskModel> taskList;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ver_lista);
            recyclerView = findViewById(R.id.recyclerview);

            taskList = PrefConfig.readListFromPref(this);

            if (taskList == null)
            {
                Toast.makeText(VerLista.this," No hay datos que mostrar" ,Toast.LENGTH_SHORT).show();
                finish();
            }else {


                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                adapter = new TaskAdapter(getApplicationContext(), taskList);
                recyclerView.setAdapter(adapter);

            }
        }

}
