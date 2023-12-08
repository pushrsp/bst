package me.project;

import java.util.Objects;

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(T data) {
        if(isEmpty()) {
            root = new Node<>(data);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        if(data.compareTo(node.getData()) < 0) {
            if(Objects.isNull(node.getLeft())) {
                node.setLeft(new Node<>(data));
            } else {
                insert(data, node.getLeft());
            }
        } else if(data.compareTo(node.getData()) > 0) {
            if(Objects.isNull(node.getRight())) {
                node.setRight(new Node<>(data));
            } else {
                insert(data, node.getRight());
            }
        }
    }

    public void delete(T data) {
        root = delete(data, root);
    }

    private Node<T> delete(T data, Node<T> node) {
        if(Objects.isNull(node)) {
            return null;
        }

        if(data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));
        } else if(data.compareTo(node.getData()) > 0) {
            node.setRight(delete(data, node.getRight()));
        } else {
            if(Objects.isNull(node.getLeft())) {
                return node.getRight();
            } else if(Objects.isNull(node.getRight())) {
                return node.getRight();
            }

            node.setData(maxRec(node.getLeft()));
            node.setLeft(delete(node.getData(), node.getLeft()));
        }

        return node;
    }

    /**
     * 전위 순회
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<T> node) {
        if(node != null) {
            System.out.println(node.getData());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * 중위 순회
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> node) {
        if(node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getData());
            inOrder(node.getRight());
        }
    }

    /**
     * 후위 순회
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<T> node) {
        if(node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getData());
        }
    }

    public boolean isEmpty() {
        return Objects.isNull(root);
    }

    public T min() {
        if(isEmpty()) {
            return null;
        }

        Node<T> curr = root;
        while (curr.getLeft() != null) {
            curr = curr.getLeft();
        }

        return curr.getData();
    }

    public T max() {
        if(isEmpty()) {
            return null;
        }

        Node<T> curr = root;
        while (curr.getRight() != null) {
            curr = curr.getRight();
        }

        return curr.getData();
    }

    public T minRec() {
        if(isEmpty()) {
            return null;
        }

        return minRec(root);
    }

    public T maxRec() {
        if(isEmpty()) {
            return null;
        }

        return maxRec(root);
    }

    private T minRec(Node<T> node) {
        if(node.getLeft() != null) {
            return minRec(node.getLeft());
        }

        return node.getData();
    }

    private T maxRec(Node<T> node) {
        if(node.getRight() != null) {
            return maxRec(node.getRight());
        }

        return node.getData();
    }
}
