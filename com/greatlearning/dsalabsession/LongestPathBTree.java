package com.greatlearning.dsalabsession;

import java.util.ArrayList;

public class LongestPathBTree {

    class Node {
        Node left ;
        Node right ;
        int data ;
    }

    Node newNode(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

     ArrayList<Integer>  findLongestPath(Node root){
        if(root == null) return new ArrayList<>(); ;

        ArrayList<Integer> right = findLongestPath(root.right);
        ArrayList<Integer> left = findLongestPath(root.left);

        if(right.size() < left.size())
            left.add(root.data);
        else
            right.add(root.data);

        return left.size() > right.size() ? left : right;
    }

    Node insert(Node root , int key){
        Node newNode = newNode(key);

        Node x = root;
        Node current_parent = null;

        //find the node @to which new node to be added.
        while(null != x){
            current_parent = x;
            if(key < x.data){
                x = x.left;
            }else if (key > x.data){
                x = x.right;
            }else{
                System.err.println("value already exists");
                return newNode;
            }
        }

        // add new node to @identified node
        if(current_parent == null){
            current_parent = newNode ;
        }
        else if(key < current_parent.data ){
            current_parent.left = newNode;
        }else if(key > current_parent.data){
            current_parent.right = newNode;
        }

        return current_parent;
    }

    void printPath(ArrayList<Integer> arrayList){
        if(arrayList==null)
            return;

        System.out.print("Longest Path ");
        for(int i = arrayList.size() -1 ; i>=0 ; i--){
            System.out.print(arrayList.get(i));
            if(i != 0) System.out.print(" -> ");
        }
    }

    public static void main(String[] args) {
        LongestPathBTree bTree = new LongestPathBTree();
        ArrayList<Integer> arrayList ;
        Node root = null;

        Integer[] array = new Integer[]{ 30,20,35,21,22,23,24,7,25,3 };

        for(Integer ele : array){
            if(root == null){
                root = bTree.insert(root , ele);
            }else{
                bTree.insert(root , ele);
            }
        }

        arrayList = bTree.findLongestPath(root);

        bTree.printPath(arrayList);

    }

}
