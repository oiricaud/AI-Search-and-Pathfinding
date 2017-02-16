package com.company;

public class Main {
    private int dimensions; // First line
    private int x;
    private int y;

    public static void main(String[] args) {
	// write your code here
        readMapFile();
    }

    private static void readMapFile() {

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
