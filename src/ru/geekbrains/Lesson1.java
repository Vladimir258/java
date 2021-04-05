package ru.geekbrains;

public class Lesson1 {
    public static void homeWork1() {
        printThreeWords();
        System.out.println();
        checkSumSign();
        System.out.println();
        printColor();
        System.out.println();
        compareNumbers();
    }

    static void printThreeWords() {
        System.out.println("Orange"); // Вариант 1
        System.out.println("Banana");
        System.out.println("Apple");

        System.out.println("\nOrange\nBanana\nApple"); // Вариант 2
    }

    static void checkSumSign() {
        int a = 2;
        int b = 5;

        if(a + b >= 0) System.out.println("Сумма положительная");  // Оператор один, можно не ставить { }
        else System.out.println("Сумма отрицательная");
    }

    static void printColor() {
        int value = 250;

        if(value <= 0) {
            System.out.println("Красный");
        }
        else if(value > 0 & value <= 100) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        int a = 7;
        int b = 5;

        String str = a >= b ? "a >= b" : "a < b";
        System.out.println(str);
    }
}
