#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

class Node {
public:
    int id;
    bool visited;
    int level;
    vector<Node*> children;

public:
    Node(int newId) {
        id = newId;
        visited = false;
        level = 0;
    }

    void sort() {
        std::sort(children.begin(), children.end(), mycompare);
    }

    static bool mycompare(Node* left, Node* right) {
        return left->id < right->id;
    }

    friend ostream& operator<<(ostream& out, const Node& node) {
        out << "<id:" << node.id << ",visited:" << node.visited << ",level:" << node.level << ">";
        return out;
    }
};

class Graph {
private:
    vector<Node*> nodes;

public:
    Graph(int size) {
        for (int i = 0; i < size; i++) {
            Node* node = new Node(i+1);
            nodes.push_back(node);
        }
    }

    ~Graph() {
    }

    friend ostream& operator<<(ostream& out, const Graph& graph) {
        for (int i = 0; i < graph.nodes.size(); i++) {
            out << *graph.nodes.at(i) << endl;
        }
        return out;
    }

    void add_edge(int pindex, int cindex) {
        Node* parent = nodes.at(pindex);
        Node* child = nodes.at(cindex);
        parent->children.push_back(child);
    }

    vector<int> shortest_reach(int start) {
        Node* root = nodes[start];
        queue<Node*> myqueue;
        myqueue.push(root);
        while (!myqueue.empty()) {
            Node* parent = myqueue.front();
            myqueue.pop();
            cout << "pop: " << *parent << endl;
            for (Node* child : parent->children) {
                if (!child->visited) {
                    child->visited = true;
                    child->level = parent->level + 1;
                    myqueue.push(child);
                    cout << "push: " << *child << endl;
                }
            }
        }

        vector<int> distances;
        for (int i = 0; i < nodes.size(); i++) {
            Node* node = nodes[i];
            if (node->id != start-1) {
                int distance;
                if (node->level == 0) {
                    distance = -1;
                } else {
                    distance = 6 * node->level;
                }
                distances.push_back(distance);
            }
        }

        return distances;
    }

    void sort() {
        for (int i = 0; i < nodes.size(); i++)
            nodes[i]->sort();
    }
};

int main() {
    int queries;
    cin >> queries;

    for (int t = 0; t < queries; t++) {
        int nodes, edges;
        cin >> nodes;
        // Create a graph of size n where each edge weight is 6:
        Graph graph(nodes);
        cin >> edges;
        // read and set edges
        // cout << "whole graph: " << endl << graph;
        for (int i = 0; i < edges; i++) {
            int left, right;
            cin >> left >> right;
            left--, right--;
            // add each edge to the graph
            graph.add_edge(left, right);
        }
        graph.sort();
        cout << "whole graph" << endl << graph;
        int startId;
        cin >> startId;
        startId--;
        // Find shortest reach from node s
        vector<int> distances = graph.shortest_reach(startId);

        for (int i = 0; i < distances.size(); i++) {
            if (i != startId) {
                cout << distances[i] << " ";
            }
        }
        cout << endl;
    }

    return 0;
}
