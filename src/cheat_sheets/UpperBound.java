package cheat_sheets;

import java.util.List;

public class UpperBound {

    public int upperBound(List<Integer> lis, int value) {
        int low = 0;
        int high = lis.size();

        while (low < high) {
            int mid = (low + high) / 2;
            if(lis.get(mid)>value) high = mid - 1;
            else low = mid;
        }

        return high;
    }

}
