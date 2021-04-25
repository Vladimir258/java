package ru.geekbrains;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry;
    private boolean scream;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    public void eat(Plate p) {
        if (hungry) {
            if (appetite > p.getFood()) {
                scream = true;
                System.out.println(name + ": Мяяяяяяуууу (Котику мало корма)");
            } else {
                scream = false;
                p.decreaseFood(appetite);
                System.out.println(name + ": Ням ням ням (Котик поел)");
                hungry = false;
            }
        } else {
            System.out.println(name + ": Мурр мурр мурр (Котик спит)");
            hungry = true;
        }
    }
    public boolean getScream() {
        return this.scream;
    }
}
