package Edit_Distance;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));

        int numCase = in.nextInt(); in.nextLine();
        while (numCase-- > 0){
            String first = in.nextLine();
            String second = in.nextLine();
            int[][] table = new int[first.length()+1][second.length()+1];
            for (int i = 1; i < table.length; i++){
                table[i][0] = i;
            }

            for (int i = 1; i < table[0].length; i++){
                table[0][i] = i;
            }

            if (first.charAt(0) != second.charAt(0)){
                table[1][1] = 1;
            }

            print(table);
        }
    }

    public static



    public static void print(int[][] table){
        for (int i = 0; i < table.length; i++){
            System.out.println(Arrays.toString(table[i]));
        }
        System.out.println();
    }
}
