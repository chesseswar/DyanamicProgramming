package Seam_Carving;

import java.awt.*;

public class Pixel {
    Color c;
    int energy, x, y;
    public Pixel(Color c, int x, int y){
        this.c = c;
        this.x = x;
        this.y = y;
    }
}
