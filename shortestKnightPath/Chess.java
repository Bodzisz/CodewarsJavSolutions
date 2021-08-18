package shortestKnightPath;

import java.util.*;

// https://www.codewars.com/kata/549ee8b47111a81214000941

public class Chess {
    private final static Map<Character, Integer> lettersToNum = Map.of('a', 1, 'b',2, 'c',3, 'd',4,
            'e',5, 'f',6, 'g', 7, 'h', 8);


    private static class Position {
        int a;
        int b;

        public Position(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Position) {
                return ((Position) obj).a == a && ((Position) obj).b == b;
            }
            return false;
        }
    }

    public static int knight(String start, String  finish) {
        Position startingPos = new Position(lettersToNum.get(start.charAt(0)), start.charAt(start.length() - 1) - 48);
        Position targetPos = new Position(lettersToNum.get(finish.charAt(0)), finish.charAt(start.length() - 1) - 48);

        return findPos(startingPos, targetPos);
    }

    public static int findPos(Position position, Position targetPos) {

        final boolean[][] wasThere = new boolean[8][8];
        Queue<Position> positionQueue = new LinkedList<>();
        positionQueue.add(position);
        int counter = 0;
        while(!positionQueue.isEmpty()) {
            int toCheck = positionQueue.size();
            for(int i = 0; i < toCheck; i++) {
                position = positionQueue.poll();
                wasThere[position.a - 1][position.b - 1] = true;
                positionQueue.addAll(possibleMoves(position, wasThere));
                if(position.equals(targetPos)) {
                    return counter;
                }
            }
            counter++;
        }
        return -1;
    }

    static List<Position> possibleMoves(Position position, boolean [][] wasThere) {
        List<Position> positions = new ArrayList<>();
        int a = position.a + 1;
        int b = position.b + 2;
        if(validPosition(a, b) && !wasThere[a-1][b-1]) { positions.add(new Position(a,b)); }

        a = position.a - 1;
        if(validPosition(a, b) && !wasThere[a-1][b-1]) { positions.add(new Position(a,b)); }

        a = position.a - 2;
        b = position.b + 1;
        if(validPosition(a, b) && !wasThere[a-1][b-1]) { positions.add(new Position(a,b)); }

        a = position.a + 2;
        if(validPosition(a, b) && !wasThere[a-1][b-1]) { positions.add(new Position(a,b)); }

        b = position.b - 1;
        if(validPosition(a, b) && !wasThere[a-1][b-1]) { positions.add(new Position(a,b)); }

        a = position.a - 2;
        if(validPosition(a, b) && !wasThere[a-1][b-1]) { positions.add(new Position(a,b)); }

        a = position.a - 1;
        b = position.b - 2;
        if(validPosition(a, b) && !wasThere[a-1][b-1]) { positions.add(new Position(a,b)); }

        a = position.a + 1;
        if(validPosition(a, b) && !wasThere[a-1][b-1]) { positions.add(new Position(a,b)); }


        return positions;
    }

    static boolean validPosition(int a, int b) {
        return a > 0 && a < 9 && b > 0 && b < 9;
    }
}

