import matrixDeterminant.Matrix;
import numberOfProperFractionsWithDenominatorD.ProperFractions;
import permutations.Permutations;

public class Main {

    public static void main(String[] args) {
        int [][] array = {
                {2,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] result = Matrix.minorOf(array, 1);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Matrix.determinant(array));
    }
}
