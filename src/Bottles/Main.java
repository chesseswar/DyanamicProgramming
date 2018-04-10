package Bottles;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner("bottles.dat");
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int bottles = in.nextInt();
            String[] input = in.nextLine().split(" ");
            int[] vals = new int[bottles];
            for (int i = 0; i < bottles; i++){
                //vals[i] =
            }
        }
    }
}
