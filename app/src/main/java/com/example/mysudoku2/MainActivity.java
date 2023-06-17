package com.example.mysudoku2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity  {

    public static void main(String[] args) throws IOException {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("MyLog", "Салам пополам");
        Log.d("MyLog2", "Салам пополам2");
        Log.i("MyLog", "Салам пополам");

        int[][] sudokuTable = new int[10][10];

        int testInt = 10;

    }

}