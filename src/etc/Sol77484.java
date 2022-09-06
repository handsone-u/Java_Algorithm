package etc;

import java.util.Arrays;

public class Sol77484 {
    public int[] solution(int[] lot, int[] win_nums) {
        int[] answer = new int[2];
        int min = 0, max = 0, un=0;

        for (int i = 0; i < 6; i++) {
            if(lot[i]==0) {
                un++;
                continue;
            }
            for (int j = 0; j < 6; j++)
                if (lot[i] == win_nums[j]) min++;
        }
        max = min + un;
        answer[0] = getLev(max);
        answer[1] = getLev(min);
        
        return answer;
    }

    private int getLev(int match) {
        switch (match){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
