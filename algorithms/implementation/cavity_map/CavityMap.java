import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        return getString(findWells(createMat(grid)));
    }
    static int[][] createMat(String[] grid) {
        int n = grid.length;
        int[][] mat = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            System.out.println(grid[i]);
            for(int j = 0; j < n; j++) {
                mat[i][j] = (int)(grid[i].charAt(j) - '0');
            }
        }
        return mat;
    }
    
    static int[][] findWells(int[][] mat) {
        int n = mat.length;
        int[][] mat_cpy = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                mat_cpy[i][j] = mat[i][j];
                System.out.println("mat: " + Integer.toString(mat[i][j]) +
                                   ", cpy: " + Integer.toString(mat_cpy[i][j]));
            }
        }
        
        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(mat[i][j] > mat[i - 1][j] && mat[i][j] > mat[i + 1][j] &&
                   mat[i][j] > mat[i][j - 1] && mat[i][j] > mat[i][j + 1]) mat_cpy[i][j] = -1;
            }
        }
        return mat_cpy;
    }
    
    static String[] getString(int[][] mat) {
        int n = mat.length;
        String[] output = new String[n];
        for(int i = 0; i < n; i++) {
            output[i] = "";
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == -1) {
                    output[i] += "X";
                }
                else {
                    output[i] += Integer.toString(mat[i][j]);
                }
            }
        }
        return output;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

