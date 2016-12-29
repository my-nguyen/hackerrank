#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <iomanip>
using namespace std;

struct Record {
    int positives;
    int negatives;
    int zeroes;

    Record() {
        positives = 0;
        negatives = 0;
        zeroes = 0;
    }
};

Record tally(const vector<int>& array) {
    Record record;
    for (int i = 0; i < array.size(); i++) {
        if (array[i] > 0)
            record.positives++;
        else if (array[i] < 0)
            record.negatives++;
        else
            record.zeroes++;
    }
    return record;
}

int main(){
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int arr_i = 0;arr_i < n;arr_i++){
       cin >> arr[arr_i];
    }
    Record record = tally(arr);
    float size = arr.size();
    cout << fixed << setprecision(6);
    cout << record.positives/size << endl << record.negatives/size << endl << record.zeroes/size << endl;
    return 0;
}
