package model;

public class ArvoreBB {

	public Node root;

	public ArvoreBB() {
		this.root = null;
	}

	private Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			root.sumOfKeysSubtree = root.key;
			root.height = 1;
			return root;
		}
		if (data < root.key) {
			root.left = insert(root.left, data);
			if (root.left != null) {
				root.sizeLeft = root.left.sizeLeft + root.left.sizeRight + 1;
			}
		} else if (data > root.key) {
			root.right = insert(root.right, data);
			if (root.right != null)
				root.sizeRight = root.right.sizeLeft + root.right.sizeRight + 1;
		}
		root.sumOfKeysSubtree = root.key;
		if (root.left != null) {
			root.sumOfKeysSubtree += root.left.sumOfKeysSubtree;
		}
		if (root.right != null) {
			root.sumOfKeysSubtree += root.right.sumOfKeysSubtree;
		}

		int rightHeight = 0;
		int leftHeight = 0;
		if (root.right != null) {
			rightHeight = root.right.height;
		}
		if (root.left != null) {
			leftHeight = root.left.height;
		}
		root.height = Math.max(leftHeight, rightHeight) + 1;

		return root;

	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.key + " ");
		preOrder(node.left);
		preOrder(node.right);

	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);

	}

	public void inOrder() {
		inOrder(root);
	}

	public void preOrder() {
		preOrder(root);
	}

	private int getElementInOrder(Node node, int n) {
		if (node == null) {
			return -1;
		}

		if (n <= node.sizeLeft) {
			return getElementInOrder(node.left, n);
		} else if (n == node.sizeLeft + 1) {
			return node.key;
		} else {
			return getElementInOrder(node.right, n - node.sizeLeft - 1);
		}
	}

	public int getElementInOrder(int n) {
		if (root == null || n <= 0 || n > root.sizeLeft + root.sizeRight + 2) {
			return -1;
		}
		return getElementInOrder(root, n);
	}

	private int getPositionInOrder(Node node, int data) {
		if (node == null) {
			return -1;
		}
		if (data == node.key) {
			return node.sizeLeft + 1;

		} else if (data < node.key) {
			return getPositionInOrder(node.left, data);
		} else {
			int pos = getPositionInOrder(node.right, data);

			if (pos == -1) {
				return -1;
			}

			return node.sizeLeft + 1 + pos;
		}
	}

	public int getPositionInOrder(int data) {
		return getPositionInOrder(root, data);
	}

	public int getMedian() {
		int totalNodes = root.sizeLeft + root.sizeRight + 1;
		if (totalNodes % 2 == 1) {
			return getElementInOrder(root, (totalNodes + 1) / 2);
		} else {
			int m1 = getElementInOrder(root, totalNodes / 2);
			int m2 = getElementInOrder(root, (totalNodes + 1) / 2);
			return Math.min(m1, m2);
		}
	}

	private Node searchNodeByKey(Node node, int x) {
		if (node == null || node.key == x) {
			return node;
		} else if (x < node.key) {
			return searchNodeByKey(node.left, x);

		} else {
			return searchNodeByKey(node.right, x);
		}

	}

	public boolean searchNodeByKey(int x) {
		Node n = searchNodeByKey(root, x);
		if (n == null) {
			return false;
		}
		return true;
	}

	public double getMean(int x) {
		Node node = searchNodeByKey(root, x);
		if (node != null) {
			double sum = node.sumOfKeysSubtree;
			double count = node.sizeLeft + node.sizeRight + 1;
			return sum / count;
		}
		return -1.0;
	}

	private boolean isComplete(Node root) {
		if (root == null) {
			return true;
		}
		int total = root.sizeLeft + root.sizeRight + 1;
		if (Math.pow(2, root.height - 1) <= total && total <= Math.pow(2, root.height) - 1) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isFull(Node root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if (root.left != null && root.right != null) {
			return (isFull(root.left) && isFull(root.right));
		}

		return false;
	}

	public boolean isFull() {
		return isFull(root);
	}

	public boolean isComplete() {
		return isComplete(root);
	}

	private void printArvoreParentese(Node root) {
		if (root != null) {
			System.out.print(" (" + root.key);
			if (root.left != null) {
				printArvoreParentese(root.left);
			}
			if (root.right != null) {
				printArvoreParentese(root.right);
			}
			System.out.print(")");
		}
	}

	public void printArvoreParentese() {
		printArvoreParentese(root);
	}

	private void printArvoreLevels(Node root, int level) {
		if (root != null) {
			for (int i = 0; i < level; i++) {
				System.out.print("   ");
			}
			System.out.print(root.key);
			for (int i = 10; i > level; i--) {
				System.out.print("---");
			}
			System.out.println();

			if (root.left != null) {
				printArvoreLevels(root.left, level + 1);
			}
			if (root.right != null) {
				printArvoreLevels(root.right, level + 1);
			}
		}
	}

	public void printArvoreLevels() {
		printArvoreLevels(root, 0);
	}

	public void printArvore() {
		printArvoreParentese();
		System.out.println();
		printArvoreLevels();
	}

	private Node remove(Node root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.key) {
			root.left = remove(root.left, key);
		} else if (key > root.key) {
			root.right = remove(root.right, key);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				Node minNode = findMin(root.right);
				root.key = minNode.key;

				root.right = remove(root.right, minNode.key);
			}

		}

		root.sizeLeft = (root.left != null) ? root.left.sizeLeft + root.left.sizeRight + 1 : 0;
		root.sizeRight = (root.right != null) ? root.right.sizeLeft + root.right.sizeRight + 1 : 0;
		root.sumOfKeysSubtree = root.key;
		if (root.left != null) {
			root.sumOfKeysSubtree += root.left.sumOfKeysSubtree;
		}
		if (root.right != null) {
			root.sumOfKeysSubtree += root.right.sumOfKeysSubtree;
		}

		int rightHeight = (root.right != null) ? root.right.height : 0;
		int leftHeight = (root.left != null) ? root.left.height : 0;
		root.height = Math.max(leftHeight, rightHeight) + 1;

		return root;

	}

	private Node findMin(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public void remove(int key) {
		root = remove(root, key);
	}
}
