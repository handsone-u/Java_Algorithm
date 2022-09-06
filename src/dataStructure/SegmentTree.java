package dataStructure;

public class SegmentTree {
    int n,m, k;
    long[] arr;
    long[] segmentTree;

    private void update(int start, int end, int node, int target, long diff) {
        // 범위를 벗어남
        if(target<start||end<target) return;
        // 범위 안
        segmentTree[node] += diff;

        if(start>=end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, target, diff);
        update(mid + 1, end, node * 2 + 1, target, diff);
    }

    // [start, end] : 시작, 끝 index
    // [from, to] : 구하려고 하는 구간 합의 범위
    private long range(int start, int end, int node, int from, int to) {
        // 범위 밖 (구간 합의 범위를 벗어난 index)
        if(from>end||to<start) return 0;
        // 범위 안
        else if(from<=start&&end<=to) return segmentTree[node];
        // 그외의 경우, 아래 노드로 이동
        int mid = (start + end) / 2;
        return range(start, mid, node * 2, from, to) + range(mid + 1, end, node * 2 + 1, from, to);
    }

    // [start, end] : 구간 합을 Node 번째에 초기화.
    private long init(int start, int end, int node) {
        if(start==end) return segmentTree[node] = arr[start];
        int mid = (start + end) / 2;

        return segmentTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }
}
