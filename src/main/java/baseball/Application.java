package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> getRandomNum() {
        List<Integer> result = new ArrayList<>();
        boolean[] duplicate = new boolean[10];
        int randNum;

        for (int i = 0; i < 3; i++) {
            randNum = Randoms.pickNumberInRange(1, 9);
            if (duplicate[randNum]) {
                i--;
                continue;
            } else {
                duplicate[randNum] = true;
                result.add(randNum);
            }
        }
        return result;
    }

    public static List<Integer> parseUserInput(String ipt) throws IllegalArgumentException {
        List<Integer> result = new ArrayList<>();
        boolean[] duplicate = new boolean[10];

        //3자릿수 길이제한
        if (ipt.length() != 3) {
            throw new IllegalArgumentException("입력의 길이가 맞지 않음");
        }

        /*
         * Integer.parseInt 함수를 쓰면 오히려 복잡해지는 부분이 생김(음수 등)
         * 그냥 아스키 코드로 직접 처리했다.
         */
        char c;
        for (int i = 0; i < ipt.length(); i++) {
            c = ipt.charAt(i);
            // 1~9까지 숫자가 아닌 경우
            if (c < 49 || c > 57) {
                throw new IllegalArgumentException("유효 숫자가 아님");
            }
            //중복되는 경우
            if (duplicate[c - 48]) {
                throw new IllegalArgumentException("중복되는 숫자 존재");
            }
            duplicate[c - 48] = true;
            result.add(c - 48);
        }
        return result;
    }

    public static int getStrikeCnt(List<Integer> A, List<Integer> B) {
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == B.get(i)) {
                result++;
            }
        }
        return result;
    }

    public static int getBallCnt(List<Integer> A, List<Integer> B) {
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            //B에 A[i]가 포함되고 strike는 아니라면
            if (B.contains(A.get(i)) && A.get(i) != B.get(i)) {
                result++;
            }
        }
        return result;
    }
}
