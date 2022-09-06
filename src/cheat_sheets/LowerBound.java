package cheat_sheets;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Lower Bound.
 * C++의 Vector 의 lower_bound 와 유사한 기능
 */
public class LowerBound {

    int lowerBound(ArrayList<Integer> lis, int value) {
        int low = 0;
        int high = lis.size();

        while (low < high) {
            int mid = (low + high) / 2;
            if(lis.get(mid)<value) low = mid + 1;
            else high = mid;
        }

        return low;
    }
}
