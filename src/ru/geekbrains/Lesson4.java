package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;


public class Lesson4 {
    public Scanner scr = new Scanner(System.in);    // Ввод информации от пользователя
    public Random rand = new Random();  // Для генерации координат хода ИИ
    int razmer = 0; // Размер игрового поля
    int cellToWin = 0;  // Число подряд поставленных  знаков игрока для победы
    public char[][] gameField;   // Игровое поле


    final char EMPTY_CELL = '-';
    final char PLAYER_CELL = 'X';
    final char AI_CELL = 'O';

    public void homeWork4() {
        setup();
        while (true) {
            humanTurn();
            printMap();
            if(checkWin(PLAYER_CELL)) {
                System.out.println("Победил человек");
                break;
            }
            if(isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if(checkWin(AI_CELL)) {
                System.out.println("Победил компьютер");
                break;
            }
            if(isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public void setup() {
        System.out.println("Задайте размерность поля (мин = 3, макс = 5): ");
        while (razmer < 3 || razmer > 5) {  // Условие ограничивающее игровое поле
            razmer = scr.nextInt(); // Ввод игроком размера игрового поля
        }

        System.out.println("Если поле 3х3, условие победы закрыть 3 клетки подряд.");
        System.out.println("Если поле 4х4 или 5х5, условие победы закрыть 4 клетки подряд.");
        System.out.println();

        switch (razmer) {
            case 3:
                cellToWin = 3;
                break;
            case 4:
            case 5:
                cellToWin = 4;
                break;
        }

        gameField = new char[razmer][razmer];    // Создание нужного размера игрового поля
        System.out.println("Игровое поле " + razmer + " на " + razmer + " создано.");
        System.out.print("  ");
        for (int i = 0; i < razmer; i++) {
            System.out.print(i+1 + " ");
        }
        System.out.println();

        for (int i = 0; i < razmer; i++) {
            for (int j = 0; j < razmer; j++) {
                gameField[i][j] = EMPTY_CELL;
            }
        }

        for (int i = 0; i < razmer; i++) {  // Печать массива
            System.out.print(i+1 + " ");
            for (int j = 0; j < razmer; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Начинаем игру. Ход игрока.");
    }

    public void aiTurn() {
        int x, y;
        int a = 0; int b = 0; int c = 0;
        int tempI =0; int tempJ = 0;
        int tempI2 =0; int tempJ2 = 0;
        boolean isStepOn = false;

        pointStr:
        pointStl:
        pointDiag1:
        pointDiag2:
        {
            for (int i = 0; i < razmer; ) {                     // Прерываем победу игрока по строкам
                for (int j = 0; j < razmer; j++) {
                    if (gameField[i][j] == PLAYER_CELL) a++;

                    if(razmer < 5) {
                        if (gameField[i][j] == EMPTY_CELL) {tempI = i; tempJ = j;}
                    }
                    else {
                        if (gameField[i][j] == EMPTY_CELL) {tempI = i; tempJ = j-1;}
                    }
                }
                if (a == cellToWin - 1)  {
                    gameField[tempI][tempJ] = AI_CELL;
                    isStepOn = true;
                    tempI = tempJ = 0;
                    break pointStr;
                }
                a = 0;
                i++;
            }
            for (int i = 0; i < razmer; ) {                     // Прерываем победу игрока по столбцам
                for (int j = 0; j < razmer; j++) {
                    if (gameField[j][i] == PLAYER_CELL) a++;
                    if(razmer < 5) {
                        if (gameField[j][i] == EMPTY_CELL) {tempI = j; tempJ = i;}
                    }
                    else {
                        if (gameField[j][i] == EMPTY_CELL) {tempI = j-1; tempJ = i;}
                    }

                }
                if (a == cellToWin - 1)  {
                    gameField[tempI][tempJ] = AI_CELL;
                    isStepOn = true;
                    tempI = tempJ = 0;
                    break pointStl;
                }
                a = 0;
                i++;
            }
            for (int i = 0, j = 0; i < razmer & j < razmer; i++, j++) {             // Прерываем победу игрока по диагонали - \
                if (gameField[i][j] == PLAYER_CELL) b++;
                if (gameField[i][j] == EMPTY_CELL) {tempI = i; tempJ = j;}
            }
            if (b == cellToWin - 1)  {
                gameField[tempI][tempJ] = AI_CELL;
                tempI = tempJ = 0;
                isStepOn = true;
                break pointDiag1;
            }

            for (int i = 0, j = razmer-1; i < razmer & j >= 0; i++, j--) {             // Прерываем победу игрока по диагонали - \
                if (gameField[i][j] == PLAYER_CELL) c++;
                if (gameField[i][j] == EMPTY_CELL) {tempI2 = i; tempJ2 = j;}
            }

            if (c == cellToWin - 1)  {
                gameField[tempI2][tempJ2] = AI_CELL;
                tempI2 = tempJ2 = 0;
                isStepOn = true;
                break pointDiag2;
            }
        }

        if(!isStepOn) {
            do {
                x = rand.nextInt(razmer);
                y = rand.nextInt(razmer);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
            gameField[x][y] = AI_CELL;
        }
    }

    public void humanTurn() {
        int x,y;
        do{
            System.out.println("Введите координаты x y: ");
            x = scr.nextInt() - 1;
            y = scr.nextInt() - 1;
        } while (!isCellValid(x,y));
        gameField[x][y] = PLAYER_CELL;
    }

    public boolean isCellValid(int x, int y) {
        if(x < 0 || x >= razmer || y < 0 || y >= razmer) return false;
        if(gameField[x][y] == EMPTY_CELL) return true;
        return false;
    }

    public void printMap() {
        for (int i = 0; i <= razmer; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < razmer; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < razmer; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isMapFull() {
        for (int i = 0; i < razmer; i++) {
            for (int j = 0; j < razmer; j++) {
                if(gameField[i][j] == EMPTY_CELL) return false;
            }
        }
        return true;
    }

    public boolean checkWin(char symbol) {
        int a = 0; int b = 0; int c = 0;

        for (int i = 0; i < razmer;) {    // Проверка по строкам
            for (int j = 0; j < razmer; j++) {
                if(j == a) {
                    if (gameField[i][j] == symbol) a++;
                }
                if (a == cellToWin) return true;
            }
            a = 0;
            i++;
        }
        for (int i = 0; i < razmer;) {  // Проверка по столбцам
            for (int j = 0; j < razmer; j++) {
                if(j == a) {
                    if (gameField[j][i] == symbol) a++;
                }
                if (a == cellToWin) return true;
            }
            a = 0;
            i++;
        }
        for (int i = 0, j = 0; i < razmer & j < razmer; i++,j++) {  // Проверка по диагонали
            if(j == b) {
                if (gameField[i][j] == symbol) b++;
            }
            if (b == cellToWin) return true;
        }
        for (int i = 0, j = razmer-1; i < razmer & j >= 0; i++,j--) { // Проверка по диагонали
            if(i == c) {
                if (gameField[i][j] == symbol) c++;
            }
            if (c == cellToWin) return true;
        }
        return false;
    }
}
