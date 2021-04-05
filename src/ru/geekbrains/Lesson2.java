package ru.geekbrains;

public class Lesson2 {
    public static void homeWork1() {
        int test = 33;
        System.out.println(checkSum(7,5));  // вызов checkSum()
        System.out.println();
        checkPositiveNumber(test);  // вызов checkPositiveNumber()
        System.out.println();
        System.out.println("Число " + test + " отрицательное? " + isNegativeNumber(test));  // вызов isNegativeNumber()
        System.out.println();
        stringCycle(3,"GeekBrains)))"); // вызов stringCycle()
        System.out.println();
        leapYear();     // вызов leapYear()
    }

    // Задание 1
    public static boolean checkSum(int num1, int num2) {
        if(num1 + num2 >= 10 & num1 + num2 <= 20) {
            return true;
        }
        else {
            return false;
        }
    }

    // Задание 2
    public static void checkPositiveNumber(int num) {
        if(num >= 0) {
            System.out.println("Число " + num + " положительное.");
        }
        else {
            System.out.println("Число " + num + " отрицательное.");
        }
    }

    // Задание 3
    public static boolean isNegativeNumber(int num) {
        if(num >= 0) {
            return false;
        }
        else {
            return true;
        }
    }

    // Задание 4
    public static void stringCycle(int num, String str) {
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }

    // Задание 5
    public static void leapYear() {
        int[] yearMas = new int[600];
        for (int i = 0; i < yearMas.length; i++) {
            yearMas[i] = 0 + i;
        }
        for(int year : yearMas) {
            detectYear(year);
        }
    }
   static void detectYear(int searchYear) {
       if (searchYear % 4 == 0) {
           if (searchYear % 100 == 0) {
               if (searchYear % 400 == 0) {
                   System.out.println("Високосный год: " + searchYear);
               }
               else {
                   System.out.println("Не високосный год: " + searchYear);
               }
           }
           else {
               System.out.println("Високосный год: " + searchYear);
           }
       }
   }
}
