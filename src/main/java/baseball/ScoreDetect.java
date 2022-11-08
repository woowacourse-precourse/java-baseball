package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScoreDetect {

    /**
     * 숫자 리스트를 받아 스트라이크 점수 판정
     * get strike count by number
     */
    public static int getStrikeCount(
            List<Integer> answer,
            List<Integer> numbers
    ) {
        if (answer.size() != 3
                || numbers.size() != 3          // 리스트 크기 확인
                || !checkDuplicate(answer)
                || !checkDuplicate(numbers)     // 중복문자 확인
                || !checkAllowedRange(answer)
                || !checkAllowedRange(numbers)) // 숫자 범위 확인
            throw new IllegalArgumentException();

        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.get(i) == numbers.get(i))
                count++;
        }

        return count;
    }


    /**
     * 숫자 리스트를 받아 볼 점수 판정
     * get ball count by number
     */
    public static int getBallCount(
            List<Integer> answer,
            List<Integer> numbers
    ) {
        if (answer.size() != numbers.size()     // 리스트 크기 확인
                || !checkDuplicate(answer)
                || !checkDuplicate(numbers)     // 중복문자 확인
                || !checkAllowedRange(answer)
                || !checkAllowedRange(numbers)) // 숫자 범위 확인
            throw new IllegalArgumentException();

        int count = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == numbers.get(i)) // 스트라이크인 경우 패스
                continue;
            if (answer.contains(numbers.get(i)))
                count++;
        }

        return count;
    }


    /**
     * 중복검사
     */
    private static boolean checkDuplicate(List<Integer> numList) {
        Set<Integer> numSet = new HashSet<>(numList);
        if (numSet.size() == numList.size())
            return true;
        else
            return false;
    }

    /**
     * 범위(1~9)를 넘어가는 숫자 검사
     */
    private static boolean checkAllowedRange(List<Integer> numList) {
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) > 9 || numList.get(i) < 1)
                return false;
        }
        return true;
    }

}
