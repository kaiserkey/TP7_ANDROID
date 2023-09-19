package com.example.tp7_android.ui.mapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp7_android.databinding.FragmentGalleryBinding;
import com.google.android.gms.maps.MapView;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private MapView mapView;
    private GalleryViewModel ubicacionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ubicacionViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mapView = binding.mapView;

        ubicacionViewModel.initMap(this, mapView);

        ubicacionViewModel.getLocationPermissionGranted().observe(getViewLifecycleOwner(), granted -> {
            if (!granted) {
                Toast.makeText(getContext(), "El permiso ha sido denegado", Toast.LENGTH_SHORT).show();
            }
        });

        ubicacionViewModel.getMap().observe(getViewLifecycleOwner(), map -> {

        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mapView != null) mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mapView != null) mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mapView != null) mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (mapView != null) mapView.onLowMemory();
    }
}