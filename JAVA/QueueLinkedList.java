public class QueueLinkedList {
  Node front;
  Node rear;
  int size;
  int container;

  // Class Node
  class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
      this.data = data;
    }
  }

  QueueLinkedList() {
    this.container = 10;
    this.size = 0;
  }

  QueueLinkedList(int container) {
    this.container = container;
    this.size = 0;
  }

  boolean isEmpty() {
    return size == 0;
  }

  boolean isFull() {
    return size == container;
  }

  void enqueue(int data) {
    if (isFull()) {
      System.out.println("Queue is overflow");
      System.exit(1);
    }
    Node newNode = new Node(data);

    if (front == null) {
      front = newNode;
      rear = newNode;
      size++;
      return;
    }

    if (front == rear) {
      newNode.prev = front;
      front.next = newNode;
      rear = newNode;
      size++;
      return;
    }

    newNode.prev = rear;
    rear.next = newNode;
    rear = newNode;
    size++;
  }

  Node dequeue() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      System.exit(1);
    }
    Node temp = front;

    if (temp.next == null) {
      front = null;
      rear = null;
      size--;
      return temp;
    }
    front = front.next;
    front.prev = null;
    size--;

    return temp;
  }

  Node peek() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      System.exit(1);
    }

    return front;
  }

  void print() {
    if (isEmpty()) {
      System.out.println("null");
      return;
    }

    Node current = front;

    while (true) {
      System.out.print(current.data + " ");
      if (current == rear) {
        return;
      }
      current = current.next;
    }
  }

  public static void main(String[] args) {
    QueueLinkedList qList = new QueueLinkedList();
    qList.enqueue(11);
    qList.enqueue(22);
    qList.enqueue(13);
    qList.enqueue(14);
    qList.enqueue(15);
    qList.enqueue(10);
    qList.enqueue(17);
    qList.enqueue(18);
    qList.enqueue(19);
    qList.enqueue(20);
    qList.dequeue();
    qList.dequeue();
    qList.dequeue();
    qList.dequeue();
    qList.dequeue();
    qList.dequeue();
    qList.dequeue();
    qList.dequeue();
    qList.print();
  }
}
