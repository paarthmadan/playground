// Essential Rabin-Karp algorithm
// Use basic XOR hash to be permutation indifferent, ie. "abc" and "cba" will have the same hash
// Use a histogram, or frequency_array to do equality checks, in case of collision.
// Use an unordered_set for distinction
// TODO: fix mem ineffiency for large cases (probably the unordered_set)
#include <iostream>
#include <unordered_set>

#define ALPHA_LEN 26

using namespace std;

struct RollingHash {
  int hash = 0;
  int x = 0;
  int hist[ALPHA_LEN] = { 0 };

  RollingHash(string st) {
    for(char& c : st) {
      add(c);
    }
  }

  void pop(char c) {
    hash ^= c;
    hist[c - 'a']--;
  }

  void add(char c) {
    hash ^= c;
    hist[c - 'a']++;
  }

  void printHist() {
    for(int i = 0; i < ALPHA_LEN; i++) {
      char c = 'a' + i;
      cout << c << ": " << hist[i] << endl;
    }
  }

  bool operator==(const RollingHash &other) const {
    return std::equal(begin(hist), end(hist), begin(other.hist));
  }
};

int main() {
  string n, m;
  cin >> n >> m;

  size_t windowLen = n.length();
  size_t wordLen = m.length();

  if (wordLen < windowLen) {
    cout << 0;
    return 0;
  }

  RollingHash primary = RollingHash(n);
  RollingHash window = RollingHash(m.substr(0, windowLen));

  unordered_set<string> perm;

  for (size_t i = 0; i <= wordLen - windowLen; i++) {
    if (primary.hash == window.hash && primary == window) {
      perm.insert(m.substr(i, windowLen));
    }
    window.pop(m[i]);
    window.add(m[i + windowLen]);
  }

  for (string s : perm) cout << s << endl;

  cout << perm.size();
}


