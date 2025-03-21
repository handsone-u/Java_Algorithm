package org.dfs;

import java.util.ArrayList;
import java.util.List;

public class Combination {

  final int[] combs;
  final int n;
  final int r;

  List<int[]> result = new ArrayList<>();

  public Combination(int n, int r) {
    this.n = n;
    this.r = r;
    combs = new int[r];
    this.combination(0, 0);
  }

  public List<int[]> getResult() {
    return this.result;
  }

  private void combination(int from, int cnt) {
    if (cnt == r) {
      result.add(combs.clone());
      return;
    }

    for (int i = from; i < n; i++) {
      combs[cnt] = i;
      combination(i + 1, cnt + 1);
    }
  }
}

