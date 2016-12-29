#include <iostream>
#include <stack>
using namespace std;

class MyQueue {
private:
    stack<int> inStack;
    stack<int> outStack;

public:
    void push(int x) {
        inStack.push(x);
    }

    void pop() {
        if (!inStack.empty() || !outStack.empty()) {
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    int element = inStack.top();
                    inStack.pop();
                    outStack.push(element);
                }
            }
            outStack.pop();
        }
    }

    int front() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                int element = inStack.top();
                inStack.pop();
                outStack.push(element);
            }
        }
        return outStack.top();
    }
};

int main() {
    MyQueue q1;
    int q, type, x;
    cin >> q;

    for(int i = 0; i < q; i++) {
        cin >> type;
        if(type == 1) {
            cin >> x;
            q1.push(x);
        }
        else if(type == 2) {
            q1.pop();
        }
        else cout << q1.front() << endl;
    }
    return 0;
}
