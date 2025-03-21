import java.util.ArrayList;
import java.util.List;

public class AVL {
    //creating the node class
    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        //constructor
        public Node(int value){
            this.value = value;
        }

        //getter
        public int getValue(){
            return value;
        }
    }

    private Node root;


    public AVL(){

    }
    public Node getRoot() {
        return root;
    }

    //height method
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    //insertion method
    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.getValue()){
            node.left = insert(value, node.left);
        }
        else if(value > node.getValue()){
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    //rotations
    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // left right case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public List<Integer> preOrder() {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }


    private void preOrder(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            preOrder(node.left, result);
            preOrder(node.right, result);
        }
    }

    public List<Integer> inOrder() {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(Node node, List<Integer> result) {
        if (node != null) {
            inOrder(node.left, result);
            result.add(node.value);
            inOrder(node.right, result);
        }
    }

    public List<Integer> posOrder() {
        List<Integer> list = new ArrayList<>();
        posOrder(root, list);
        return list;
    }

    private void posOrder(Node node, List<Integer> result) {
        if (node != null) {
            posOrder(node.left, result);
            posOrder(node.right, result);
            result.add(node.value);
        }
    }

    public int search (int value){
        return search(root, value);
    }



    public int search (Node node, int value) {
        if (node != null) {
            if (node.value == value) {
                return node.getValue();
            }
            else if (value < node.value) {
                return search(node.left, value);

            }else return search(node.right, value);

        }
        return 0;
    }
    private Node searchIn (Node node, int value) {
        if (node != null) {
            if (node.value == value) {
                return node;
            }
            else if (value < node.value) {
                return searchIn(node.left, value);

            }else return searchIn(node.right, value);

        }
        return null;
    }

    private void remove(Node node, int value) {
        Node target = searchIn(root, value);
        Node aux = target.left;
        while (aux.right != null){
            aux.right = node;
        }
        target = aux;


    }

}
