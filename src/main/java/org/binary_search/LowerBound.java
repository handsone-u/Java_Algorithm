package org.binary_search;

import java.util.ArrayList;

public class LowerBound<T extends Comparable<T>> {

  // target 이상인 첫 번째 위치
  public int lowerBound(ArrayList<T> list, T target) {
    int left = 0;
    int right = list.size();

    // target 보다 작은 경우 left를 이동
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (list.get(mid).compareTo(target) < 0) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }
}
