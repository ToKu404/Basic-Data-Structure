#include <iostream>
#include <stdlib.h>
using namespace std;

struct Node
{
  int value;
  struct Node *next;
  struct Node *prev;
};

void addHead(struct Node **head, int data)
{
  // Membuat node baru
  struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
  newNode->value = data;
  // New Node next adalah head
  newNode->next = (*head);
  // New Node prev adalah null
  newNode->prev = NULL;
  if (*head != NULL)
  {
    // rev prev adalah newNode
    (*head)->prev = newNode;
  }
  *head = newNode;
}

void addTail(struct Node **tail, int data)
{
  // Membuat node baru
  struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
  newNode->value = data;
  newNode->next = NULL;
  // Node bantu untuk menyimpan node last
  struct Node *last = *tail;

  // Jika List Masih Kosong
  if (*tail == NULL)
  {
    newNode->prev = NULL;
    *tail = newNode;
    return;
  }
  // Traverse sampai menemukan last node
  while (last->next != NULL)
  {
    last = last->next;
  }
  // Last Nodesekarang adalah new Node
  last->next = newNode;
  newNode->prev = last;
  return;
}

void addAt(struct Node **head, int data, int position)
{
  //Jika indeks nya 0 tambahkan ke head
  if (position == 0)
  {
    addHead(head, data);
    return;
  }
  // Membuat node baru
  struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
  newNode->value = data;
  newNode->next = NULL;
  newNode->prev = NULL;

  // node current
  struct Node *current = *head;
  // Perulangan sampai indeks
  for (size_t i = 0; i < position - 1; i++)
  {
    // jika current tidak sama dengan null
    if (current != NULL)
    {
      current = current->next;
    }
  }

  // Jika current null
  if (current == NULL)
  {
    cout << "Melibih List";
    return;
  }
  else
  {
    // jadikan next dari current sebagai next node dari current
    newNode->next = current->next;
    // prev dari newNode adalah current
    newNode->prev = current;
    // next dari current new node
    current->next = newNode;
    // prev dari nextNode dari newNode menjadi newNode jika tidakmkosong
    if (newNode->next != NULL)
      newNode->next->prev = newNode;
  }
}

void deleteHead(struct Node **head)
{
  // Jika Head Kosong
  if (head == NULL)
  {
    return;
  }
  // Next dijadikan node setelahnya
  *head = (*head)->next;
  // head sebelumnya jadi null
  (*head)->prev = NULL;
}

void deleteAt(struct Node **head, int position)
{
  if (position == 0)
  {
    deleteHead(head);
  }
  struct Node *current = *head;
  for (size_t i = 0; i < position; i++)
  {
    current = current->next;
    if (current == NULL)
    {
      cout << "Melebihi List";
      return;
    }
  }
  if (current->next == NULL)
  {
    current->prev->next = NULL;
    return;
  }
  current->prev->next = current->next;
  current->next->prev = current->prev;
}

void deleteLast(struct Node **head)
{
  if (head == NULL)
  {
    return;
  }
  if ((*head)->next == NULL)
  {
    head = NULL;
    return;
  }
  struct Node *tail = (*head);

  while (tail->next->next != NULL)
  {
    tail = tail->next;
  }
  tail->next = NULL;
}

void maximumVal(struct Node *head)
{
  struct Node *temp = head;
  int maks = temp->value;
  while (temp->next != NULL)
  {
    if (maks < temp->next->value)
    {
      maks = temp->next->value;
    }
    temp = temp->next;
  }
  cout << "NILAI MAKSIMUM : " << maks;
}
void minimumVal(struct Node *head)
{
  struct Node *temp = head;
  int min = temp->value;
  while (temp->next != NULL)
  {
    if (min > temp->next->value)
    {
      min = temp->next->value;
    }
    temp = temp->next;
  }
  cout << "NILAI MINIMUM : " << min;
}
void find(struct Node *head, int value)
{
  struct Node *temp = head;
  int i = 0;
  while (temp != NULL)
  {
    if (temp->value == value)
    {
      cout << value << " Terdapat pada indeks ke " << i;
      return;
    }
    i++;
    temp = temp->next;
  }
  cout << "Value tidak ditemukan ";
  return;
}

void print(struct Node *node)
{
  while (node != NULL)
  {
    cout << node->value << "-->";
    node = node->next;
  }
  cout << "NULL";
}
void printBack(struct Node *node)
{
  struct Node *tail = node;
  while (tail->next != NULL)
  {
    tail = tail->next;
  }
  cout << "NULL";
  while (tail != node->prev)
  {
    cout << "-->" << tail->value;
    tail = tail->prev;
  }
}

int main()
{
  struct Node *head = NULL;
  cout << "\nADD SECTION\n";
  addHead(&head, 1);
  addHead(&head, 2);
  addHead(&head, 5);
  cout << "\nADD HEAD 5,2,1\n";
  print(head);
  addTail(&head, 7);
  addTail(&head, 12);
  cout << "\nADD LAST 7,12\n";
  print(head);

  addAt(&head, 14, 2);
  addAt(&head, 18, 5);
  cout << "\nADD AT 14 di Indeks 2, dan 18 indeks ke 5\n";
  print(head);

  cout << "\n\nDELETE SECTION\n";
  deleteHead(&head);
  cout << "\nDELETE HEAD\n";
  print(head);
  deleteAt(&head, 1);
  cout << "\nDELETE AT INDEKS 1\n";
  print(head);
  deleteLast(&head);
  cout << "\nDELETE LAST\n";
  print(head);

  cout << "\n\nEXTRA SECTION";
  cout << "\nMAX \n";
  maximumVal(head);
  cout << "\nMIN \n";
  minimumVal(head);
  cout << "\nFIND 7\n";
  find(head, 7);
  cout << "\nPrint From Tail\n";
  printBack(head);
}