import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();



        System.out.println("N value:");
        int n = sc.nextInt();

        System.out.println("M value:");
        int m = sc.nextInt();

        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                matrix[i][j] = rnd.nextInt(10);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=================");

        int[][] tempMatrix = new int[n][n];



        tempMatrix [0][0] = matrix[0][0];
        int opCounter = 1;
        for(int i = 1; i < n; ++i) {
            tempMatrix[0][i] = tempMatrix[0][i - 1] + matrix[0][i];
            opCounter++;
        }
        for(int i = 1; i < n; ++i) {
            tempMatrix[i][0] = tempMatrix[i - 1][0] + matrix[i][0];
            opCounter++;
        }
        for(int i = 1; i < n; ++i)
            for(int j = 1; j < n; ++j) {
                tempMatrix[i][j] = matrix[i][j] + tempMatrix[i - 1][j] + tempMatrix[i][j - 1] - tempMatrix[i - 1][j - 1];
                opCounter++;
            }

        System.out.println("Operations: " + opCounter + "\n n*n=" + n*n);

        sc.close();
    }
}
