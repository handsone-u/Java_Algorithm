package org.dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

  final int[] perms;
  final boolean[] used;
  final int n;
  final int r;

  List<int[]> result = new ArrayList<>();

  public Permutation(int n, int r) {
    this.n = n;
    this.r = r;
    perms = new int[r];
    used = new boolean[n];
    this.permutation(0);
  }

  public List<int[]> getResult() {
    return this.result;
  }

  private void permutation(int cnt) {
    if (cnt == r) {
      result.add(perms.clone());
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!used[i]) {
        perms[cnt] = i;
        used[i] = true;
        permutation(cnt + 1);
        used[i] = false;
      }
    }
  }
}
