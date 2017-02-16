package com.company;


/**
 *
 * Created by oscarricaud on 2/16/17.
 */
public class Node {
    Node start;
    Node goal;
    int cargo;

    int row = 5;
    int column = 7;
    private int key;
    private int northNeighbor;
    Node southNeighbor;
    Node westNeighbor;
    Node eastNeighbor;
    private int[][] grid;

    // Create a new node
    public Node() {
    }

    public Node(int[][] map) {

    }

    public Node(int[][] map, int x, int y) {
        setNorthNeighbor(map, x, y);
    }


    public void setKey(int n) {
        key = n;
    }

    public int getKey() {
        return key;
    }

    public int getNorthNeighbor(int[][] map, int row, int column) { // Get north neighbor from the specific position of
        // arrays
        if (row == 0) { // Nothing on top of matrix
            return -1;
        }
        else{
            return map[row-1][column];
        }
    }


    public void setNorthNeighbor(int[][] map, int row, int column) {
        if(row == 0){ // Nothing on top of matrix
            this.northNeighbor = -1;
        }
    }
}