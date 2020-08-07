#include <iostream>
#include <map>
#include <queue>
#include <unordered_map>
#include <vector>

using namespace std;

struct Pos {
  int r;
  int c;
  bool discovered;

  bool isDest() {
    return r == 1 && c == 1;
  }

  bool operator==(const Pos &other) const { 
    return r == other.r && c == other.c;
  }

  int product() {
    return r * c;
  }
};

bool bfs(unordered_map<int, vector<Pos> > mx, Pos root);

int main() {
  int m, n;
  cin >> m >> n;

  unordered_map<int, vector<Pos> > mx;

  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      int x; 
      cin >> x;
      mx[x].push_back({i + 1, j + 1});
    }
  }

  cout << (bfs(mx, {m, n}) ? "yes" : "no");

  return 0;
}

bool bfs(unordered_map<int, vector<Pos> > mx, Pos root) {
  queue<Pos> q;

  root.discovered = true;
  q.push(root);

  while(!q.empty()) {
    Pos curr = q.front();

    if (curr.isDest()) { return true; }

    vector<Pos> edges = mx[curr.product()];

    for (auto it = edges.begin(); it != edges.end(); ++it) {
      if (!it->discovered) {
        it->discovered = true;
        q.push(*it);
      }
    }

    q.pop();
  }

  return false;
}
