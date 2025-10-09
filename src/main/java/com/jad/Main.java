package com.jad;

import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;

import java.awt.*;
import java.awt.event.KeyEvent;

public enum Main {
    ;

    public static void main(String[] args) {
        TextWindowSettings settings = new TextWindowSettings();
        settings.addKeyboardListener(KeyEvent.VK_ESCAPE, "exit");
        settings.addKeyboardListener(KeyEvent.VK_Q, "player1_left");

        settings.setScreenHeight(10);
        settings.setScreenWidth(50);
        TextWindow textWindow = new TextWindow(settings);
        textWindow.setVisible(true);

        Point lastMousePosition;
        while (textWindow.isOff("exit")) {

//            textWindow.display(message.toString());
        }
        textWindow.close();
    }
}