public class DoubleLinkedList {
  Node head;

  class Node {
    int value;
    Node next;
    Node prev;

    Node(int v) {
      value = v;
    }
  }

  public void addHead(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    newNode.prev = null;
    if (head != null) {
      head.prev = newNode;
    }
    head = newNode;
  }

  public void addTail(int node) {
    if (head != null) {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      Node newNode = new Node(node);
      temp.next = newNode;
      newNode.prev = temp;
    } else {
      addHead(node);
    }
  }

  public void addAt(int data, int i) {
    if (i == 0)
      addHead(data);
    Node curNode = head;
    for (int x = 0; x < i; x++) {
      curNode = curNode.next;
      if (curNode == null) {
        System.out.println("melebihi list");
        return;
      }
    }
    Node newNode = new Node(data);
    newNode.next = curNode;
    curNode.prev = newNode;
  }

  public void deleteHead() {
    if (head == null) {
      return;
    }
    head = head.next;
    head.prev = null;
  }

  public void deleteAt(int i) {
    if (i == 0)
      deleteHead();

    Node curNode = head;
    for (int x = 0; x < i; x++) {
      curNode = curNode.next;

      if (curNode == null) {
        System.out.println("melebihi list");
        return;
      }

    }

    if (curNode.next == null) {
      curNode.prev.next = null;
      return;
    }

    curNode.prev.next = curNode.next;
    curNode.next.prev = curNode.prev;
  }

  public void DeleteLast() {
    if (head == null) {
      return;
    }
    if (head.next == null) {
      head = null;
      return;
    }

    Node current = head;

    while (current.next.next != null) {
      current = current.next;
    }

    current.next = null;
  }

  public int max() {
    Node temp = head;
    int maks = head.value;
    while (temp.next != null) {
      if (maks < temp.next.value) {
        maks = temp.next.value;
      }
      temp = temp.next;
    }
    return maks;
  }

  public int find(int v) {
    Node temp = head;
    int i = 0;
    while (temp != null) {
      if (temp.value == v)
        return i;
      i++;
      temp = temp.next;
    }
    return -1;
  }

  public void print() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + "-->");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public void printBack() {
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    // tail == temp
    System.out.print("null");
    while (temp != head.prev) {
      System.out.print("-->");
      System.out.print(temp.value);
      temp = temp.prev;
    }
  }

  public static void main(String[] args) {
    DoubleLinkedList dlinkedlist = new DoubleLinkedList();
    dlinkedlist.addHead(10);
    dlinkedlist.addHead(20);
    dlinkedlist.addAt(40, 0);
    dlinkedlist.addTail(35);
    dlinkedlist.deleteAt(1);
    dlinkedlist.find(20);
    dlinkedlist.max();
    dlinkedlist.print();
    dlinkedlist.printBack();
  }
}
