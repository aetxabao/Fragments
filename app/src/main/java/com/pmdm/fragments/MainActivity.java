package com.pmdm.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ZonaListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cuando se inicia la aplicación se crea este activity y se indica que
        // el listener del fragmento con el listado es la instancia de esta clase que implementa la interfaz
        // y en el método onZonaSeleccionada se indica que sucede al seleccionar una zona
        ListadoFragment frgListado = (ListadoFragment)getFragmentManager().findFragmentById(R.id.ListadoFragment);
        frgListado.setZonaListener(this);
    }

    @Override
    public void onZonaSeleccionada(int iZona) {
        //Si el fragmento para el detalle existe el layout es grande, sino se utiliza el intent
        boolean hayDetalle = (getFragmentManager().findFragmentById(R.id.DetalleFragment) != null);
        Log.d("LSTFRG", "hayDetalle " + hayDetalle);
        if (hayDetalle){
            ((DetalleFragment)getFragmentManager().findFragmentById(R.id.DetalleFragment)).mostrarDetalle(iZona);
        }else{
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtra("NUM",iZona);
            startActivity(intent);
        }
    }
}
