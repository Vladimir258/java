package ru.geekbrains.utils;

import java.util.Random;

import java.util.Random;

public class ArrayTools {
    public static int[] generateArray(int size) { // 16
        int[] result = new int[size];
        int halfIndex = result.length + 1;
        for (int i = 0; i < size; i++) {
            halfIndex = halfIndex - 1;
            if (i < size / 2) {
                result[i] = i + 1;
            } else {
                result[i] = halfIndex;
            }

        }
        return shuffleArray(result);
    }

    private static int[] shuffleArray(int[] array) {
        int tmp;
        int rnd;
        for (int i = 0; i < array.length; i++) {
            rnd = new Random().nextInt(array.length);
            tmp = array[i];
            array[i] = array[rnd];
            array[rnd] = tmp;
        }
        return array;
    }
}
