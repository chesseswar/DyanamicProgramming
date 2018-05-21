package Change;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));

        int numCase = in.nextInt();
        while (numCase-- > 0){

            int numCoins = in.nextInt();

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < numCoins; i++){
                list.add(in.nextInt());
            }

            HashMap<Integer,Integer> coins = new HashMap<>();
            int goal = in.nextInt();

            for (int i = 0; i < numCoins; i++){
                coins.put(i,list.get(i));
            }
            int[][] table = new int[numCoins][goal+1];
            for (int i = 0; i < numCoins; i++){
                for (int j = 1; j <= goal; j++){
                    table = put(table,i,j,coins);
                }
            }

            HashMap<Integer,Integer> retrace = retrace(table,coins);

            System.out.print(table[numCoins-1][goal] + " ");
            for (int i = 0; i < list.size(); i++){
                if (!retrace.containsKey(list.get(i))){
                    System.out.print("0 ");
                } else {
                    System.out.print(retrace.get(list.get(i)) + " ");
                }
            }
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

    public static HashMap<Integer,Integer> retrace(int[][] table, HashMap<Integer,Integer> coins){
        int x = table[0].length-1, y = table.length-1;

        HashMap<Integer,Integer> output = new HashMap<>();

        while (x != 0){
            while (y > 0 && table[y][x] == table[y-1][x]){
                y--;
            }

            if (x < 0){
                return output;
            }

            if (output.containsKey(coins.get(y))){
                output.put(coins.get(y),output.get(coins.get(y)) + 1);
            } else {
                output.put(coins.get(y),1);
            }

            x -= coins.get(y);
        }

        return output;
    }
}
