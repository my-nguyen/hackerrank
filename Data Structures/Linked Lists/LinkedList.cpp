#include <iostream>
using namespace std;

struct Node {
    int data;
    Node *next;

    friend ostream& operator<<(ostream& out, Node& node) {
        return out << node.data;
    }
};

Node* reverse(Node *head)
{
    if (head->next->next == 0) {
        head->next->next = head;
        head = head->next;
    } else {
        Node* reversed = reverse(head->next);
        head->next->next = head;
        head = reversed;
    }
    return head;
}

Node* Reverse(Node *head) {
    if (head != 0 && head->next != 0) {
        Node *reversed = reverse(head);
        head->next = 0;
        head = reversed;
    }
    return head;
}

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
    }
    return head;
}

Node* InsertHead(Node *head, int data) {
    Node *node = new Node();
    node->data = data;
    if (head == 0)
        head = node;
    else {
        node->next = head;
        head = node;
    }
    return head;
}

Node* InsertNth(Node *head, int data, int position) {
    Node *node = new Node();
    node->data = data;
    if (position == 0) {
        node->next = head;
        head = node;
    } else {
        Node *current = head;
        for (int i = 1; i < position; i++) {
            current = current->next;
        }
        node->next = current->next;
        current->next = node;
    }
    return head;
}

Node* Delete(Node *head, int position) {
    if (position == 0) {
        Node *toDelete = head;
        head = head->next;
        delete toDelete;
    } else {
        Node *current = head;
        for (int i = 1; i < position; i++)
            current = current->next;
        Node *toDelete = current->next;
        current->next = current->next->next;
        delete toDelete;
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

void ReversePrint(Node *head) {
    if (head != 0) {
        if (head->next != 0)
            ReversePrint(head->next);
        cout << head->data << endl;
    }
}

int CompareLists(Node *headA, Node* headB)
{
    if (headA == 0 && headB == 0)
        return 1;
    if (headA == 0 || headB == 0)
        return 0;
    if (headA->data != headB->data)
        return 0;
    return CompareLists(headA->next, headB->next);
}

Node* MergeLists(Node *headA, Node* headB) {
    Node *head;
    if (headA == 0 && headB == 0)
        head = 0;
    else if (headA == 0)
        head = headB;
    else if (headB == 0)
        head = headA;
    else {
        Node *current;
        Node *currentA;
        Node *currentB;
        if (headA->data < headB->data) {
            head = current = headA;
            currentA = headA->next;
            currentB = headB;
        } else {
            head = current = headB;
            currentA = headA;
            currentB = headB->next;
        }
        while (currentA != 0 && currentB != 0) {
            if (currentA->data < currentB->data) {
                current->next = currentA;
                current = current->next;
                currentA = currentA->next;
            } else {
                current->next = currentB;
                current = current->next;
                currentB = currentB->next;
            }
        }
        if (currentA != 0) {
            current->next = currentA;
        } else if (currentB != 0) {
            current->next = currentB;
        }
    }
    return head;
}

struct Record {
    int position;
    int data;
};

Record getNode(Node *head, int position) {
    Record record;
    if (head->next == 0) {
        record.position = 0;
        if (position == 0)
            record.data = head->data;
    } else {
        record = getNode(head->next, position);
        record.position++;
        if (record.position == position)
            record.data = head->data;
    }
    return record;
}

int GetNode(Node *head, int positionFromTail) {
    Record record = getNode(head, positionFromTail);
    return record.data;
}

Node* RemoveDuplicates(Node *head) {
    if (head != 0) {
        for (Node *current = head; current != 0; current = current->next) {
            int data = current->data;
            while (current->next != 0 && current->next->data == data) {
                Node *duplicate = current->next;
                current->next = current->next->next;
                delete duplicate;
            }
        }
    }
    return head;
}

bool has_cycle(Node* head) {
    if (head == 0 || head->next == 0)
        return false;
    Node *slow = head;
    Node *fast = head->next;
    while (fast != slow) {
        if (fast->next == 0 || fast->next->next == 0)
            return false;
        fast = fast->next->next;
        slow = slow->next;
    }
    return true;
}

int FindMergeNode(Node *headA, Node *headB)
{
    for (Node *currentA = headA; currentA != 0; currentA = currentA->next) {
        for (Node *currentB = headB; currentB != 0; currentB = currentB->next) {
            if (currentA->data == currentB->data)
                return currentA->data;
        }
    }
    return 0;
}

int main() {
    int cases;
    cin >> cases;
    for (int i = 0; i < cases; i++) {
        Node *head = 0;
        int size;
        cin >> size;
        for (int j = 0; j < size; j++) {
            int data;
            cin >> data;
            head = InsertTail(head, data);
        }
        Print(head);

        int position;
        cin >> position;
        cout << "GetNode at " << position << ": " << GetNode(head, position) << endl;
    }
}
