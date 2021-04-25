package ru.geekbrains;

public class Lesson7 {
    public static void homeWork() {
        int count = 0;
        Cat[] cat = { new Cat("Кот 1", 5),
                      new Cat("Кот 2", 10),
                      new Cat("Кот 3", 8),
                      new Cat("Кот 4", 27),
                      new Cat("Кот 5", 3)};

        Plate plate = new Plate(100);
        System.out.println("Вот вам котики полная миска. Еды в миске:  " + plate.getFood() + "\n");

        while(count < 100) {
            for (Cat c : cat) {
                c.eat(plate);
                plate.addFood(c.getScream());
            }
            System.out.print("\nПрошёл час. ");
            plate.info();
            ++count;
        }
    }
}
