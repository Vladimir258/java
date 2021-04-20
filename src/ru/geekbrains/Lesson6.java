package ru.geekbrains;

public class Lesson6 {
    public static void createAnimal() {

        Cat cat1 = new Cat("Мурзик");
        System.out.println(cat1.getName());
        cat1.run(500);
        cat1.swim(100);
        System.out.println();

        Cat cat2 = new Cat("Кот 2");
        Cat cat3 = new Cat("Кот 3");
        Cat cat4 = new Cat("Кот 4");
        Cat cat5 = new Cat("Кот 5");
        Cat cat6 = new Cat("Кот 6");

        Dog dog1 = new Dog("Шарик");
        System.out.println(dog1.getName());
        dog1.run(490);
        dog1.swim(7);
        System.out.println();

        Dog dog2 = new Dog("Собака 2");
        Dog dog3 = new Dog("Собака 3");
        Dog dog4 = new Dog("Собака 4");
        Dog dog5 = new Dog("Собака 5");
        Dog dog6 = new Dog("Собака 6");
        Dog dog7 = new Dog("Собака 7");
        Dog dog8 = new Dog("Собака 8");
        Dog dog9 = new Dog("Собака 9");

        Cat.catQuantity();
        Dog.dogQuantity();
        Animal.animalQuantity();

    }
}




