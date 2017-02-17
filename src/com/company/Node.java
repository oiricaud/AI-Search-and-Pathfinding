package com.company;


import java.util.*;

/**
 *
 * Created by oscarricaud on 2/16/17.
 */
public class Node {
    private int northNeighbor;
    private int southNeighbor;
    private int westNeighbor;
    private int eastNeighbor;

    /* Coordinates*/
    private int [] NorthNeighborCoordinates = new int[2];
    private String color; // white = not visited , red = visited
    // Create a new node
    public Node() {
    }

    public Node(int[][] map) {

    }

    public Node(int[][] map, int x, int y) {
        setNorthNeighbor(map, x, y);
     //   System.out.println("In Node class: x " + x);
        NorthNeighborCoordinates[0] = x;
        NorthNeighborCoordinates[1] = y;
        setNorthNeighborCoordinates(NorthNeighborCoordinates);
        setSouthNeighbor(map, x, y);
        setWestNeighbor(map, x, y);
        setEastNeighbor(map, x, y);
        sortCoordinates(map, x, y);
        setColor("white");
    }

    public Map<Integer, String> sortCoordinates(int[][] finalMap, int x, int y) {
        HashMap<Integer, String> coordinates = new HashMap<Integer, String>();
        coordinates.put(getNorthNeighbor(finalMap, x, y), "north");
        coordinates.put(getSouthNeighbor(finalMap, x, y), "south");
        coordinates.put(getWestNeighbor(finalMap, x, y), "west");
        coordinates.put(getEastNeighbor(finalMap, x, y), "east");
        return coordinates;
    }

    public int[] getCurrentCoordinates(int[][]map, int row, int column){
        int [] coordinates = new int[2];
        coordinates[0] = row;
        coordinates[1] = column;
        return coordinates;
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
    public int[] getNorthNeighborCoordinates(){

        return NorthNeighborCoordinates;
    }

    private int[] setNorthNeighborCoordinates(int[] northNeighborCoordinates) {
        NorthNeighborCoordinates[0] = northNeighborCoordinates[0];
        NorthNeighborCoordinates[1] = northNeighborCoordinates[1];
        return NorthNeighborCoordinates;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public int getValueAtCoordinats(int[][] map, int row, int column){
        return map[row][column];
    }
    /**
     * @param node is the current node we are in. We find the north, south, west and east neighbors based on this node.
     * @param map is the map of all nodes.
     * @param x represents the rows
     * @param y represents the columns
     */
    public static int[] findMeNeighbors(Node currNode, int[][] map, int x, int y) {
        int [] neighbors = new int[4]; // [0] = North, [1] = South, [2] = West, [3] = East
        neighbors[0] = currNode.getNorthNeighbor(map, x, y);
        neighbors[1] = currNode.getSouthNeighbor(map, x, y);
        neighbors[2] = currNode.getWestNeighbor(map, x, y);
        neighbors[3] = currNode.getEastNeighbor(map, x, y);
        return neighbors;
        /* UNCOMMENT FOR DEBUG
        System.out.println("Get north neighbor: " + node.getNorthNeighbor(map, x, y));
        System.out.println("Get south neighbor: " + node.getSouthNeighbor(map, x, y));
        System.out.println("Get west neighbor: " + node.getWestNeighbor(map, x, y));
        System.out.println("Get east neighbor: " + node.getEastNeighbor(map, x, y));
        */
    }
}