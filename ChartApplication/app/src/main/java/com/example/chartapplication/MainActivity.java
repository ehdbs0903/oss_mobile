package com.example.chartapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;

public class MainActivity extends AppCompatActivity {
    Button btnWeightChart, btnDietChart;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWeightChart = findViewById(R.id.btnBarChart);
        btnDietChart = findViewById(R.id.btnPieChart);
        btnWeightChart.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, BarChartActivity.class);
                startActivity(I);
            }
        });
        btnDietChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, PieChartActivity.class);
                startActivity(I);
            }
        });
    }
}