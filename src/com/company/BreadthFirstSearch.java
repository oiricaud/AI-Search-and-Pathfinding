package com.company;

import java.util.LinkedList;
import java.util.Queue;

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
    private int color;
    private boolean goal;

    public BreadthFirstSearch(Node node){
        System.out.println("Inside the Breadth First Search class");
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        System.out.println("queue:" + queue.toString());
    }
}
