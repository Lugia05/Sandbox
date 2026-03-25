package org.csu.cpsc.tree;

public class MyBinarySearchTree {
    private Node root;

    public MyBinarySearchTree(int data){
        this.root = new Node(data);
    }

    public void add(int data){
        addRecursive(data, root);
    }

    private Node getMinRecursiveNode (Node currentNode){
        if(currentNode.left == null){
            return currentNode;
        } else {
            return getMinRecursiveNode(currentNode);
        }
    }

        public int getMin(){
        return getMinRecursiveNode(root).data;
    }

private Node getMaxRecursiveNode (Node currentNode){
    if(currentNode.right == null){
        return currentNode;
    } else {
        return getMaxRecursiveNode(currentNode);
    }
}

    public int getMax(){
        return getMaxRecursiveNode(root).data;
    }


    private Node addRecursive(int data, Node currentNode){
        if(currentNode == null){
            currentNode = new Node(data);
        } else {
            if(data < currentNode.data){
                currentNode.left = addRecursive(data, currentNode.left);
            } else if (data > currentNode.data){
                currentNode.right = addRecursive(data, currentNode.right);
            }
        }

        return currentNode;
    }

}

//traverse
//delete