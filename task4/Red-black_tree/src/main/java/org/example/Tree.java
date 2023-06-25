package org.example;

public class Tree {
    Node root;

    enum Color{
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

    public void insert(int value){
        if(root == null){
            root = new Node();
            root.value = value;
        }else {
            insert(root, value);
            root = balance(root);
        }

        root.color = Color.BLACK;
    }

    public void insert(Node node, int value){
        if(node.value != value){
            if(node.value < value){
                if(node.right == null){
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                }else{
                    insert(node.right, value);
                }
            }else{
                if(node.left == null){
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                }else{
                    insert(node.left, value);
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
               needBalance = true;
               balanceNode = rightTurn(balanceNode);
           }

            if(balanceNode.left != null
                    && balanceNode.left.color == Color.RED
                    && balanceNode.left.left != null
                    && balanceNode.left.left.color == Color.RED){
                needBalance = true;
                balanceNode = leftTurn(balanceNode);
            }

            if(balanceNode.left != null
                    && balanceNode.left.color == Color.RED
                    && balanceNode.right != null
                    && balanceNode.right.color == Color.RED){
                needBalance = true;
                colorSwap(balanceNode);
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
