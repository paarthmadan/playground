#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

void quicksort(int t[], int p[], int l, int h);
int partition(int t[], int p[], int l, int h);

int main() {
  int n;
  cin >> n;

  int t[n];
  int p[n];

  for (int i = 0; i < n; i++) {
    cin >> t[i] >> p[i];
  }

  quicksort(t, p, 0, n - 1);

  double maxVl = 0.0;

  for (int i = 0; i < n - 1; i++) {
    double dv = abs((double)(p[i + 1] - p[i]) / (double)(t[i + 1] - t[i]));
    if (dv > maxVl) maxVl = dv;
  }

  cout << fixed << setprecision(5) << maxVl;

  return 0;
}

void quicksort(int t[], int p[], int l, int h) {
  if (l < h) {
    int pv = partition(t, p, l, h);
    quicksort(t, p, l, pv); 
    quicksort(t, p, pv + 1, h); 
  }
}

int partition(int t[], int p[], int l, int h) {
  int pv = t[(h + l) / 2];
  int i = l - 1;
  int j = h + 1;

  while (i < j) {
    do i++; while (t[i] < pv);
    do j--; while (t[j] > pv);

    if (i >= j) {
      return j;
    }

    int temp = t[i];
    t[i] = t[j];
    t[j] = temp;

    temp = p[i];
    p[i] = p[j];
    p[j] = temp;
  }

  return (h + l) / 2;
}

