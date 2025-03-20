package org.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LowerBoundTest {

  private LowerBound<Integer> lowerBound;
  private ArrayList<Integer> sortedList;

  @BeforeEach
  void setUp() {
    lowerBound = new LowerBound<>();
    sortedList = new ArrayList<>(Arrays.asList(1, 3, 3, 5, 7, 9, 9, 11));
  }

  @Test
  void testLowerBoundWithExistingElement() {
    assertEquals(1, lowerBound.lowerBound(sortedList, 3));
    assertEquals(3, lowerBound.lowerBound(sortedList, 5));
    assertEquals(5, lowerBound.lowerBound(sortedList, 9));
  }

  @Test
  void testLowerBoundWithNonExistingElement() {
    assertEquals(3, lowerBound.lowerBound(sortedList, 4));
    assertEquals(7, lowerBound.lowerBound(sortedList, 10));
  }

  @Test
  void testLowerBoundWithElementSmallerThanAll() {
    assertEquals(0, lowerBound.lowerBound(sortedList, 0));
  }

  @Test
  void testLowerBoundWithElementLargerThanAll() {
    assertEquals(8, lowerBound.lowerBound(sortedList, 12));
  }

  @Test
  void testLowerBoundWithEmptyList() {
    ArrayList<Integer> emptyList = new ArrayList<>();
    assertEquals(0, lowerBound.lowerBound(emptyList, 5));
  }

  @Test
  void testLowerBoundWithSingleElementList() {
    ArrayList<Integer> singleElementList = new ArrayList<>(List.of(5));
    assertEquals(0, lowerBound.lowerBound(singleElementList, 3));
    assertEquals(0, lowerBound.lowerBound(singleElementList, 5));
    assertEquals(1, lowerBound.lowerBound(singleElementList, 7));
  }
}