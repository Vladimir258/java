package ru.geekbrains;

import ru.geekbrains.constants.Settings;
import ru.geekbrains.utils.ArrayTools;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFormUi {
    int stepCounter = 0;
    int countPressed = 0;           // Счётчик нажатий
    JButton tempButton = null;
    JFrame GAME_FORM = new JFrame("GAME");
    int pressedButtonNumber = 0;

    void createGameForm() {
        GAME_FORM.setLayout(null);
        GAME_FORM.setVisible(true);
        GAME_FORM.setResizable(false);
        GAME_FORM.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GAME_FORM.setBounds(Settings.FORM_POSITION_COORD, Settings.FORM_POSITION_COORD, Settings.FORM_WIDTH, Settings.FORM_HEIGHT);
        createButtons();
        GAME_FORM.repaint();
    }

    void createButtons() {
        int[] buttonNumbers = ArrayTools.generateArray(Settings.BUTTONS_AMOUNT);
        for (int buttonNumber : buttonNumbers) {
            JButton gameButton = new JButton();
            gameButton.setName(String.valueOf(buttonNumber));
            gameButton.setBounds(Settings.xCoord, Settings.yCoord, Settings.BUTTON_WIDTH_HEIGHT, Settings.BUTTON_WIDTH_HEIGHT);
            gameButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(countPressed == 1) { // Второе нажатие мышки
                        gameButton.setText(gameButton.getName());
                        if (pressedButtonNumber == Integer.parseInt(gameButton.getName())) {
                            if(gameButton != tempButton) {           // Если кнопка не равна предыдущей кнопке
                                gameButton.setVisible(false);
                                tempButton.setVisible(false);
                                stepCounter++;
                                if(stepCounter == 8) System.exit(1); // Так как поле содержит 16 кнопок, удачных комбинаций 8. Считаем их и при достижении 8ки, выходим
                            }
                        }
                        else {
                            tempButton.setText("");
                            pressedButtonNumber = 0;
                            if(gameButton == tempButton) {
                                tempButton.setText("");
                            }
                        }
                    }
                    else {
                        gameButton.setText(gameButton.getName());
                        pressedButtonNumber = Integer.parseInt(gameButton.getName());
                        tempButton = gameButton;
                    }
                    countPressed++;
                    if(countPressed == 2) {  // Обнуляем счетчик нажатий кнопки
                        countPressed = 0;
                        gameButton.setText("");
                    }
                }
            });
            GAME_FORM.add(gameButton);
            Settings.xCoord = Settings.xCoord + 110;
            if (Settings.xCoord > 340) {
                Settings.xCoord = 10;
                Settings.yCoord = Settings.yCoord + Settings.FORM_POSITION_COORD + Settings.xCoord;
            }
        }
    }
}
