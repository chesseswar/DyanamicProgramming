package Bottles;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("bottles.dat"));
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int bottles = in.nextInt();
            String[] input = in.nextLine().trim().split(" ");
            int[] vals = new int[bottles];
            for (int i = 0; i < bottles; i++){
                vals[i] = Integer.parseInt(input[i]);
            }

            int[] maxVol = new int[vals.length];
            maxVol[0] = vals[0];
            maxVol[1] = Math.max(vals[0], vals[1]);
            for (int i = 2; i < vals.length; i++){
                int output = Math.max(maxVol[i-1], maxVol[i-2] + vals[i]);
                maxVol[i] = output;
            }
            System.out.println(Arrays.toString(maxVol));
        }
    }

    public static int maxVol(int[] bottles){
        int[] memo = new int[bottles.length];
        Arrays.fill(memo, -1);
        memo[0] = bottles[0];
        memo[1] = Math.max(bottles[0], bottles[1]);
        return vol(bottles, bottles.length-1, memo);
    }

    public static int vol(int[] bottles, int index, int[] memo){
        if (memo[index] != -1){
            return memo[index];
        } else {
            memo[index] = Math.max(vol(bottles, index-2, memo) + bottles[index], vol(bottles, index-1, memo));
            return memo[index];
        }
    }


}
