package com.example.mysudoku2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity  {

    int testInt = 10;
    int[][] sudokuTable = new int[10][9];

    int coordX = 1;
    int coordY = 1;
    int valueNumber = 0;





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
        searchNumber();



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

    public  void searchNumber(){
        // метод проверяет есть ли записанная нами цифра в судоку
        // но в искомом массиве надо сначала сделать сортировку, чтобы
        // метод binarySearch работал корректно
        // поэтому копируем вертикаль, горизонталь и клетку 9 на 9
        // а потом их сортируем
        // и потом уже в них ищем

        // А может вертикаль, горизонталь и клетку 9 на 9 скопировать в один массив?
        // его отсортировать и выполнить в нем поиск?
        //Для объединения двух массивов в Java можно использовать
        // метод System.arraycopy().

        int desiredNumber = 4; // the desired number - искомое число

//System.arraycopy(arr3, 0, result, arr2.length, arr3.length);
// System.arraycopy(исходный_массив,
//                  индекс_начала_копирования,
//                  целевой_массив,
//                  индекс_вставки,
//                  количество_элементов);


        // горизонталь = горизонтали
        int [] arrHorizont = sudokuTable [coordY];

        // ветикаль  =
        // 	For (		)
        //		System.arraycopy(sudokuTable [i], Coord Y, arrVertic, i, 1);

        int [] arrVertical = new int[9];
        for (int i = 1; i < 10; i++) {
            System.arraycopy(sudokuTable[i], coordX, arrVertical, i-1, 1);

        }



        int [] arrSquare = new int[] {21, 22, 23, 24, 25, 26, 27, 28, 29};

        // И в конце копируем третий массив в результ
        //System.arraycopy(arr3, 0, result, arr2.length, arr3.length);








    }


    public void writeANumber(View view) {


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


    public  void PrimerKopirovaniya() {

        //Для объединения двух массивов в Java можно использовать
        // метод System.arraycopy().

//System.arraycopy(arr3, 0, result, arr2.length, arr3.length);
// System.arraycopy(исходный_массив,
//                  индекс_начала_копирования,
//                  целевой_массив,
//                  индекс_вставки,
//                  количество_элементов);

// System.arraycopy(исходный_массив, индекс_начала_копирования,
// целевой_массив, индекс_вставки, количество_элементов);

        int desiredNumber = 4; // the desired number - искомое число

        int [] arr1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int [] arr2 = new int[] {11, 12, 13, 14, 15, 16, 17, 18, 19};

        int [] arr3 = new int[] {21, 22, 23, 24, 25, 26, 27, 28, 29};

        //В этом примере мы создаем новый массив result длиной
        // равной сумме длин двух исходных массивов
        int [] result = new int[arr1.length + arr2.length + arr3.length];

        // Затем мы копируем элементы из arr1 в начало result, начиная с индекса 0.
        System.arraycopy(arr1, 0, result, 0, arr1.length);

        // Затем мы копируем элементы из arr2 в result, начиная с индекса arr1.length
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        // И в конце копируем третий массив в результ
        System.arraycopy(arr3, 0, result, arr2.length, arr3.length);



    }

}