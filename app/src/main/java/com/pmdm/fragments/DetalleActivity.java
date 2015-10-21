package com.pmdm.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        DetalleFragment frgDetalle = (DetalleFragment)getFragmentManager().findFragmentById(R.id.DetalleFragment);
        frgDetalle.mostrarDetalle(getIntent().getIntExtra("NUM",0));
    }

}
