package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomNum {
    // 조건에 맞는 랜덤값 생성
    public static List<Integer> generate() {
        List<Integer> numList = new ArrayList<>();
        boolean[] hasNum = new boolean[9]; // [0]: 1
        Arrays.fill(hasNum, Boolean.FALSE); // false 초기값

        // 3자리 자연수
        while (numList.size() < 3) {
            // 1부터 9로만 구성
            int newNum = Randoms.pickNumberInRange(1, 9);

            // 중복되지 않는 수
            if (!hasNum[newNum - 1]) {
                numList.add(newNum);
                hasNum[newNum - 1] = true;
                //System.out.println(newNum); //테스트 위한 정답 확인 코드 - 삭제 예정
            }
        }

        return numList;
    }
}
