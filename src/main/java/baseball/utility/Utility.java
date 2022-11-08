package baseball.utility;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Utility {
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String OPENING = "숫자 야구 게임을 시작합니다.";
    public static final String ENDING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String INPUT_MENT = "숫자를 입력해주세요 : ";
    public static final String CONTINUE_MENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static int ANSWER_LENGTH = 3;

    public static String makeThreeRandomNumber(){
        Set<Integer> set = new HashSet<Integer>();

        while (set.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            set.add(randomNumber);
        }

        StringBuilder sb = new StringBuilder("");
        for(Integer elem : set) {
            sb.append(Integer.toString(elem));
        }

        return sb.toString();
    }
}
