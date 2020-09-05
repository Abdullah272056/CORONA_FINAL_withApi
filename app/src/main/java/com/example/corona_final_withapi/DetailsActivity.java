package com.example.corona_final_withapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView countryName,totalCase,todayCase,totalDeaths,todayDeaths,
            recover,active,critical,casePerMillion,deathsPerMillion,
            totalTest,testPerMillion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        countryName=findViewById (R.id.CountryName);
        totalCase=findViewById (R.id.totalCase);
        todayCase=findViewById (R.id.todayCases);
        todayDeaths=findViewById (R.id.todayDeaths);
        totalDeaths=findViewById (R.id.totalDeaths);
        recover=findViewById (R.id.recover);
        active=findViewById (R.id.active);
        critical=findViewById (R.id.critical);
        casePerMillion=findViewById (R.id.casePerMillion);
        deathsPerMillion=findViewById (R.id.deathsPerMillion);
        totalTest=findViewById (R.id.totalTest);
        testPerMillion=findViewById (R.id.testPerMillion);



        ObjectDataClass objectDataClass= (ObjectDataClass) getIntent().getSerializableExtra("response");
//        name.setText(objectDataClass.getName());
//        location.setText(objectDataClass.getCity());


        countryName.setText(String.valueOf (objectDataClass.getCountry ()));
        todayCase.setText(todayCase.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getTodayCases ()));
        totalCase.setText(totalCase.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getCases ()));
        totalDeaths.setText(totalDeaths.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getDeaths ()));
        todayDeaths.setText(todayDeaths.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getTodayDeaths ()));
        recover.setText(recover.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getRecovered ()));
        active.setText(active.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getActive ()));
        critical.setText(critical.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getCritical ()));
        casePerMillion.setText(casePerMillion.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getCasesPerOneMillion ()));
        deathsPerMillion.setText(deathsPerMillion.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getDeathsPerOneMillion ()));
        totalTest.setText(totalTest.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getTotalTests ()));
        testPerMillion.setText(testPerMillion.getText ().toString ()+"\n"+String.valueOf (objectDataClass.getTestsPerOneMillion ()));


    }
}