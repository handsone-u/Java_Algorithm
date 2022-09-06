package dataStructure;

import java.io.*;

public class BinarySearchTree {
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        BST tree = new BST();
        String tmp;
        while (null != (tmp = reader.readLine())) {
            if(tmp.equals("")) break;
            int val = Integer.parseInt(tmp);
            Node nNode = new Node(val);
            tree.insert(nNode);
        }
        tree.postOrderInit();

        writer.flush();
        writer.close();
    }

    static class BST{
        private Node head;

        public BST() {
            head = null;
        }

        public void insert(Node nNode) {
            if (head==null){
                head = nNode;
                return;
            }
            head.insertNode(nNode);
        }

        public void postOrderInit() throws IOException {
            postOrder(head);
        }

        private void postOrder(Node now) throws IOException {
            if(now.left !=null)
                postOrder(now.left);
            if(now.right!=null)
                postOrder(now.right);
            writer.write(String.valueOf(now.value));
            writer.write("\n");
        }
    }

    static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }

        public void insertNode(Node nNode) {
            if (value > nNode.value) {
                if (left == null) left = nNode;
                else left.insertNode(nNode);
            } else {
                if(right==null) right = nNode;
                else right.insertNode(nNode);
            }
        }
    }
}
