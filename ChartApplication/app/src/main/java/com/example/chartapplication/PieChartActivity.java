package com.example.chartapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
public class PieChartActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        PieChart pieChart = findViewById(R.id.dietchart);

        ArrayList Diet = new ArrayList();
        Diet.add(new Entry(500, 0));
        Diet.add(new Entry(300, 1));
        Diet.add(new Entry(200, 2));

        PieDataSet dataSet = new PieDataSet(Diet, "Diet ingredients(kcal)");
        ArrayList ingredient = new ArrayList();
        ingredient.add("Carbohydrate");
        ingredient.add("Protein");
        ingredient.add("Fat");
        PieData data = new PieData(ingredient, dataSet);
        pieChart.setData(data); dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateXY(3000, 3000);
    }
}