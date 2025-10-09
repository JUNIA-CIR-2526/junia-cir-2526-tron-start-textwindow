package com.jad;

import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;

import java.awt.event.KeyEvent;


public class Game {
    private final int width = 50;
    private final int height = 10;
    public char[][] grid;
    StringBuilder display = new StringBuilder();
    private TextWindow tw;
    private LightCycle player1;
    private LightCycle player2;


    public Game() {
        TextWindowSettings settings = new TextWindowSettings();

        settings.setScreenWidth(width);
        settings.setScreenHeight(height);

        tw = new TextWindow();
        tw.setVisible(true);
        grid = new char[width][height];

        inputSettings(settings);

        player1 = new LightCycle(20, height / 2, 1, '§', '#');
        player2 = new LightCycle(60, height / 2, 3, '§', '#');


    }

    private void inputSettings(TextWindowSettings settings) {
        settings.addKeyboardListener(KeyEvent.VK_UP, "p1_up");
        settings.addKeyboardListener(KeyEvent.VK_RIGHT, "p1_right");
        settings.addKeyboardListener(KeyEvent.VK_DOWN, "p1_down");
        settings.addKeyboardListener(KeyEvent.VK_LEFT, "p1_left");

        settings.addKeyboardListener(KeyEvent.VK_Z, "p2_up");
        settings.addKeyboardListener(KeyEvent.VK_D, "p2_right");
        settings.addKeyboardListener(KeyEvent.VK_S, "p2_down");
        settings.addKeyboardListener(KeyEvent.VK_Q, "p2_left");

        settings.addKeyboardListener(KeyEvent.VK_ESCAPE, "exit");

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

        if (tw.isOn("p2_up")) {
            player2.setDirection(0);
        }
        if (tw.isOn("p2_right")) {
            player2.setDirection(1);
        }
        if (tw.isOn("p2_down")) {
            player2.setDirection(2);
        }
        if (tw.isOn("p2_left")) {
            player2.setDirection(3);
        }

    }

    private void collisions() {
        int p1isAlive = 1;
        int p2isAlive = 1;

        for (Position p : player1.getTrail()) {
            if (player1.getX() == p.getX() && player1.getY() == p.getY()) {
                p1isAlive = 0;
            }
        }
        for (Position p : player2.getTrail()) {
            if (player1.getX() == p.getX() && player1.getY() == p.getY()) {
                p1isAlive = 0;
            }
        }
        for (Position p : player1.getTrail()) {
            if (player2.getX() == p.getX() && player2.getY() == p.getY()) {
                p2isAlive = 0;
            }
        }
        for (Position p : player2.getTrail()) {
            if (player2.getX() == p.getX() && player2.getY() == p.getY()) {
                p2isAlive = 0;
            }
        }


        if (p1isAlive == 0 && p2isAlive == 0) {
            display.append("MATCH NUL !");
        } else if (p1isAlive == 0) {
            display.append("LE JOUEUR 2 GAGNE !");
        } else if (p2isAlive == 0)
            display.append("LE JOUEUR 1 GAGNE !");
    }

    private void title() {
        display.append("=== TRON LIGHT CYCLES ===\n\n");
        display.append("Player 1 (1): Flèches directionnelles\n");
        display.append("Player 2 (2): WASD\n\n");
        sleep(3000);
    }

    private void display() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = ' ';
            }
        }

        for (Position p : player1.getTrail()) {
            grid[p.getY()][p.getX()] = player1.getWalls();
        }
        for (Position p : player2.getTrail()) {
            grid[p.getY()][p.getX()] = player2.getWalls();
        }

        grid[player1.getY()][player1.getX()] = player1.getPlayer();
        grid[player2.getY()][player2.getX()] = player2.getPlayer();


        tw.display(display.toString());

    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        title();

        while (tw.isOff("exit")) {

            player1.move();

            player2.move();

            collisions();

            display();

            sleep(100);
        }
        tw.close();
    }
}

