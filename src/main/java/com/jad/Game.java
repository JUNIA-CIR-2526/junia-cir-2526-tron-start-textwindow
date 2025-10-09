package com.jad;

import com.jad.textwindow.TextWindow;

import java.awt.event.KeyEvent;


public class Game {
    private int width = 80;
    private int height = 40;
    private TextWindow tw;
    private char[][] grid;
    private LightCycle player1;
    private LightCycle player2;
    private int gameOver;

    public Game() {
        tw = new TextWindow();
        grid = new char[width][height];

        player1 = new LightCycle(20, height / 2, 1, '§', '#');
        player2 = new LightCycle(60, height / 2, 3, '§', '#');

        gameOver = 0;


    }

    private void inputSettings() {
        tw.addKeyboardListener(KeyEvent.VK_UP, "p1_up");
        tw.addKeyboardListener(KeyEvent.VK_RIGHT, "p1_right");
        tw.addKeyboardListener(KeyEvent.VK_DOWN, "p1_down");
        tw.addKeyboardListener(KeyEvent.VK_LEFT, "p1_left");

        tw.addKeyboardListener(KeyEvent.VK_Z, "p2_up");
        tw.addKeyboardListener(KeyEvent.VK_D, "p2_right");
        tw.addKeyboardListener(KeyEvent.VK_S, "p2_down");
        tw.addKeyboardListener(KeyEvent.VK_Q, "p2_left");

        tw.addKeyboardListener(KeyEvent.VK_ESCAPE, "exit")

        if (tw.isOn("p1_up")) {
            player1.setDirection(0);
        }
        if (tw.isOn("p1_right")) {
            player1.setDirection(1);
        }
        if (tw.isOn("p1_down")) {
            player1.setDirection(2);
        }
        if (tw.isOn("p1_left")) {
            player1.setDirection(3);
        }
    }


}
