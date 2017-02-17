package com.company;

public class Main {
    private int x;
    private int y;

    public static void main(String[] args) {

        int map[][] = readMapFile(); // should return the coordinates here

        //Given
        int startStateRow = 1;
        int startStateColumn = 2;
        int[] startStateCoordinates = new int[2];
        startStateCoordinates[0] = 2;
        startStateCoordinates[1] = 1;
        int startState = findKey(map, startStateRow, startStateColumn);

        //Given
        int goalStateRow = 4;
        int goalSateColumn = 3;
        int[] goalStateCoordinates = new int[2];
        goalStateCoordinates[0] = 3;
        goalStateCoordinates[1] = 1;
        int finalState = findGoal(map, goalStateRow, goalSateColumn);

        Node node = new Node();

        // Iterate through map
        for(int row = 0 ; row < map.length ; row++){
            for(int column = 0 ; column < map[row].length; column++){
                System.out.print(String.format("%10s", map[row][column]));
                node = new Node(map, row, column);
            }
            System.out.println("");
        }
       // int [] allNeighbors = findMeNeighbors(node, map, x, y);
        BreadthFirstSearch bfs = new BreadthFirstSearch(node, map, startStateCoordinates, goalStateCoordinates);

        /**
        System.out.println("Start state is: " + startState + " and is located (" + startStateRow + ", " + startStateColumn + ")");
        System.out.println("Goal state is: " + finalState + " and is located (" + goalStateRow + ", " + goalSateColumn + ")");
        **/
     }

    /**
     * @param node is the current node we are in. We find the north, south, west and east neighbors based on this node.
     * @param map is the map of all nodes.
     * @param x represents the rows
     * @param y represents the columns

    private static int[] findMeNeighbors(Node node, int[][] map, int x, int y) {
        int [] neighbors = new int[4]; // [0] = North, [1] = South, [2] = West, [3] = East
        neighbors[0] = node.getNorthNeighbor(map, x, y);
        neighbors[1] = node.getSouthNeighbor(map, x, y);
        neighbors[2] = node.getWestNeighbor(map, x, y);
        neighbors[3] = node.getEastNeighbor(map, x, y);
        return neighbors;
        /* UNCOMMENT FOR DEBUG
        System.out.println("Get north neighbor: " + node.getNorthNeighbor(map, x, y));
        System.out.println("Get south neighbor: " + node.getSouthNeighbor(map, x, y));
        System.out.println("Get west neighbor: " + node.getWestNeighbor(map, x, y));
        System.out.println("Get east neighbor: " + node.getEastNeighbor(map, x, y));
    }
*/
    private static int findGoal(int[][] map, int goalStateRow, int goalSateColumn) {
        return map[goalSateColumn][goalStateRow];
    }

    private static int findKey(int[][] map, int keyRow, int keyColumn) {
        return map[keyColumn][keyRow];
    }

    private static int[][] readMapFile() {
        return new int [][]{
                // Columns
                {2, 4, 2, 1, 4, 5, 2}, // Row 1
                {0, 6, 2, 3, 5, 3, 1}, // Row 2
                {2, 0, 4, 4, 1, 2, 4},
                {2, 55, 5, 3, 2, 0, 1},
                {4, 3, 3, 2, 1, 0, 1}
        };
    }

    /**
     * @param x is the row
     * @param y is the column
     */
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }
    public String coordinatesConvertToString() {
        return "(" + x + "," + y + ")";
    }
}
