public class BinarySearchTree {
  Node root;

  // membuat binary tree dengan inisial root
  public BinarySearchTree(int data) {
    root = new Node(data, null, null);
  }

  public BinarySearchTree() {
  }

  private class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public boolean search(int data) {
    return search(data, root);
  }

  public boolean search(int data, Node curNode) {
    // curNode akan null jika data tidak ditemukan
    if (curNode == null) {
      return false;
    }

    // aturan standar binary tree
    if (data < curNode.data) {
      return search(data, curNode.left);
    } else if (data > curNode.data) {
      return search(data, curNode.right);
    } else {
      return true;
    }

  }

  public boolean insert(int data) {
    // mencegah nilai duplikat
    if (search(data)) {
      return false;
    }
    root = insert(data, root);
    return true;
  }

  public Node insert(int data, Node curNode) {
    if (curNode == null) {
      curNode = new Node(data, null, null);
    }

    if (data < curNode.data) {
      curNode.left = insert(data, curNode.left);
    } else if (data > curNode.data) {
      curNode.right = insert(data, curNode.right);
    }

    return curNode;
  }

  public void printPreorder(Node newNode) {

    System.out.print("\nPreorder (Root,Left,Right)\t:");
    preorder(newNode);
  }

  public void preorder(Node curNode) {
    if (curNode == null)
      return;
    System.out.print(curNode.data + " ");
    preorder(curNode.left);
    preorder(curNode.right);
  }

  // Inorder (Left, Root, Right)
  public void printInorder(Node newNode) {
    if (newNode == null)
      return;
    System.out.print("\nInorder (Left,Root,Right)\t:");
    inorder(newNode);
  }

  public void inorder(Node curNode) {
    if (curNode == null)
      return;
    inorder(curNode.left);
    System.out.print(curNode.data + " ");
    inorder(curNode.right);
  }

  public void printPostorder(Node newNode) {
    if (newNode == null)
      return;
    System.out.print("\nPostorder (Left,Right,Root)\t:");
    postorder(newNode);
  }

  public void postorder(Node curNode) {
    if (curNode == null)
      return;
    postorder(curNode.left);
    postorder(curNode.right);
    System.out.print(curNode.data + " ");
  }

  public boolean delete(int data) {
    // nilai yang dicari tidak ada
    if (!search(data))
      return false;
    root = delete(data, root);
    return true;
  }

  public Node delete(int data, Node curNode) {

    if (data < curNode.data) {
      curNode.left = delete(data, curNode.left);
    } else if (data > curNode.data) {
      curNode.right = delete(data, curNode.right);
    } else {
      // menghapus daun pada pohon
      if (curNode.left == null && curNode.right == null) {
        return null;
      }
      // menghapus node yang tidak memiliki subtree kiri
      else if (curNode.left == null) {
        Node temp = curNode.right;
        curNode = null;
        return temp;
      }
      // menghapus node yang tidak memiliki subtree kanan
      else if (curNode.right == null) {
        Node temp = curNode.left;
        curNode = null;
        return temp;

      }
      // menghapus node yang memiliki subtree kiri dan kanan
      else {
        // mencari nilai terkecil di subtree kanan relatif thd curNode
        Node temp = minRightSubTree(curNode.right);
        curNode.data = temp.data;
        curNode.right = delete(temp.data, curNode.right);
      }
    }

    return curNode;
  }

  public Node minRightSubTree(Node node) {
    while (node.left != null) {
      node = node.left;
    }

    return node;
  }

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree(0);
    tree.insert(3);
    tree.insert(1);
    tree.insert(5);
    tree.insert(7);
    tree.insert(2);
    tree.insert(4);
    tree.printPreorder(tree.root);
    tree.printPostorder(tree.root);
    tree.printInorder(tree.root);

    tree.search(5);
    // System.out.println(tree.search(941));
    // System.out.println();
    // tree.delete(20);
    // tree.inorder(tree.root);
    // System.out.println();
    // tree.postorder(tree.root);
    // System.out.println();
    // tree.preorder(tree.root);
  }

}