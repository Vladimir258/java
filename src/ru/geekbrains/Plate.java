package ru.geekbrains;

public class Plate {
    private int food;
    private int initFood;
    final int MIN_FOOD = 4;

    public Plate(int food) {
        this.food = food;
        this.initFood = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void info() {
        System.out.println("Корма в миске: " + food + "\n");
    }

    public void addFood(boolean catScream) {
        if (food < MIN_FOOD | catScream) {
            food = initFood;
            System.out.println("\nДобавим корма в миску.\n");
        }
    }

    public int getFood() {
        return food;
    }
}
