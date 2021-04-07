import java.util.EmptyStackException;

class Stack {
  // Stack using array
  int length;
  int[] data;
  int top = -1;

  // Construct
  public Stack() {
    // Panjang Array
    length = 5;
    // Insialisasi Array
    data = new int[length];
  }

  // Construct With Parameter
  public Stack(int length) {
    this.length = length;
    data = new int[length];
  }

  // Jika stack kosong
  public boolean isEmpty() {
    return top == -1;
  }

  // Jika Stack Penuh
  public boolean isFull() {
    return top == length - 1;
  }

  // 12--11--15---17
  // Menambahkan data ke TOP
  public void push(int value) {
    if (isFull()) {
      throw new StackOverflowError("Stack overflow");
    }
    top = top + 1;
    // Memasukkan Value ke top
    this.data[top] = value;
  }

  // 12--11--15---17
  // Menghapus dan Mengambil data ke Top
  public int pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    int top_pop = data[top];
    top -= 1;
    return top_pop;
  }

  // Mengambil data ke top
  public int peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return data[top];
  }

  // Menampilkan
  public void print() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
      return;
    }
    System.out.println("-------------");
    System.out.println(data[top] + " <--TOP");
    for (int i = top - 1; i >= 0; i--) {
      System.out.println(data[i]);
    }
    System.out.println("-------------");
  }

  public static void main(String[] args) {
    Stack stack = new Stack();

    try {
      stack.push(12);
      stack.push(11);
      stack.push(15);
      stack.push(17);
      stack.print();
      System.out.println("POP -> " + stack.pop());
      stack.push(27);
      stack.print();
    } catch (EmptyStackException ese) {
      System.out.println(ese.getMessage());
    } catch (StackOverflowError soe) {
      System.out.println(soe.getMessage());
    }
  }
}