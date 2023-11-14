package model;

public class Node {
	protected int key;
	protected Node left;
	protected Node right;
	protected int sizeLeft;
	protected int sizeRight;
	protected int sumOfKeysSubtree;
	protected int height;

	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getSizeLeft() {
		return sizeLeft;
	}

	public void setSizeLeft(int sizeLeft) {
		this.sizeLeft = sizeLeft;
	}

	public int getSizeRight() {
		return sizeRight;
	}

	public void setSizeRight(int sizeRight) {
		this.sizeRight = sizeRight;
	}

	public int getSumOfKeysSubtree() {
		return sumOfKeysSubtree;
	}

	public void setSumOfKeysSubtree(int sumOfKeysSubtree) {
		this.sumOfKeysSubtree = sumOfKeysSubtree;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Node{" + "key=" + key + ", sizeLeft=" + sizeLeft + ", sizeRight=" + sizeRight + ", sumOfKeysSubtree="
				+ sumOfKeysSubtree + ", height=" + height + '}';
	}
}
