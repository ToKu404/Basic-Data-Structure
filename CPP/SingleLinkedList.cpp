#include <iostream>
#include <stdlib.h>
using namespace std;

struct Node
{
  int data;
  struct Node *next;
};

void insertAtHead(struct Node **ref, int data)
{
  // Mengalikasikan memori ke node atau insialisasi newNode
  struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));

  // Menambahkan data
  newNode->data = data;
  newNode->next = (*ref);

  // Memindahkan head ke new node
  (*ref) = newNode;
}

void insertAtIndex(struct Node **head, int index, int data)
{

  // Mengecek apakah prevNode Kosong
  if (index == 0)
  {
    insertAtHead(head, data);
    return;
  }
  struct Node *current = *head;
  for (size_t i = 0; i < index - 1; i++)
  {
    current = current->next;
    if (current == NULL)
    {
      cout << "index yang diberikan tidak valid";
      return;
    }
  }
  struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
  newNode->data = data;

  newNode->next = current->next;
  current->next = newNode;

  *head = current;
  return;
}

void insertAfter(struct Node *prevNode, int data)
{
  // Mengecek apakah prevNode Kosong
  if (prevNode == NULL)
  {
    cout << "prevNode yang diberikan tidak bisa NULL";
    return;
  }
  struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
  // data dimasukkan ke newNode
  newNode->data = data;
  // next dari newNode adalah next dari prev node
  newNode->next = prevNode->next;
  // next dari prevNode sekarang adalah newNode
  prevNode->next = newNode;
}

void insertAtTail(struct Node **ref, int data)
{
  struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
  struct Node *tail = *ref;

  // Memberikan data ke newNode, dan next untuk newNode adalah NULL_VAL
  // Karena newNOde akan menjadi Tail
  newNode->data = data;
  newNode->next = NULL;

  // Jika Listnya kosong
  if (*ref == NULL)
  {
    *ref = newNode;
    return;
  }

  // Melakukan perulangan sampai tails
  while (tail->next != NULL)
    tail = tail->next;

  // Next dari tail sekarang adalah newNoda
  tail->next = newNode;
  return;
}

void deleteHead(struct Node **ref)
{
  struct Node *temp = *ref;
  if (temp == NULL)
    return;
  *ref = temp->next;
  free(temp);
}

void deleteAt(struct Node **ref, int index)
{
  if (index == 0)
  {
    deleteHead(ref);
    return;
  }
  struct Node *prev = *ref;
  // Mencari Posisi Node
  for (size_t i = 0; i < index - 1; i++)
  {
    prev = prev->next;
    if (prev == NULL)
    {
      cout << "index yang diberikan tidak valid\n";
      return;
    }
  }
  if (prev->next == NULL)
  {
    cout << "index yang diberikan tidak valid\n";
    return;
  }
  prev->next = prev->next->next;
}
void deleteNode(struct Node **ref, int key)
{
  struct Node *temp = *ref, *prev;
  if (temp != NULL && temp->data == key)
  {
    deleteHead(ref);
    return;
  }

  // Mencari key untuk dihapus
  while (temp != NULL && temp->data != key)
  {
    // prev akan menyimpan temp sekarang
    prev = temp;
    // temp akan dijadikan node selanjutnya yg akan dicek
    temp = temp->next;
  }

  // Jika key tidak ada
  if (temp == NULL)
    return;

  // Menghapus node
  prev->next = temp->next;
  free(temp);
}
void deleteTail(struct Node **ref)
{
  struct Node *temp = *ref, *tail;
  if (temp == NULL)
    return;
  if (temp->next == NULL)
  {
    deleteHead(ref);
    return;
  }
  // Untuk menjadikan temp sebagai tail
  while (temp->next->next != NULL)
  {
    temp = temp->next;
  }
  tail = temp;
  tail->next = NULL;
  free(temp);
}

void printList(struct Node *node)
{
  // While sampai node kosong
  while (node != NULL)
  {
    // cetak node
    cout << node->data << " ";
    node = node->next;
  }
}

void find(struct Node *node, int value)
{
  struct Node *temp = node;
  int i = 0;
  while (temp != NULL)
  {
    if (temp->data == value)
    {

      cout << "Value ditemukan pada indeks ke = " << i << " ";
      return;
    }
    temp = temp->next;
    i = i + 1;
  }
  cout << "Value tidak ditemukan";
}

void maximumValue(struct Node *node)
{
  struct Node *temp = node;
  int max = 0;
  while (temp != NULL)
  {
    if (temp->data > max)
    {
      max = temp->data;
    }
    temp = temp->next;
  }
  cout << "Maximum data adalah = " << max;
}
void minimumValue(struct Node *node)
{
  struct Node *temp = node;
  if (temp == NULL)
  {
    cout << "List kosong";
    return;
  }
  int min = temp->data;

  while (temp->next != NULL)
  {
    if (temp->next->data < min)
    {
      min = temp->next->data;
    }
    temp = temp->next;
  }
  cout << "Minimum data adalah = " << min;
}

// Main
int main()
{
  struct Node *head = NULL;
  cout << "\n----Insert Section----";
  insertAtHead(&head, 1);
  insertAtHead(&head, 4);
  insertAtHead(&head, 6);
  cout << "\nAdd 6,4,1 ke head\n";
  printList(head);
  insertAtTail(&head, 10);
  insertAtTail(&head, 2);
  cout << "\nAdd 10,2 ke tail\n";
  printList(head);
  insertAfter(head->next, 7);
  cout << "\nAdd 7 di setelah next dari head\n";
  printList(head);
  insertAtIndex(&head, 1, 13);
  cout << "\nAdd 13 ke indeks ke 1\n";
  printList(head);

  cout << "\n\n----Delete Section----";
  deleteHead(&head);
  cout << "\nHapus Head\n";
  printList(head);
  cout << "\nHapus Tail\n";
  deleteTail(&head);
  printList(head);
  cout << "\nHapus Node yang isinya 1\n";
  deleteNode(&head, 1);
  printList(head);
  cout << "\nHapus Node ke 1\n";
  deleteAt(&head, 1);
  printList(head);

  cout << "\n\n----Extra Section----";
  cout << "\nCari value 7\n";
  find(head, 7);
  cout << "\nMax VAL\n";
  maximumValue(head);
  cout << "\nMIN VAL\n";
  minimumValue(head);
}
