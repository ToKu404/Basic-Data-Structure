public class SingleLinkedList {
  Node head;

  class Node {
    int value; // Isinya
    Node next; // Pointer

    Node(int v) {
      value = v;
      next = null;
    }
  }

  public void insertBegining(int data) {
    if (head != null) {
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
    } else {
      head = new Node(data);
    }
  }

  public void insertTail(int data) {
    Node tail = new Node(data);
    if (head != null) {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = tail;
    } else {
      head = tail;
    }
  }

  // Insert Middle
  public void insertMiddle(int data, int position) {
    // Jikas Posisi = 0 -> Insert di Head
    if (position == 0) {
      insertBegining(data);
    }
    // Jika Posisi != 0 ->
    Node temp = head;
    for (int i = 0; i < position - 1; i++) {
      temp = temp.next;
      if (temp == null) {
        System.out.println("Indeks tidak ditemukan");
        return;
      }
    }
    Node newNode = new Node(data);
    newNode.next = temp.next;
    temp.next = newNode;
  }

  public void printNode() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + "-->");
      temp = temp.next;
    }
    System.out.println("Null");
  }

  public void deleteHead() {
    if (head == null) {
      return;
    }
    head = head.next;
  }

  public void deleteTail() {
    if (head == null) {
      return;
    }
    if (head.next == null) {
      head = null;
      return;
    }
    Node temp = head;
    while (temp.next.next != null) {
      temp = temp.next;
    }
    temp.next = null;
  }

  // Delete Middle
  public void deleteMiddle(int position) {
    if (position == 0) {
      deleteHead();
      return;
    }
    Node previous = head;
    for (int i = 0; i < position - 1; i++) {
      previous = previous.next;
      if (previous == null) {
        System.out.println("Indeks tidak ditemukan");
        return;
      }
    }
    if (previous.next == null) {
      System.out.println("Indeks tidak ditemukan");
      return;
    }
    previous.next = previous.next.next;
  }

  public void find(int value) {
    Node temp = head;
    int i = 0;
    while (temp != null) {
      if (temp.value == value) {
        System.out.println("Value di temukan pada Indeks ke-" + i);
        return;
      }
      temp = temp.next;
      i++;
    }
    System.out.println("Value tidak ditemukan");
  }

  public void maksValue() {
    Node temp = head;
    int max = temp.value;
    while (temp.next != null) {
      temp = temp.next;
      max = max < temp.value ? temp.value : max;
    }
    System.out.println("Value Maximum adalah " + max);
  }

  public static void main(String[] args) {
    SingleLinkedList slinkedlist = new SingleLinkedList();
    slinkedlist.insertBegining(5);
    slinkedlist.insertBegining(4);
    slinkedlist.insertBegining(3);
    slinkedlist.insertTail(12);
    slinkedlist.insertTail(22);
    slinkedlist.deleteHead();
    slinkedlist.insertMiddle(20, 2);
    slinkedlist.printNode();
    slinkedlist.deleteMiddle(4);
    slinkedlist.printNode();
    slinkedlist.find(4);
    slinkedlist.maksValue();
  }
}
