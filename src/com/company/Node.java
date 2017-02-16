package com.company;


/**
 *
 * Created by oscarricaud on 2/16/17.
 */
public class Node {
    private int northNeighbor;
    private int southNeighbor;
    private int westNeighbor;
    private int eastNeighbor;

    // Create a new node
    public Node() {
    }

    public Node(int[][] map) {

    }

    public Node(int[][] map, int x, int y) {
        setNorthNeighbor(map, x, y);
        setSouthNeighbor(map, x, y);
    }

    // NORTH
    public int getNorthNeighbor(int[][] map, int row, int column) { // Get north neighbor from the specific position of
        if(row == 0){
            return -1;
        }
        if(row < map.length && column < map[row].length){
            return map[row-1][column];
        }
        return -1; // Not defined
    }

    public void setNorthNeighbor(int[][] map, int row, int column) {
        if(row == 0){ // Nothing on top of matrix
            this.northNeighbor = -1;
        }
    }

    // SOUTH
    public int getSouthNeighbor(int[][] map, int row, int column) { // Get north neighbor from the specific position of
        if(row == map.length){ // nothing below the matrix
            return -1;
        }
        if(row < map.length-1 && column < map[row].length){
            return map[row+1][column];
        }
        return -1; // Not defined
    }

    public void setSouthNeighbor(int[][] map, int row, int column) {
        if(row == 0){ // Nothing on top of matrix
            this.southNeighbor = -1;
        }
    }
}