package Sierpinski;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] x = {0, 500, 1000};
        int[] y = {1000, 0, 1000};
        String[] colors = {"green", "blue", "red"};
        for (int i = 3; i > 0; i++){
            Triangle t = new Triangle();
            t.draw(x, y, colors[i%colors.length]);
            sierpin(x, y, i);

            wait(1);
        }


    }

    public static void sierpin(int[] x, int[] y, int depth){
        draw(0, x, y, depth);
    }

    public static void draw(int index, int[] x, int[] y, int depth){
        if (index < depth){
            int[] leftX = {average(x[0], x[1]), x[1], average(x[1], x[2])};
            int[] leftY = {average(y[0],y[1]), y[0], average(y[0], y[1])};

            Triangle t = new Triangle();
            t.draw(leftX, leftY, "white");

            int[] nextX = {x[0], leftX[0], leftX[1]};
            int[] nextY = {y[0], leftY[0], y[0]};
            draw(index + 1, nextX, nextY, depth);
            nextX = leftX;

            nextY[0] = leftY[0];
            nextY[1] = y[1];
            nextY[2] = leftY[0];

            draw(index + 1, nextX, nextY, depth);

            nextX[0] = x[1];
            nextX[1] = leftX[2];
            nextX[2] = x[2];

            nextY[0] = y[0];
            nextY[2] = nextY[0];
            nextY[1] = leftY[0];

            draw(index + 1, nextX, nextY, depth);
        }
    }

    public static int average(int x, int y){
        return (x + y) / 2;
    }

    public static void wait(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        }
        catch (Exception e)
        {
            // ignoring exception at the moment
        }
    }
}

