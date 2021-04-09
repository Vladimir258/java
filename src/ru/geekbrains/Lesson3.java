package ru.geekbrains;

import java.util.Arrays;
import java.util.Random;

public class Lesson3 {
    public static void homeWork3() {
        // Задание 1
        binaryArrayInvert();
        // Задание 2
        fillArray();
        // Задание 3
        updateArray();
        // Задание 4
        squareArray();
        // Задание 5
        System.out.println(Arrays.toString(createArray(12, 5)));
        System.out.println();
        // Задание 6
        searchMinMax((byte) 25);
        System.out.println();
        // Задание 7
        byte[] array = {1, 14, 2, 3, 10};
        System.out.println(equalSum(array));
        System.out.println();
        // Задание 8
        int offsetNumber = 3;
        System.out.println("Массив до смещения:     " + Arrays.toString(array));
        System.out.println("Массив смещенный на " + offsetNumber + " : "
                + Arrays.toString(offsetArray(array, (byte) offsetNumber)));
    }

    // Задание 1
    static void binaryArrayInvert() {
        byte[] array = new byte[10];
        for (int i = 0; i < array.length; i++) {
            Random rnd = new Random();
            array[i] = (byte) rnd.nextInt(2);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    // Задание 2
    static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            if (array[i] < 10) {                            // Строки с 39 по 47 чтоб массив в консоль
                System.out.print(array[i] + "  ");       // компактно вывести
            } else {
                System.out.print(array[i] + " ");
            }
            if (array[i] % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // Задание 3
    static void updateArray() {
        byte[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = (byte) (array[i] * 2);
            }
            System.out.print(array[i] + "  ");
        }
        System.out.println("\n");
    }

    // Задание 4
    static void squareArray() {
        byte[][] array = new byte[5][5];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                } else if (i + j == array.length - 1) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Задание 5
    static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }


    // Задание 6
    static void searchMinMax(byte len) {
        byte[] array = new byte[len];
        for (int i = 0; i < array.length; i++) {
            Random rnd = new Random();
            array[i] = (byte) rnd.nextInt(len + rnd.nextInt(100));
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int min = array[0], max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        System.out.println("Минимальное значение в массиве: " + min);
        System.out.println("Максимальное значение в массиве: " + max);
    }

    // Задание 7
    static boolean equalSum(byte[] arr) {
        byte sum1 = 0;
        byte temp = 0;

        for (int i = 0; i < arr.length; i++) {      // Заполняем массив
            sum1 += arr[i];
        }
        if (sum1 % 2 == 0) {                           // Проверяем что сумма всех элементов..
            temp = (byte) (sum1 / 2);               // ..массива делится пополам иначе..
        } else {                                    // ..нет смысла продолжать
            return false;
        }
        sum1 = 0;
        int z = 0;
        for (int i = 0; i < arr.length; i++) {      // Находим сумму элементов мссива равную temp
            sum1 += arr[i];
            z = i;
            if (sum1 == temp) break;
        }
        int sum2 = 0;                               // Находим сумму оставшихся элемнтов массива
        for (int i = z + 1; i < arr.length; i++) {
            sum2 += arr[i];
        }

        if (sum1 == sum2) {                          // Сверяем полученные суммы
            return true;
        } else {
            return false;
        }
    }

    // Задание 8
    static byte[] offsetArray(byte[] arr, byte offsetNum) {
        int offset = 0;
        while (offset < Math.abs(offsetNum)) {
            if(offsetNum >= 0) {
                byte lastUnit = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = lastUnit;
                offset++;
            }
            else {
                byte firstUnit = arr[0];
                for (int i = 0; i < arr.length-1; i++) {
                    arr[i] = arr[i+1];
                }
                arr[arr.length-1] = firstUnit;
                offset++;
            }
        }
        return arr;
    }
}

