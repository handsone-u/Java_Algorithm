package org.binary_search;

import java.util.ArrayList;

public class UpperBound <T extends Comparable<T>>{

  // target 초과인 첫 번째 위치
  public int upperBound(ArrayList<T> list, T target) {
    int left = 0;
    int right = list.size();

    // target 보다 작거나 같은 경우 left를 이동
    while (left < right) {
      int mid = left + (right - left) / 2;
      T midValue = list.get(mid);
      if (midValue.compareTo(target) <= 0) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }
}
