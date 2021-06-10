package com.example.oss_mobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
public class BarChartActivity extends AppCompatActivity {
    String data;
    String fileName, subFileName;
    ArrayList weight = new ArrayList();
    ArrayList date = new ArrayList();
    int count = 0;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        getSupportActionBar().setIcon(R.drawable.icon2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        BarChart chart = findViewById(R.id.weightchart);

        File dir = new File("/data/data/com.example.oss_mobile/files");
        String[] filenames = dir.list();
        for(int i = 0; i < filenames.length; i++){
            subFileName = filenames[i].replace(".txt","");
            addArray(subFileName.substring(0,4) + "/" + subFileName.substring(4,5) + "/" +subFileName.substring(5));
        }

        BarDataSet bardataset = new BarDataSet(weight, "Weight");
        chart.animateY(3000);
        BarData data = new BarData(date, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
    }

    //파일 읽기
    private void addArray(String day) {
        String[] dateArr = day.split("/");
        int year = Integer.parseInt(dateArr[0]);
        int monthOfYear = Integer.parseInt(dateArr[1]);
        int dayOfMonth = Integer.parseInt(dateArr[2]);

        fileName = year + "" + monthOfYear + "" + dayOfMonth + ".txt";

        // 읽어봐서 읽어지면
        // 없으면 catch로 처리
        FileInputStream fis = null;
        try {
            fis = openFileInput(fileName);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            String str = new String(fileData, "EUC-KR");
            String[] data = str.split("/");
            weight.add(new BarEntry(Float.parseFloat(data[0]), count++));
            date.add(monthOfYear + "/" + dayOfMonth);
        }
        catch (Exception e) {
        }
    }
}