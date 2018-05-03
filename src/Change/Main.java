package Change;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int goal = in.nextInt();
            int numCoins = in.nextInt();
            HashMap<Integer,Integer> coins = new HashMap<>();
            int[][] table = new int[numCoins][goal+1];
            for (int i = 0; i < numCoins; i++){
                coins.put(i,in.nextInt());
            }

            for (int i = 0; i < numCoins; i++){
                for (int j = 1; j <= goal; j++){
                    table = put(table,i,j,coins);
                }
            }
            print(table);
            //System.out.println(table[numCoins-1][goal]);
        }
    }

    public static int[][] put(int[][] table, int row, int col, HashMap<Integer,Integer> coins){
        if (row == 0){
            if (col % coins.get(row) == 0){
                table[row][col] = col / coins.get(row);
            }
            return table;
        } else {
            int previous = table[row-1][col];
            if (col < coins.get(row)){
                table[row][col] = previous;
                return table;
            }

            table[row][col] = Integer.min(table[row][col-coins.get(row)] + 1, table[row-1][col]);
            return table;
        }
    }

    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}
