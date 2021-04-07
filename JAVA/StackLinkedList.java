class StackLinkedList {

  int container;
  Node top;
  Node base;
  int size;

  public class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }

  StackLinkedList() {
    top = null;
    container = 10;
    size = 0;
  }

  StackLinkedList(int container) {
    top = null;
    this.container = container;
    size = 0;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean isFull() {
    return size == container;
  }

  public void push(int data) {
    if (size == 0) {
      top = new Node(data);
      base = top;
      size++;
      return;
    } else if (isFull()) {
      System.out.print("Stack overflow");
      System.exit(1);
    }
    Node newNode = new Node(data);
    newNode.prev = top;
    top.next = newNode;
    top = newNode;
    size++;
  }

  public Node pop() {
    if (size == 0) {
      System.out.println("Stack is empty");
      System.exit(1);
    }
    if (size == 1) {
      Node temp = top;
      top = null;
      size--;
      return temp;
    }
    Node temp = top;
    top = top.prev;
    top.next = null;
    temp.prev = null;
    size--;
    return temp;
  }

  public void print() {
    Node current = base;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println("");
  }

  public static void main(String args[]) {
    StackLinkedList sLinkedList = new StackLinkedList();
    StackLinkedList sLinkedList2 = new StackLinkedList(5);
    sLinkedList2.push(11);
    sLinkedList2.push(22);
    sLinkedList2.push(23);
    sLinkedList2.print();
    sLinkedList2.pop();
    sLinkedList2.pop();
    sLinkedList2.pop();
    sLinkedList2.pop();
    sLinkedList2.pop();

  }
}