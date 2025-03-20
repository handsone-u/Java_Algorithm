package org.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UpperBoundTest {

  private UpperBound<Integer> upperBound;
  private ArrayList<Integer> sortedList;

  @BeforeEach
  void setUp() {
    upperBound = new UpperBound<>();
    sortedList = new ArrayList<>(Arrays.asList(1, 3, 3, 5, 7, 9, 9, 11));
  }

  @Test
  void testUpperBoundWithExistingElement() {
    assertEquals(3, upperBound.upperBound(sortedList, 3));
    assertEquals(7, upperBound.upperBound(sortedList, 9));
  }

  @Test
  void testUpperBoundWithNonExistingElement() {
    assertEquals(3, upperBound.upperBound(sortedList, 4));
    assertEquals(5, upperBound.upperBound(sortedList, 8));
  }

  @Test
  void testUpperBoundWithElementSmallerThanAll() {
    assertEquals(0, upperBound.upperBound(sortedList, 0));
  }

  @Test
  void testUpperBoundWithElementLargerThanAll() {
    assertEquals(8, upperBound.upperBound(sortedList, 12));
  }

  @Test
  void testUpperBoundWithEmptyList() {
    ArrayList<Integer> emptyList = new ArrayList<>();
    assertEquals(0, upperBound.upperBound(emptyList, 5));
  }

  @Test
  void testUpperBoundWithSingleElementList() {
    ArrayList<Integer> singleElementList = new ArrayList<>(List.of(5));
    assertEquals(0, upperBound.upperBound(singleElementList, 3));
    assertEquals(1, upperBound.upperBound(singleElementList, 5));
    assertEquals(1, upperBound.upperBound(singleElementList, 7));
  }

  @Test
  void testUpperBoundWithAllEqualElements() {
    ArrayList<Integer> allEqualList = new ArrayList<>(Arrays.asList(3, 3, 3, 3, 3));
    assertEquals(5, upperBound.upperBound(allEqualList, 3));
  }
}