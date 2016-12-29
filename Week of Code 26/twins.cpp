#include <iostream>
#include <cmath>
#include <cstring>
using namespace std;

class sieve {
private:
    bool* prime;

public:
    sieve(int n) {
        sieve_of_eratosthenes(n);
    }

    ~sieve() {
        delete [] prime;
    }

    void sieve_of_eratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize all entries as
        // true. A value in prime[i] will finally be false if i is Not a prime,
        // else true.
        prime = new bool[n+1];
        memset(prime, true, (n+1)*sizeof(bool));

        for (int p = 2; p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Update all multiples of p
                for (int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        /*
        // Print all prime numbers
        for (int p = 2; p <= n; p++)
            if (prime[p])
                cout << p << " ";
        cout << endl;
        */
    }

    bool is_prime_old(int number) {
        for (int i = 3; i <= sqrt(number); i++)
            if (number % i == 0)
                return false;
        return true;
    }

    bool is_prime(int number) {
        return prime[number];
    }
};

int main() {
    int low, high;
    cin >> low >> high;
    if (low % 2 == 0)
        low++;
    int sum = 0;
    sieve sieve(high);
    for (int i = low; i < high; i += 2) {
        if (sieve.is_prime(i) && sieve.is_prime(i+2)) {
            cout << "pair: " << i << ", " << i+2 << endl;
            sum++;
        }
    }
    cout << sum << endl;
}
