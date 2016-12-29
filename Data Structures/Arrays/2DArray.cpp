#include <vector>
#include <iostream>
using namespace std;

int max_hourglass(vector<vector<int> >& matrix) {
    // there's a total of 7 cells in an hourglass, each cell having a minimum
    // value of -9. Hence -63.
    int max = -63;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            int sum = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2]
                                   + matrix[i+1][j+1]
                  + matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];
            if (sum > max)
                max = sum;
        }
    }
    return max;
}

int main(){
    vector< vector<int> > arr(6,vector<int>(6));
    for(int arr_i = 0;arr_i < 6;arr_i++){
       for(int arr_j = 0;arr_j < 6;arr_j++){
          cin >> arr[arr_i][arr_j];
       }
    }
    cout << max_hourglass(arr) << endl;
    return 0;
}
