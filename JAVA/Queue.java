class Queue {
  int size;
  int[] container;

  Queue() {
    this.size = 0;
    this.container = new int[10];
  }

  Queue(int capacity) {
    this.size = 0;
    this.container = new int[capacity];
  }

  // Menambahkan Data
  void enqueue(int data) {
    if (size == container.length) {
      System.out.println("Queue is overflow");
      System.exit(1);
    }
    container[size] = data;
    size++;
  }

  // Menghapus dan Mengambil data
  int dequeue() {
    int[] newContainer = new int[container.length];
    int item = container[0];

    for (int i = 1; i < size; i++) {
      newContainer[i - 1] = container[i];
    }
    container = newContainer;
    size--;
    return item;
  }

  // Mengambil data
  public int peek() {
    return container[0];
  }

  void print() {
    if (size == 0) {
      System.out.println("Queue is empty");
    }
    for (int i = 0; i < size - 1; i++) {
      System.out.print(container[i]);
      System.out.print("-->");
    }

    System.out.println(container[size - 1]);
  }

  int getMaximum() {
    if (size == 0) {
      return -1;
    }
    int max = container[0];
    for (int i = 1; i < size; i++) {
      if (container[i] > max) {
        max = container[i];
      }
    }
    return max;
  }

  int getMinimum() {
    if (size == 0) {
      return -1;
    }
    int min = container[0];
    for (int i = 1; i < size; i++) {
      if (container[i] < min) {
        min = container[i];
      }
    }
    return min;
  }

  public static void main(String args[]) {
    Queue queue = new Queue();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.print();
    System.out.println("Dequeue -> " + queue.dequeue());
    System.out.println("Dequeue -> " + queue.dequeue());
    queue.print();
    System.out.println("Max Val = " + queue.getMaximum());
    System.out.println("Min Val = " + queue.getMinimum());
  }
}