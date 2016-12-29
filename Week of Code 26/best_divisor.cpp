#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

vector<int> get_divisors(int number) {
    vector<int> divisors;
    for (int i = 1; i <= sqrt(number); i++) {
        if (number % i == 0) {
            if (i*i == number) {
                divisors.push_back(i);
            }
            else {
                divisors.push_back(i);
                divisors.push_back(number/i);
            }
        }
    }
    return divisors;
}

vector<int> get_digits(int number) {
    vector<int> digits;
    while (number > 0) {
        digits.push_back(number % 10);
        number /= 10;
    }
    return digits;
}

int sum_digits(vector<int>& digits) {
    int sum = 0;
    for (int i = 0; i < digits.size(); i++)
        sum += digits[i];
    return sum;
}

int main(){
    int n;
    cin >> n;
    vector<int> divisors = get_divisors(n);
    int max_sum = 0;
    int max_divisor = 0;
    for (int i = 0; i < divisors.size(); i++) {
        vector<int> digits = get_digits(divisors[i]);
        int sum = sum_digits(digits);
        if (sum > max_sum) {
            max_sum = sum;
            max_divisor = divisors[i];
        }
        else if (sum == max_sum) {
            if (max_divisor > divisors[i])
                max_divisor = divisors[i];
        }
    }

    cout << max_divisor << endl;
    return 0;
}
