package ru.geekbrains;

public class Lesson5 {
    public Employee[] dbEmployee = new Employee[5];

    public void homeWork5() {

        dbEmployee[0] = new Employee("Фоминский","Владимир","Сергеевич","Программист Java ","fominsky_v@mail.ru ", 111L,100000,(byte)35);
        dbEmployee[1] = new Employee("Петров","Петр","Петрович","Программист С#","petrov@m.rr ", 222L,20000,(byte)45);
        dbEmployee[2] = new Employee("Иванов","Иван","Иванович","Тестировщик","ivanov@m.rr ", 333L,50000,(byte)28);
        dbEmployee[3] = new Employee("Сидоров","Виталий","Петрович","Аналитик","sidorov@m.rr ", 555L,80000,(byte)37);
        dbEmployee[4] = new Employee("Иванов","Владимир","Александрович","Офис менеджер","ivanov55@m.rr ", 444L,40000,(byte)55);

        System.out.println("\nИз них сотрудники старше 40 лет:\n");

        for (int i = 0; i < dbEmployee.length; i++) {
            if(dbEmployee[i].getAge() > 40) dbEmployee[i].employeeInfo();
        }

    }
}

class Employee {
    private String lastName;     // Имя
    private String firsName;     // Фамилия
    private String patronymic;   // Отчество
    private String fullName;     // ФИО

    private String  position;    // Должность
    private String  email;       // email
    private long    phoneNumber; // Номер телефона
    private int     payCheck;    // Зарплата
    private byte    age;         // Возраст

    public Employee(){} // Конструктор класса 1

    public Employee(String lName,String fName,String mName,String job,String mail,  // Конструктор класса 2
                    long pNumber,int pCheck,byte year) {
        lastName = lName;
        firsName = fName;
        patronymic = mName;
        position = job;
        email = mail;
        phoneNumber = pNumber;
        payCheck = pCheck;
        age = year;

        fullName = (lastName +  " " + firsName + " " + patronymic);
        System.out.println(fullName);
    }

    public void employeeInfo() {
        System.out.println(   "ФИО:        " + fullName +
                " \nПрофессия:  " + position +
                " \nЭл.почта:   " + email +
                " \nНомер тел.: " + phoneNumber +
                " \nЗарплата:   " + payCheck +
                " \nВозвраст:   " + age);
        System.out.println("__________________________________________________________________");
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getPayCheck() {
        return payCheck;
    }

    public byte getAge() {
        return age;
    }
}
