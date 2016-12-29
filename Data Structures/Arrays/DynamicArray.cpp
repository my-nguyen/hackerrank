#include <iostream>
#include <vector>
using namespace std;

struct Query {
    int type;
    int index;
    int value;
};

void process(int sequence_count, vector<Query>& queries) {
    vector<vector<int> > sequences(sequence_count, vector<int>());
    int last_answer = 0;
    for (Query query : queries) {
        int index = (query.index ^ last_answer) % sequence_count;
        switch (query.type) {
            case 1:
                sequences[index].push_back(query.value);
                break;
            case 2:
                int j = query.value % sequences[index].size();
                last_answer = sequences[index][j];
                cout << last_answer << endl;
                break;
        }
    }
}

int main() {
    int sequence_count, query_count;
    cin >> sequence_count >> query_count;
    vector<Query> queries;
    for (int i = 0; i < query_count; i++) {
        Query query;
        cin >> query.type >> query.index >> query.value;
        queries.push_back(query);
    }
    process(sequence_count, queries);
    return 0;
}
