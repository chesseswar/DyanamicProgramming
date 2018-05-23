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
                energy(j,i);
            }
        }
    }

    public void energy(int x, int y){
        int delRx = image[y][mod(x-1,w)].c.getRed();
        int delGx = image[y][mod(x-1,w)].c.getGreen();
        int delBx = image[y][mod(x-1,w)].c.getBlue();

        int delRy = image[mod(y-1,h)][x].c.getRed();
        int delGy = image[mod(y-1,h)][x].c.getGreen();
        int delBy = image[mod(y-1,h)][x].c.getBlue();
        image[y][x].energy = delRx^2 + delGx^2 + delBx^2 + delRy^2 + delGy^2 + delBy^2;
    }

    public int[] computeSeam

    public int mod(int a, int b){
        return (b + a%b)%b;
    }

}
