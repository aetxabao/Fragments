package com.pmdm.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListadoFragment extends Fragment {

    private ListView lstZonas;

    private ZonaListener listener;

    private String[] zonas;

    @Override
    /** Cuando se crea el fragment */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    /** Cuando la actividad contenedora del fragment se crea */
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        zonas = getView().getResources().getStringArray(R.array.zonas);
        lstZonas = (ListView) getView().findViewById(R.id.ListZonas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                                                        android.R.layout.simple_list_item_1, zonas);
        lstZonas.setAdapter(adapter);
        lstZonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Por si acaso no se ha hecho antes el setZonaListener
                if (listener != null) {
                    listener.onZonaSeleccionada(position + 1);
                }
            }
        });

    }

    public void setZonaListener(ZonaListener listener){
        this.listener = listener;
    }

}
