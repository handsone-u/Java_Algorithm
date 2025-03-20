package org.divide_and_conquer;

import java.util.ArrayList;

public class MergeSort<T extends Comparable<T>> {

  public void mergeSort(final ArrayList<T> list, final int left, final int right) {
    // divide
    if (left < right) {
      int mid = left + (right - left) / 2;

      // conquer
      mergeSort(list, left, mid);
      mergeSort(list, mid + 1, right);

      // combine
      merge(list, left, mid, right);
    }
  }

  private void merge(final ArrayList<T> list, final int left, final int mid, final int right) {
    int leftLength = mid - left + 1;
    int rightLength = right - mid;

    // Copy to temp list
    ArrayList<T> leftList = new ArrayList<>(leftLength);
    ArrayList<T> rightList = new ArrayList<>(rightLength);

    for (int i = 0; i < leftLength; i++) {
      leftList.add(list.get(left + i));
    }
    for (int i = 0; i < rightLength; i++) {
      rightList.add(list.get(mid + 1 + i));
    }

    // Merge temp list
    int i = 0;
    int j = 0;
    int k = left;
    while (i < leftLength && j < rightLength) {
      if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
        list.set(k, leftList.get(i++));
      } else {
        list.set(k, rightList.get(j++));
      }
      k++;
    }

    // Merge remaining copy-list
    while (i < leftLength) {
      list.set(k++, leftList.get(i++));
    }

    while (j < rightLength) {
      list.set(k++, rightList.get(j++));
    }
  }
}
