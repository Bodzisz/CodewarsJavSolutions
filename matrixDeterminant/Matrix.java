package matrixDeterminant;

// https://www.codewars.com/kata/52a382ee44408cea2500074c

public class Matrix {

    public static int determinant(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        else if(matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        else {
            int result = 0;
            for(int i = 0; i < matrix.length; i++) {
                result += matrix[0][i] * determinant(minorOf(matrix, i)) * (i % 2 == 0? 1 : -1);
            }
            return result;
        }
    }

    public static int[][] minorOf(int[][] matrix, int index) {
        int[][] minor = new int[matrix.length - 1][matrix.length - 1];
        boolean crossed = false;

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if (j == index) {
                    crossed = true;
                }
                else {
                    if (!crossed) {
                        minor[i - 1][j] = matrix[i][j];
                    } else {
                        minor[i - 1][j - 1] = matrix[i][j];
                    }
                }
            }
            crossed = false;
        }
        return minor;
    }
}
