package org.binary_search;

import java.util.ArrayList;

public class BinarySearch<T extends Comparable<T>> {

  /**
   * 정렬된 리스트에서 특정 대상 값을 이진 탐색. 재귀 사용.
   *
   * @param list   탐색할 정렬된 리스트
   * @param target 찾고자 하는 대상 값
   * @return 리스트에서 대상 값이 있는 인덱스, 찾지 못한 경우 -1
   */
  public int search_recursive(ArrayList<T> list, T target) {
    return binarySearch(list, target, 0, list.size() - 1);
  }

  private int binarySearch(ArrayList<T> list, T target, int left, int right) {
    if (left >= right) {
      return -1;
    }

    int mid = left + (right - left) / 2;
    int comparison = target.compareTo(list.get(mid));

    if (comparison == 0) {
      return mid;
    } else if (comparison < 0) {
      return binarySearch(list, target, left, mid - 1);
    } else {
      return binarySearch(list, target, mid + 1, right);
    }
  }

  /**
   * 정렬된 리스트에서 특정 대상 값을 이진 탐색. 반복문 사용.
   *
   * @param list   탐색할 정렬된 리스트
   * @param target 찾고자 하는 대상 값
   * @return 리스트에서 대상 값이 있는 인덱스, 찾지 못한 경우 -1
   */
  public int search_iterative(ArrayList<T> list, T target) {
    int left = 0;
    int right = list.size() - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int comparison = target.compareTo(list.get(mid));

      if (comparison == 0) {
        return mid;
      } else if (comparison < 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }
}
