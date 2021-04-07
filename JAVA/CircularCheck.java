public class CircularCheck {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  public static Node newNode(int data) {
    Node temp = new Node(data);
    temp.next = null;
    return temp;
  }

  // Fungsi Pengecekan
  public static boolean isCircular(Node head) {
    if (head == null) {
      return true;
    }
    Node node = head.next;
    while (node != null && node != head) {
      node = node.next;
    }
    return node == head;
  }

  public static void main(String args[]) {
    Node head = newNode(20);
    head.next = newNode(24);
    head.next.next = newNode(23);
    head.next.next.next = newNode(27);
    System.out.println(isCircular(head) ? "Yes" : "No");
    head.next.next.next.next = head;
    System.out.println(isCircular(head) ? "Yes" : "No");
  }

}
