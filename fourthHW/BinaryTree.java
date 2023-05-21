package org.moskalev.AaDS.HW.fourthHW;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    private Node add(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (current.getValue() > value) {
            current.setLeft(add(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setLeft(add(current.getRight(), value));
        } else {
            return current;
        }
        return current;
    }

    private boolean contains (Node current, int value){
        if (current == null){
            return false;
        }
        if (value == current.getValue()){
            return true;
        }
        return value < current.getValue() ? contains(current.getLeft(), value) : contains(current.getRight(), value);
    }
    private Node delete (Node current, int value){
        if (current == null){
            return null;
        }
        if (value == current.getValue()){
            if(current.getLeft() == null && current.getRight() == null){
                return null;
            }
            if (current.getRight() == null){
                return current.getLeft();
            }
            if (current.getLeft() == null){
                return current.getRight();
            }
            int smallestValue = smallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(delete(current.getRight(), smallestValue));
            return current;
        }
        if (value < current.getValue()){
            current.setLeft(delete(current.getLeft(), value));
            return current;
        }

        current.setRight(delete(current.getRight(), value));
        return current;

    }
    private int smallestValue (Node root){
        return root.getLeft() == null ? root.getValue() : smallestValue(root.getLeft());
    }

    public void delete (int value){
        root = delete(root, value);
    }

    public boolean contains (int value){
        return contains(root, value);
    }

    public void add (int value){
        root = add(root, value);
    }

    public void BFS() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.getValue());

            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }

            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }
        }
    }
}

