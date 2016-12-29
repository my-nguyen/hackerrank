#include <iostream>
#include <vector>
using namespace std;

void print_reverse(vector<int>& vector) {
    for (int i = vector.size()-1; i >= 0; i--) {
        cout << vector[i] << " ";
    }
    cout << endl;
}

int main(){
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int arr_i = 0;arr_i < n;arr_i++){
       cin >> arr[arr_i];
    }
    print_reverse(arr);
    return 0;
}
