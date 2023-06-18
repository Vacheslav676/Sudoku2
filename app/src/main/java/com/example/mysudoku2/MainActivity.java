package com.example.mysudoku2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity  {

    int testInt = 10;
    int[][] sudokuTable = new int[10][9];





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("MyLog", "Салам пополам");
        Log.d("MyLog2", "Салам пополам2");
        Log.i("MyLog", "Салам пополам");


        sudokuTable [0] = new int[]{ 1, 2, 3,   4, 5, 6,    7, 8, 9};
        //-------------------------------------------------------
        sudokuTable [1] = new int[]{ 1, 2, 3,   0, 0, 0,    0, 0, 3};
        sudokuTable [2] = new int[]{ 4, 5, 6,   2, 6, 0,    4, 8, 0};
        sudokuTable [3] = new int[]{ 7, 8, 9,   9, 3, 5,    0, 0, 6};
        //-------------------------------------------------------
        sudokuTable [4] = new int[]{ 0, 3, 0,   4, 8, 0,    2, 0, 0};
        sudokuTable [5] = new int[]{ 0, 4, 1,   6, 0, 9,    3, 0, 0};
        sudokuTable [6] = new int[]{ 0, 0, 6,   0, 0, 0,    8, 9, 0};
        //-------------------------------------------------------
        sudokuTable [7] = new int[]{ 5, 7, 8,   0, 4, 0,    0, 0, 2};
        sudokuTable [8] = new int[]{ 0, 0, 0,   3, 0, 0,    0, 7, 0};
        sudokuTable [9] = new int[]{ 2, 0, 0,   0, 0, 0,    0, 0, 5};

        zalivka();


    }

    public void zalivka() {

        // Этот метод заполняет ячейку-вью значением массива

        TextView S10 = (TextView) findViewById(R.id.textView00);
        S10.setText(String.valueOf(sudokuTable[1][0]));

        TextView S11 = (TextView) findViewById(R.id.textView01);
        S11.setText(String.valueOf(sudokuTable[1][1]));

        TextView S12 = (TextView) findViewById(R.id.textView02);
        S12.setText(String.valueOf(sudokuTable[1][2]));


        TextView S20 = (TextView) findViewById(R.id.textView10);
        S20.setText(String.valueOf(sudokuTable[2][0]));

        TextView S21 = (TextView) findViewById(R.id.textView11);
        S21.setText(String.valueOf(sudokuTable[2][1]));

        TextView S22 = (TextView) findViewById(R.id.textView12);
        S22.setText(String.valueOf(sudokuTable[2][2]));


        TextView S30 = (TextView) findViewById(R.id.textView20);
        S30.setText(String.valueOf(sudokuTable[3][0]));

        TextView S31 = (TextView) findViewById(R.id.textView21);
        S31.setText(String.valueOf(sudokuTable[3][1]));

        TextView S32 = (TextView) findViewById(R.id.textView22);
        S32.setText(String.valueOf(sudokuTable[3][2]));

    }


    public void writeANumber(View view) {
        int coordX = 1;
        int coordY = 1;
        int valueNumber = 0;

        TextView coordXtext = (TextView) findViewById(R.id.TextXcoord);// получение ссылки на TextView по его id
        String textX = coordXtext.getText().toString(); // получение текста из TextView в виде строки
        coordX = Integer.parseInt(textX); // преобразование строки в число типа int

        TextView coordYtext = (TextView) findViewById(R.id.TextYcoord);// получение ссылки на TextView по его id
        String textY = coordYtext.getText().toString(); // получение текста из TextView в виде строки
        coordY = Integer.parseInt(textY); // преобразование строки в число типа int

        TextView valueNumberTV = (TextView) findViewById(R.id.textViewValueNumber);// получение ссылки на TextView по его id
        String stringValueNumber = valueNumberTV.getText().toString(); // получение текста из TextView в виде строки
        valueNumber = Integer.parseInt(stringValueNumber); // преобразование строки в число типа int

        sudokuTable [coordX][coordY] = valueNumber;

        testInt = sudokuTable[1][0];

        zalivka();

    }

}