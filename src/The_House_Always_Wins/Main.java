package The_House_Always_Wins;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int rows = in.nextInt();
            int[][] input = new int[rows][];
            in.nextLine();
            for (int i = 0; i < rows; i++){
                String[] inputLine = in.nextLine().trim().split(" ");
                input[i] = new int[i+1];
                for (int j = 0; j < inputLine.length; j++){
                    input[i][j] = Integer.parseInt(inputLine[j]);
                }
            }
            int[][] memo = new int[rows][rows];
            for (int i = 0; i < rows; i++){
                Arrays.fill(memo[i],-1);
            }
            System.out.println((output(input,0,0,memo)));

            System.out.println(dyn(input));
        }
    }
    public static int output(int[][] input, int x, int y, int[][] memo){
        //print(memo);
        if (memo[y][x] != -1) {
            return memo[y][x];
        }

        if (input.length == 1){
            return input[0][0];
        }

        memo[y][x] = input[0][0] + Integer.max(output(smaller(input,true),x,y+1,memo),output(smaller(input,false),x+1,y+1,memo));

        return memo[y][x];
    }
    public static int[][] smaller(int[][] init, boolean left){
        int[][] output = new int[init.length-1][init.length-1];
        if (init.length == 2){
            if (left){
                output[0][0] = init[init.length-1][0];
            } else {
                output[0][0] = init[init.length-1][1];
            }
            //print(output);
            return output;
        }
        if (left){
            for (int i = 1; i < init.length; i++){
                for (int j = 0; j < i; j++){
                    output[i-1][j] = init[i][j];
                }
            }
            //print(output);
            return output;
        } else {
            for (int i = 1; i < init.length; i++){
                for (int j = 1; j < i+1; j++){
                    output[i-1][j-1] = init[i][j];
                }
            }
            //print(output);
            return output;
        }
    }

    public static int dyn(int[][] input){
        int[][] output = new int[input.length][input.length];
        for (int i = 0; i < input.length; i++){
            output[i] = new int[input[i].length];
        }
        for (int i = 0; i < input.length; i++){
            output[output.length-1][i] = input[input.length-1][i];
        }

        for (int i = input.length-2; i >= 0; i--){
            for (int j = 0; j < i+1; j++){
                //print(output);
                output[i][j] = input[i][j] + Integer.max(output[i+1][j],output[i+1][j+1]);
            }
        }

        return (output[0][0]);
    }

    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}
