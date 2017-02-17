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

        setWestNeighbor(map, x, y);
        setEastNeighbor(map, x, y);
    }

    // NORTH
    public int getNorthNeighbor(int[][] map, int row, int column) { // Get north neighbor from the specific position of
        if(row <= 0){
            return -1;
        }
        if(row < map.length && column < map[row].length){
            return map[row-1][column];
        }
        return -1; // Not defined
    }

    public void setNorthNeighbor(int[][] map, int row, int column) {
        if(row <= 0){ // Nothing on top of matrix
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
        if(row == map.length){ // Nothing on below of matrix
            this.southNeighbor = -1;
        }
    }

    // WEST
    public int getWestNeighbor(int[][] map, int row, int column) { // Get west neighbor from the specific position of
        if(column <= 0 || column-1 > map.length){ //  Nothing on left or right of matrix
            return -1;
        }
        return map[row][column-1];
    }

    public void setWestNeighbor(int[][] map, int row, int column) {
        if(column <= 0 || column > map.length){ // Nothing on left or right of matrix
            this.southNeighbor = -1;
        }
    }

    // EAST
    public int getEastNeighbor(int[][] map, int row, int column) { // Get west neighbor from the specific position of
        if(column > map.length){ //  Nothing on left or right of matrix
            return -1;
        }
        return map[row][column+1];
    }

    public void setEastNeighbor(int[][] map, int row, int column) {
        if(column > map.length){ // Nothing on left or right of matrix
            this.southNeighbor = -1;
        }
    }
}