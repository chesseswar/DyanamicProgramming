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

            for (int i = 1; i < table.length; i++){
                for (int j = 1; j < table[0].length; j++) {
                    table = put(table,i,j,first.substring(0,i),second.substring(0,j));
                }
            }

            System.out.println("Distance: " + table[table.length-1][table[0].length-1]);
            System.out.println(retrace(table,first,second));
        }
    }

    public static int[][] put(int[][] table, int i, int j, String first, String second){
        int lastCharMatches;

        if (lastChar(first) == lastChar(second)){
            lastCharMatches = 0;
        } else {
            lastCharMatches = 1;
        }

        table[i][j] = Math.min(Math.min(table[i-1][j]+1,table[i][j-1]+1),table[i-1][j-1]+lastCharMatches);

        return table;
    }

    public static char lastChar(String str){
        return str.charAt(str.length()-1);
    }

    public static ArrayDeque<String> retrace(int[][] table, String first, String second){
        ArrayDeque<String> output = new ArrayDeque<>();
        output.push(first);
        int x = table[0].length-1;
        int y = table.length-1;
        int count = 0;
        while (table[y][x] != 0) {
            if (x > 0 && y > 0) {
                if (y > 0 && table[y-1][x] == table[y][x] - 1){ //subtraction
                    output.push(delChar(output.peek(),y-1));

                    y--;
                } else if (y > 0 && x > 0 && table[y-1][x-1] == table[y][x] - 1){ //substitution
                    output.push(replaceChar(output.peek(),second.charAt(x-1),y-1));

                    x--;
                    y--;
                } else if (x > 0 && table[y][x-1] == table[y][x] - 1){ //addition
                    output.push(insertChar(output.peek(),second.charAt(x-1),y-1));

                    x--;
                } else {
                    x--;
                    y--;
                }
            } else if (y == 0 && x > 0){
                output.push(insertChar(output.peek(),second.charAt(x-1),0));

                x--;
            } else if (x == 0 && y > 0){
                output.push(delChar(output.peek(),y-1));

                y--;
            }
        }

        return output;
    }

    public static String delChar(String str, int index){
        return str.substring(0,index) + str.substring(index+1,str.length());
    }

    public static String insertChar(String str, char newChar, int index){
        return str.substring(0,index) + Character.toString(newChar) + str.substring(index,str.length());
    }

    public static String replaceChar(String str, char newChar, int index){
        return str.substring(0,index) + Character.toString(newChar) + str.substring(index+1,str.length());
    }

    public static void print(int[][] table){//}, String first, String second){
        for (int i = 0; i < table.length; i++){
            System.out.println(Arrays.toString(table[i]));
        }
        System.out.println();
    }
}
