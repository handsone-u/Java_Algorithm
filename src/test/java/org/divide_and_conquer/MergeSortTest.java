package org.divide_and_conquer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class MergeSortTest {

  @Test
  void testMergeSortWithIntegers() {
    MergeSort<Integer> sorter = new MergeSort<>();
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12, 11, 13, 5, 6, 7));
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(5, 6, 7, 11, 12, 13));

    sorter.mergeSort(list, 0, list.size() - 1);

    assertEquals(expected, list);
  }

  @Test
  void testMergeSortWithStrings() {
    MergeSort<String> sorter = new MergeSort<>();
    ArrayList<String> list = new ArrayList<>(Arrays.asList("banana", "apple", "cherry", "date"));
    ArrayList<String> expected = new ArrayList<>(
        Arrays.asList("apple", "banana", "cherry", "date"));

    sorter.mergeSort(list, 0, list.size() - 1);

    assertEquals(expected, list);
  }

  @Test
  void testMergeSortWithEmptyList() {
    MergeSort<Integer> sorter = new MergeSort<>();
    ArrayList<Integer> list = new ArrayList<>();

    sorter.mergeSort(list, 0, list.size() - 1);

    assertTrue(list.isEmpty());
  }

  @Test
  void testMergeSortWithSingleElement() {
    MergeSort<Integer> sorter = new MergeSort<>();
    ArrayList<Integer> list = new ArrayList<>(Collections.singletonList(1));

    sorter.mergeSort(list, 0, list.size() - 1);

    assertEquals(1, list.size());
    assertEquals(Integer.valueOf(1), list.get(0));
  }

  @Test
  void testMergeSortWithReverseSortedList() {
    MergeSort<Integer> sorter = new MergeSort<>();
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    sorter.mergeSort(list, 0, list.size() - 1);

    assertEquals(expected, list);
  }
}