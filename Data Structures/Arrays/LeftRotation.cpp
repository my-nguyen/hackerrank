#include <iostream>
#include <vector>
#include <algorithm> // std::copy()
using namespace std;

void print(vector<int>& array, const string& label = "") {
    if (label != "")
        cout << label;
    for (int i = 0; i < array.size(); i++)
        cout << array[i] << " ";
    cout << endl;
}

void rotate(vector<int>& array, int rotation) {
    vector<int> tmp(array.begin(), array.begin()+rotation);
    vector<int> copy(array);
    // must use std::copy() to avoid compiler error
    std::copy(copy.begin()+rotation, copy.end(), array.begin());
    std::copy(tmp.begin(), tmp.end(), array.begin()+array.size()-rotation);
}

int main() {
    int size, rotation;
    cin >> size >> rotation;
    vector<int> vector(size);
    for (int i = 0; i < size; i++) {
        cin >> vector[i];
    }
    rotate(vector, rotation);
    print(vector);

    return 0;
}
