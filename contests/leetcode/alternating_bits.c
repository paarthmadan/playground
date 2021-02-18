#include <stdio.h>
#include <stdbool.h>
#include <assert.h>

bool hasAlternatingBits(int n);

int main() {
    assert(hasAlternatingBits(5) == true);
    assert(hasAlternatingBits(10) == true);
    assert(hasAlternatingBits(7) == false);
    assert(hasAlternatingBits(11) == false);
    assert(hasAlternatingBits(4) == false);
    return 0;
}

bool hasAlternatingBits(int n){
  unsigned int p = n;
  unsigned int maskEven = 0B10101010101010101010101010101010;
  unsigned int maskOdd  = 0B01010101010101010101010101010101;

  return (maskEven | p) == maskEven && ~(maskEven | ~p) == 0;
}
