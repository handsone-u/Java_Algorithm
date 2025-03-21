package org.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

  private final int v;
  private final List<List<Node>> adj; // directed graph

  public Dijkstra(int v) {
    this.v = v;
    adj = new ArrayList<>(v);
    for (int i = 0; i < v; i++) {
      adj.add(new ArrayList<>());
    }
  }

  public void addEdge(int u, int v, int weight) {
    adj.get(u).add(new Node(v, weight));
  }

  public int[] dijkstra(int src) {
    int[] distances = new int[v];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[src] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(src, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();

      // already visited
      if (node.weight > distances[node.index]) {
        continue;
      }

      for (Node next : adj.get(node.index)) {
        int distance = node.weight + next.weight;
        if (distance < distances[next.index]) {
          distances[next.index] = distance;
          pq.add(new Node(next.index, distance));
        }
      }
    }

    return distances;
  }

  static class Node implements Comparable<Node> {

    int index;
    int weight;

    Node(int index, int weight) {
      this.index = index;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return this.weight - o.weight;
    }
  }
}
