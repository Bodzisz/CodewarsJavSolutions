package battleshipFieldValidator;

// https://www.codewars.com/kata/52bb6539a4cf1b12d90005b7

public class BattleField {

    public static boolean fieldValidator(int[][] field) {
        int[] counter = {4,3,2,1};
        boolean[][] visited = new boolean[field.length][field.length];


        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field.length; j++) {
                if(field[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    boolean single = true;
                    if (isValid(field.length, i, j+1)) {
                        if(field[i][j+1] == 1) {
                            single = false;
                            if(!validate(0, field, visited, counter, i, j, 1)) {
                                return false;
                            }
                        }
                    }
                    if (isValid(field.length, i+1, j)) {
                        if(field[i+1][j] == 1) {
                            single = false;
                            if(!validate(1, field, visited, counter, i, j, 1)) {
                                return false;
                            }
                        }
                    }
                    if(single) {
                        counter[0]--;
                    }
                }
            }
        }
        for(int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int size, int i, int j) {
        return i < size && j < size && i >= 0 && j >= 0;
    }

    private static boolean isValidHorizontally(int[][] field, int i, int j) {
        if(isValid(field.length, i-1, j) && field[i-1][j] == 1) { return false; }
        if(isValid(field.length, i-1, j-1) && field[i-1][j-1] == 1) { return false; }
        if(isValid(field.length, i-1, j+1) && field[i-1][j+1] == 1) { return false; }
        if(isValid(field.length, i+1, j-1) && field[i+1][j-1] == 1) { return false; }
        if(isValid(field.length, i+1, j) && field[i+1][j] == 1) { return false; }
        if(isValid(field.length, i+1, j+1) && field[i+1][j+1] == 1) { return false; }
        return true;
    }
    private static boolean isValidVertically(int[][] field, int i, int j) {
        if(isValid(field.length, i-1, j-1) && field[i-1][j-1] == 1) { return false; }
        if(isValid(field.length, i, j-1) && field[i][j-1] == 1) { return false; }
        if(isValid(field.length, i+1, j-1) && field[i+1][j-1] == 1) { return false; }
        if(isValid(field.length, i-1, j+1) && field[i-1][j+1] == 1) { return false; }
        if(isValid(field.length, i, j+1) && field[i][j+1] == 1) { return false; }
        if(isValid(field.length, i+1, j+1) && field[i+1][j+1] == 1) { return false; }
        return true;
    }

    // type: 0 - horizontally, 1 - vertically
    private static boolean validate(int type, int[][] field, boolean[][] visited, int[] counter, int i, int j, int lengthOfShip) {
        visited[i][j] = true;
        if(lengthOfShip > 4) {
            return false;
        }

        if(type == 0) {
            if(!isValidHorizontally(field, i, j)) {
                return false;
            }
            else {
                if(isValid(field.length, i, j+1) && field[i][j+1] == 1) {
                    return validate(0, field, visited, counter, i, j+1, ++lengthOfShip);
                }
            }
        }
        else {
            if(!isValidVertically(field, i, j)) {
                return false;
            }
            else {
                if(isValid(field.length, i+1, j) && field[i+1][j] == 1) {
                    return validate(1, field, visited, counter, i+1, j, ++lengthOfShip);
                }
            }
        }
        counter[lengthOfShip-1]--;
        return true;
    }
}
