package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScoreDetect {

    /**
     * get strike count by number
     * @param answer
     * @param numbers
     * @return
     */
    public int getStrikeCount (
            List<Integer> answer,
            List<Integer> numbers
    ) {
        if (answer.size() != 3
                || numbers.size() != 3
                || !checkDuplicate(answer)
                || !checkDuplicate(numbers)
                || !checkAllowedRange(answer)
                || !checkAllowedRange(numbers))
            return -1;

        int count = 0;

        for (int i=0; i<3; i++){
            if (answer.get(i) == numbers.get(i))
                count++;
        }

        return count;
    }

    public int getBallCount (
            List<Integer> answer,
            List<Integer> numbers
    ) {
        if (numbers.size() != 3)
            return -1;
        return 0;
    }


    /**
     * 중복검사
     */
    private boolean checkDuplicate(List<Integer> numList) {
        Set<Integer> numSet = new HashSet<>(numList);
        if (numSet.size() == numList.size())
            return true;
        else
            return false;
    }

    /**
     * 범위(1~9)를 넘어가는 숫자 검사
     */
    private boolean checkAllowedRange(List<Integer> numList) {
        for(int i=0; i<numList.size(); i++){
            if(numList.get(i) > 9 ||numList.get(i) < 1)
                return false;
        }
        return true;
    }

}
