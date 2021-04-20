package ru.geekbrains;

final class Dog extends Animal implements IAnimalActions {
    static int dogCount = 0;

    Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void swim(int way) {
        if(way > 10) {
            System.out.println("Собака может проплыть максимум 10 метров.");
        }
        else {
            System.out.println("Собака " + getName() + " проплыла " + way + " метров.");
        }
    }

    @Override
    public void run(int way) {
        if(way > 500) {
            System.out.println("Собака может пробежать максимум 500 метров.");
        }
        else {
            System.out.println("Собака " + getName() + " пробежала " + way + " метров.");
        }
    }

    static void dogQuantity() {
        System.out.println("Общее количество собак: " + dogCount);
    }
}
