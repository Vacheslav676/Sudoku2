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

    int coordX = 2;
    int coordY = 2;
    int valueNumber = 0;

    int coordsquareX = 1; // координата квадрата 3 на 3, он же индекс_начала_копирования
    int coordsquareY = 1; // координата квадрата 3 на 3, индекс массива sudokuTable [i][]






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
        sudokuTable [4] = new int[]{ 0, 3, 0,   9, 8, 7,    2, 0, 0};
        sudokuTable [5] = new int[]{ 0, 4, 1,   6, 5, 4,    3, 0, 0};
        sudokuTable [6] = new int[]{ 0, 0, 6,   3, 2, 1,    8, 9, 0};
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

        //  1)
        // горизонталь = горизонтали
        int [] arrHorizont = sudokuTable [coordY];

        //   2)
        // ветикаль  =
        // 	For (		)
        //		System.arraycopy(sudokuTable [i], Coord Y, arrVertic, i, 1);

        int [] arrVertical = new int[9];
        for (int i = 1; i < 10; i++) {
            System.arraycopy(sudokuTable[i], coordX, arrVertical, i-1, 1);

        }

        // 3)
        // квадрат в массив
        int [] arrSquare = new int[9];

        // у разного квадрата будет меняться только индекс_начала_копирования
        if (coordX < 3) {coordsquareX = 0;}
        if (coordX <= 6 && coordX > 3) {coordsquareX = 3;}
        if (coordX <= 9 && coordX > 6) {coordsquareX = 7;}

        // у разного квадрата будет меняться только индекс массива sudokuTable [i][]
        if (coordY < 3) {coordsquareY = 0;}
        if (coordY <= 6 && coordY > 3) {coordsquareY = 3;}
        if (coordY <= 9 && coordY > 6) {coordsquareY = 6;}

//        int m = 0; // Вместо k надо приравнять к coordsquareX и протестировать - не получается
//        // Значит через if  сделать 3 разных перебора попробовать
//        for (int i = 1; i < 4; i++) {
//            for (int k = 0; k < 3; k++) {
//
//                System.arraycopy(sudokuTable[i+coordsquareY], coordsquareX+k, arrSquare, coordsquareX+m+i-1, 1);
//            } m = m + 2;
//        }

         // 3)
        // квадрат 1:1 в массив
        //int [] arrSquare = new int[9];

        // у разного квадрата будет меняться только индекс_начала_копирования

        int m = 0;
        for (int i = 1; i < 4; i++) {
            for (int k = 0; k < 3; k++) {

                System.arraycopy(sudokuTable[i+coordsquareY], coordX+k-1, arrSquare, k+m+i-1, 1);
            } m = m + 2;
        }

        //      4)
        // Копируем три массива в один
//System.arraycopy(arr3, 0, result, arr2.length, arr3.length);
// System.arraycopy(исходный_массив,
//                  индекс_начала_копирования,
//                  целевой_массив,
//                  индекс_вставки,
//                  количество_элементов);


        //В этом примере мы создаем новый массив result длиной
        // равной сумме длин трёх исходных массивов


        int [] result = new int[arrHorizont.length + arrVertical.length + arrSquare.length];

        // Затем мы копируем элементы из arrHorizont в начало result, начиная с индекса 0.
        System.arraycopy(arrHorizont, 0, result, 0, arrHorizont.length);

        // Затем мы копируем элементы из arrVertical в result, начиная с индекса arrHorizont.length
        System.arraycopy(arrVertical, 0, result, arrHorizont.length, arrVertical.length);

        Log.d("MyLog2", "arrHorizont - " + Arrays.toString(arrHorizont));
        Log.d("MyLog2", "arrVertical - " + Arrays.toString(arrVertical));
        Log.d("MyLog2", "arrSquare - " + Arrays.toString(arrSquare));

        // И в конце копируем третий массив в результ
        System.arraycopy(arrSquare, 0, result, arrHorizont.length + arrVertical.length, arrSquare.length);

        Log.d("MyLog2", "result - " + Arrays.toString(result));

        //   5)
        // сортируем массив
        Arrays.sort(result);
        Log.d("MyLog2", "result - " + Arrays.toString(result));

        // 6)
        // Ищем нужный элемент есть/нет

        int index = Arrays.binarySearch(result, valueNumber);


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






//        // 3)
//        // квадрат 1:1 в массив
//        int [] arrSquare = new int[9];
//
//        // у разного квадрата будет меняться только индекс_начала_копирования
//        if (coordX < 3) {coordsquareX = 0;}
//        if (coordX <= 6 && coordX > 3) {coordsquareX = 2;}
//        if (coordX <= 9 && coordX > 6) {coordsquareX = 6;}
//
//        // у разного квадрата будет меняться только индекс массива sudokuTable [i][]
//        if (coordY < 3) {coordsquareY = 0;}
//        if (coordY <= 6 && coordY > 3) {coordsquareY = 2;}
//        if (coordY <= 9 && coordY > 6) {coordsquareY = 6;}
//
//
//        int m = 0;
//        for (int i = 1; i < 4; i++) {
//            for (int k = 0; k < 3; k++) {
//
//                System.arraycopy(sudokuTable[i], k, arrSquare, k+m+i-1, 1);
//            } m = m + 2;
//        }



    }

}