package com.company;

import java.util.*;

/**
 * Created by oscarricaud on 2/16/17.
Pseudocode:
        Step 1: Push the root node in the Queue.
        Step 2: Loop until the queue is empty.
        Step 3: Remove the node from the Queue
        Step 4: If the removed node has unvisited child nodes, mark them as
                visited and insert the unvisited children in the queue.
 **/
public class BreadthFirstSearch {

    Map<String, Integer> colorFlag = new HashMap<String, Integer>(); // Determins if nodes have been colored by
    LinkedList<Integer> finalList = new LinkedList<Integer>();
    int[] northCoordinates = new int[2];
    int[] southCoordinates = new int[2];
    int[] neighbors = new int[4];

    int[][] placesYouHaveBeen = new int[][]{
            // Columns
            {0, 0, 0, 0, 0, 0, 0}, // Row 1
            {0, 0, 0, 0, 0, 0, 0}, // Row 2
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };

    public BreadthFirstSearch(Node node, int[][] map, int[] startStateCoordinates, int[] goalStateCoordinates) {

        // START COORDINATES
        int rowStart = startStateCoordinates[0];
        int columnStart = startStateCoordinates[1];

        // GOAL COORDINATES
        int rowGoal = goalStateCoordinates[0];
        int columnGoal = goalStateCoordinates[1];

        int currRow;
        int currColumn;

        System.out.println("Starting state (x,y) = (" + rowStart + "," + columnStart + ")");
        System.out.println("Goal state (x,y) = (" + rowGoal + "," + columnGoal + ")");

        System.out.println("Get north neighbor: " + node.getNorthNeighbor(map, rowStart, columnStart));
        System.out.println("Get south neighbor: " + node.getSouthNeighbor(map, rowStart, columnStart));
        System.out.println("Get west neighbor: " + node.getWestNeighbor(map, rowStart, columnStart));
        System.out.println("Get east neighbor: " + node.getEastNeighbor(map, rowStart, columnStart));

        // START STATE NEIGHBORS
        int north = node.getNorthNeighbor(map, rowStart, columnStart);
        int south = node.getSouthNeighbor(map, rowStart, columnStart);
        int west = node.getWestNeighbor(map, rowStart, columnStart);
        int east = node.getEastNeighbor(map, rowStart, columnStart);

        // START OUR QUEUE & ADD CURRENT STATE
        Queue<Integer> queue = new LinkedList<>();
        queue.add(map[rowStart][columnStart]);

        Node curr = new Node();

        // PUSH FIRST ELEMENT OF QUEUE
        currRow = rowStart;
        currColumn = columnStart;
        int currValue = node.getValueAtCoordinats(map, currRow, currColumn);
        queue.add(currValue); // Add first node to the queue
        placesYouHaveBeen[rowStart][columnStart] = 1;
        Map<Integer, String> sortCoordinates_ = node.sortCoordinates(map, rowStart, columnStart);
        System.out.println("Sorted coordinates: ");
        Set set = sortCoordinates_.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
            queue.add((Integer) me.getKey());
            if(me.getValue() == "north") {
                placesYouHaveBeen[rowStart-1][columnStart] = 1;
            }
            if(me.getValue() == "south") {
                placesYouHaveBeen[rowStart+1][columnStart] = 1;
            }
            if(me.getValue() == "west") {
                placesYouHaveBeen[rowStart][columnStart-1] = 1;
            }
            if(me.getValue() == "east") {
                placesYouHaveBeen[rowStart][columnStart+1] = 1;
            }
            queue.remove(); // remove the head
        }
        placesYouHaveBeenPrintNice(placesYouHaveBeen);
    }

    private void placesYouHaveBeenPrintNice(int[][] placesYouHaveBeen) {
        // Iterate through map
        for(int row = 0 ; row < placesYouHaveBeen.length ; row++){
            for(int column = 0 ; column < placesYouHaveBeen[row].length; column++){
                System.out.print(String.format("%10s", placesYouHaveBeen[row][column]));
            }
            System.out.println("");
        }
    }
}
