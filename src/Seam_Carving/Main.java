package Seam_Carving;

import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        while (in.hasNext()){
            BufferedImage image = ImageIO.read(new File(in.nextLine()));
            Algorithm algorithm = new Algorithm(image);
        }
    }
}
