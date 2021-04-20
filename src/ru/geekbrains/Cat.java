package ru.geekbrains;

final class Cat extends Animal implements IAnimalActions {
    static int catCount = 0;

    Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void swim(int way) {
        System.out.println("Кошки не умеют плавать.");
    }

    @Override
    public void run(int way) {
        if(way > 200) {
            System.out.println("Кошка " + getName() + " может пробежать максимум 200 метров.");
        }
        else {
            System.out.println("Кошка " + getName() + " пробежала " + way + " метров.");
        }
    }

    static void catQuantity() {
        System.out.println("Общее количество кошек: " + catCount);
    }
}
