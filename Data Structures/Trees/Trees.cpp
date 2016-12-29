#include <iostream>
#include <queue>
using namespace std;

struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int value) {
        data = value;
        left = 0;
        right = 0;
    }
};

class BinaryTree {
public:
    void preOrder(Node *root) {
        if (root != 0) {
            cout << root->data << " ";
            preOrder(root->left);
            preOrder(root->right);
        }
    }

    void postOrder(Node *root) {
        if (root != 0) {
            postOrder(root->left);
            postOrder(root->right);
            cout << root->data << " ";
        }
    }

    void inOrder(Node *root) {
        if (root != 0) {
            inOrder(root->left);
            cout << root->data << " ";
            inOrder(root->right);
        }
    }

    Node *insertOrdered(Node *root, int data) {
        if (root == 0)
            return new Node(data);
        else {
            Node *current;
            if (data <= root->data) {
                current = insert(root->left, data);
                root->left = current;
            } else {
                current = insert(root->right, data);
                root->right = current;
            }
            return root;
        }
    }

    Node *insertUnordered(Node *root, int data) {
        if (root == 0)
            return new Node(data);
        else {
            queue<Node*> queue;
            queue.push(root);
            while (!queue.empty()) {
                Node* top = queue.front();
                queue.pop();
            }
        }
    }

    int getHeight(Node* root) {
        return height(root) - 1;
    }

    void top_view(node * root) {
        top_left(root->left);
        cout << root->data << " ";
        top_right(root->right);
    }

    enum { QUEUE_SIZE = 23 };
    node* queue[QUEUE_SIZE];
    int top, bottom = -1;

    void LevelOrder(node * root) {
        top = bottom = 0;
        queue[bottom] = root;
        while (top <= bottom) {
            node* front = queue[top];
            top = (top + 1) % QUEUE_SIZE;
            cout << front->data << " ";
            if (front->left != 0) {
                bottom = (bottom + 1) % QUEUE_SIZE;
                queue[bottom] = front->left;
                if (front->right != 0) {
                    bottom = (bottom + 1) % QUEUE_SIZE;
                    queue[bottom] = front->right;
                }
            }
        }
    }

    node * insert(node * root, int value) {
        node* current = new node();
        current->data = value;
        if (root == 0)
            root = current;
        else {
            if (value < root->data) {
                if (root->left == 0)
                    root->left = current;
                else
                    insert(root->left, value);
            } else {
                if (root->right == 0)
                    root->right = current;
                else
                    insert(root->right, value);
            }
        }
        return root;
    }

    void decode_huff(node * root, string s) {
        node* current = root;
        string code;
        for (int i = 0; i < s.size(); i++) {
            current = s[i] == '0' ? current->left : current->right;
            if (current->left == 0 && current->right == 0) {
                code += current->data;
                current = root;
            }
        }
        cout << code;
    }

private:
    int height(Node* node) {
        if (node == 0)
            return 0;
        int left = height(node->left);
        int right = height(node->right);
        int max = left > right? left : right;
        return 1 + max;
    }

    void top_left(node* root) {
        if (root != 0) {
            if (root->left != 0)
                top_left(root->left);
            cout << root->data << " ";
        }
    }

    void top_right(node* root) {
        if (root != 0) {
            cout << root->data << " ";
            if (root->right != 0)
                top_right(root->right);
        }
    }
};

int main() {
    BinaryTree tree;
    Node *root = 0;
    int size;
    cin >> size;
    while (size-- > 0) {
        int data;
        cin >> data;
        root = tree.insert(root, data);
        cout << "inserted " << data << ", height: " << tree.getHeight(root) << endl;
    }
    tree.top_view(root);
    cout << endl;

    return 0;
}
