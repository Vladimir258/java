package ru.geekbrains;

public abstract class Animal {

    private static int animalCount = 0;
    private String name;

    public String getName() {
        return name;
    }
    Animal(String name) {
        animalCount++;
        this.name = name;
    }

    static void animalQuantity() {
        System.out.println("Общее количество животных:" + animalCount);
    }
}
