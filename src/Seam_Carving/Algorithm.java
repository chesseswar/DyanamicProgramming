package Seam_Carving;

import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.*;

public class Algorithm {
    Pixel[][] image;
    int h, w;
    public Algorithm(BufferedImage im){
        h = im.getHeight();
        w = im.getWidth();
        image = new Pixel[h][w];

        for (int i = 0; i < image.length; i++){
            for (int j = 0; j < image[0].length; j++){
                image[i][j] = new Pixel(new Color(im.getRGB(j,i)),j,i);
            }
        }

        for (int i = 0; i < image.length; i++){
            for (int j = 0; j < image[0].length; j++){
                image[i][j].energy = 1; //TODO: 1 IS NOT CORRECT, MAKE SURE YOU PUT ENERGY HERE INSTEAD
            }
        }
    }

    public int energy(int x, int y){ //TODO: ENERGY METHOD NOT CORRECT, E = (DELTA COLOR)X^2 + (DELTA COLOR)Y^2
        int delRx = image[y][mod(x-1,w)].c.getRed();
        int delGx = image[y][mod(x-1,w)].c.getGreen();
        int delBx = image[y][mod(x-1,w)].c.getBlue();

        int delRy = image[mod(y-1,h)][x].c.getRed();
        int delGy = image[mod(y-1,h)][x].c.getGreen();
        int delBy = image[mod(y-1,h)][x].c.getBlue();
        image[y][x].energy = 0;
        return x;
    }

    public int mod(int a, int b){
        return (b + a%b)%b;
    }

}
