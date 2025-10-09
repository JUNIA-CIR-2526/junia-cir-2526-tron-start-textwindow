package com.jad;

import java.util.ArrayList;
import java.util.List;

public class LightCycle {
    private int x;
    private int y;
    private int direction;
    private char player;
    private char walls;
    private List<Position> trail;

    public LightCycle(int x, int y, int direction, char player, char walls) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.player = player;
        this.walls = walls;
        this.trail = new ArrayList<>();
    }

    public void move() {
        trail.add(new Position(x, y));

        if (direction == 0) {
            y = y - 1;
        } else if (direction == 1) {
            x = x + 1;
        } else if (direction == 2) {
            y = y + 1;
        } else if (direction == 3) {
            x = x - 1;
        }
    }

    public void setDirection(int newDirection) {
        this.direction = newDirection;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getPlayer() {
        return player;
    }

    public char getWalls() {
        return walls;
    }

    public List<Position> getTrail() {
        return trail;
    }
}
