package com.pmdm.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DetalleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    /**
     * Mostrar imagen
     */
    public void mostrarDetalle(int num) {
        String uri = "@drawable/zona" + num;
        ImageView imgView = (ImageView) getView().findViewById(R.id.ImgZona);
        int imgRes = getResources().getIdentifier(uri, "drawable", getActivity().getPackageName());
        imgView.setImageResource(imgRes);
    }

}
