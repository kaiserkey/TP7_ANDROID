package com.example.tp7_android.ui.musica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;

import com.example.tp7_android.R;
import com.example.tp7_android.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnPlay.setOnClickListener(view -> {
            vm.startPlaying(getContext(), R.raw.take_on_me);
        });

        binding.btnPause.setOnClickListener(view -> {
            vm.pausePlaying();
        });

        binding.btnStop.setOnClickListener(view -> {
            vm.stopPlaying();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        if (vm != null) {
            vm.stopPlaying();
        }
    }
}
