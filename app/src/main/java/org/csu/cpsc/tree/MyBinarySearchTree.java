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

    public String inorderTraversal(){
        return inorderTraversalRecursive(root);
    }

    //Preorder [R] ->
            private String preorderTraversalRecursive(Node currentNode){
            if (currentNode == null){
                return "";
            } else {
                //root data -> currentNode.data
                return " " + currentNode.data + preorderTraversalRecursive(currentNode.left) + preorderTraversalRecursive(currentNode.right);
            }
        }

        private String inorderTraversalRecursive(Node currentNode){
            if(currentNode == null){
                return "";
            } else {
                return inorderTraversalRecursive(currentNode.left) + " " + currentNode.data + inorderTraversalRecursive(currentNode.right);
            }
        }

        private Node deleteRecursive(int value, Node currentNode){
            if(value < currentNode.data){
                currentNode.left = deleteRecursive(value, currentNode.left);
            } else if(value > currentNode.data){
                currentNode.right = deleteRecursive(value, currentNode.right);
            } else {
                if(currentNode.left == null){
                    return currentNode.right;
                } else if(currentNode.right == null){
                    return currentNode.left;
                } else {
                    Node successor = getMinRecursiveNode(currentNode.right); //Check
                    currentNode.data = successor.data;
                    currentNode.right = deleteRecursive(successor.data, currentNode.right);
                }
            }

            return currentNode;
        }



}

//traverse
//delete