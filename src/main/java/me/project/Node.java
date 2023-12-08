package me.project;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public T getData() {
        return this.data;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public Node<T> getRight() {
        return this.right;
    }
}
