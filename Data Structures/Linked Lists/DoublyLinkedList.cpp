#include <iostream>
using namespace std;

struct Node {
    int data;
    Node *next;
    Node *prev;
};

Node* InsertTail(Node *head, int data) {
    Node *node = new Node();
    node->data = data;
    if (head == 0)
        head = node;
    else {
        Node *current = head;
        while (current->next != 0)
            current = current->next;
        current->next = node;
        node->prev = current;
    }
    return head;
}

Node* SortedInsert(Node *head, int data) {
    Node* node = new Node();
    node->data = data;
    if (head == 0)
        head = node;
    else {
        if (head->data > data) {
            node->next = head;
            head->prev = node;
            head = node;
        } else {
            Node *current = head;
            while (current->next != 0 && current->next->data <= data)
                current = current->next;
            node->next = current->next;
            node->prev = current;
            if (current->next != 0)
                current->next->prev = node;
            current->next = node;
        }
    }
    return head;
}

Node* Reverse(Node* head)
{
    if (head != 0 && head->next != 0) {
        Node *prev = head;
        Node *next = head->next;
        while (true) {
            prev->next = prev->prev;
            prev->prev = next;
            if (next == 0) {
                head = prev;
                break;
            }
            else {
                prev = next;
                next = next->next;
            }
        }
    }
    return head;
}

void Print(Node *head) {
    if (head != 0) {
        for (Node *current = head; current != 0; current = current->next)
            cout << current->data << " ";
        cout << endl;
    }
}

int main() {
    int cases;
    cin >> cases;
    for (int i = 0; i < cases; i++) {
        int size;
        cin >> size;
        Node *head = 0;
        for (int j = 0; j < size; j++) {
            int data;
            cin >> data;
            head = SortedInsert(head, data);
        }
        head = Reverse(head);
    }
}
