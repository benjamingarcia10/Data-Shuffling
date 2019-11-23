package cs146F19.Garcia.project1;

public class LinkedNode {
	
	private int id;
	public LinkedNode prev;
	public LinkedNode next;
	
	public LinkedNode(int x) {
		id = x;
	}
	
	/*
	public void setPrev(LinkedNode p) {
		prev = p;
	}
	
	public void setNext(LinkedNode n) {
		next = n;
	}
	
	public LinkedNode getPrev() {
		return prev;
	}
	
	public LinkedNode getNext() {
		return next;
	}
	*/
	
	public int getId() {
		return id;
	}
}
