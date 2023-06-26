package org.example;

public class Tree {
    private Node root;

    private enum Color{
        BLACK,
        RED
    }

    class Node{
        int value;
        Node left;
        Node right;
        Color color;
    }

    public Node find(int value){
        return find(root, value);
    }

    private Node find(Node node, int value){
        if(node == null){
            return null;
        }
        if(node.value == value){
            return node;
        }
        if(node.value < value){
            return find(node.right, value);
        }else{
            return find(node.left, value);
        }
    }

    public boolean add(int value){
        if(root == null){
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
            return true;
        }

        boolean isAddedNote = addNote(root, value);
        root = balance(root);
        root.color = Color.BLACK;

        return isAddedNote;
    }

    private boolean addNote(Node node, int value){
        if(node.value == value){
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null) {
                    boolean result = addNote(node.left, value);
                    node.left = balance(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if(node.right != null){
                    boolean result = addNote(node.right, value);
                    node.right = balance(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }

    private Node balance(Node node){
        boolean needBalance;
        Node balanceNode = node;

        do{
           needBalance = false;

           if(balanceNode.right != null
                   && balanceNode.right.color == Color.RED
                   && (balanceNode.left == null || balanceNode.left.color == Color.BLACK)){
               balanceNode = rightTurn(balanceNode);
               needBalance = true;
           }

            if(balanceNode.left != null
                    && balanceNode.left.color == Color.RED
                    && balanceNode.left.left != null
                    && balanceNode.left.left.color == Color.RED){
                balanceNode = leftTurn(balanceNode);
                needBalance = true;
            }

            if(balanceNode.left != null
                    && balanceNode.left.color == Color.RED
                    && balanceNode.right != null
                    && balanceNode.right.color == Color.RED){
                colorSwap(balanceNode);
                needBalance = true;
            }
        } while (needBalance);

        return balanceNode;
    }

    private void colorSwap(Node node){
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node leftTurn(Node node){
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;

        return left;
    }

    private Node rightTurn(Node node){
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;

        return right;
    }
}
