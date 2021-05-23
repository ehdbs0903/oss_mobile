package com.example.chartapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
public class BarChartActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        BarChart chart = findViewById(R.id.weightchart);

        ArrayList Weight = new ArrayList();
        Weight.add(new BarEntry(55, 0));
        Weight.add(new BarEntry(55, 1));
        Weight.add(new BarEntry(54, 2));
        Weight.add(new BarEntry(53, 3));
        Weight.add(new BarEntry(52, 4));
        Weight.add(new BarEntry(54, 5));
        Weight.add(new BarEntry(53, 6));
        Weight.add(new BarEntry(51, 7));
        Weight.add(new BarEntry(50, 8));
        Weight.add(new BarEntry(48, 9));

        ArrayList date = new ArrayList();
        date.add("5/11");
        date.add("5/12");
        date.add("5/13");
        date.add("5/14");
        date.add("5/15");
        date.add("5/16");
        date.add("5/17");
        date.add("5/18");
        date.add("5/19");
        date.add("5/20");

        BarDataSet bardataset = new BarDataSet(Weight, "Weight");
        chart.animateY(3000);
        BarData data = new BarData(date, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
    }
}