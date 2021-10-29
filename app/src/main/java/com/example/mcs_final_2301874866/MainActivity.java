package com.example.mcs_final_2301874866;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mcs_final_2301874866.ui.main.SectionsPagerAdapter;
import com.example.mcs_final_2301874866.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
/*
    Ujian ini saya mengerjakan sebisa saya saja pak dengan batas waktu yang diberikan
    jadinya saya membuat fungsi-fungsi sebisa saya saja dengan waktu yang mepet ini,
    jadinya code banyak yang red line hehe.
    maaf ya pak (saya h-2 baru mulai mengerjakan karena saya terlalu sibuk mengurus ujian
     matkul lainnya :D)
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}