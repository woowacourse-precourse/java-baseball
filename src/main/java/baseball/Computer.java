package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int NUMBER_LENGTH = 3;
    public static final int MAX_RANGE_NUMBER = 9;
    public static final int MIN_RANGE_NUMBER = 1;
    public static final boolean VALID_STATE_TRUE = true;
    public static final boolean VALID_STATE_FALSE = false;

    public static int randomNumber;
    public static int ball;
    public static int strike;

    private List<Integer> quizNumberList;

    public Computer() {}

    /* 문제용 숫자 생성 */
    public void init(){

        do {
            addRandomQuizNumber();      // 숫자 생성 함수
        } while (!validation(quizNumberList));      // with 유효성 검사

    }

    /* 숫자 생성 함수 */
    private void addRandomQuizNumber(){
        quizNumberList = new ArrayList<>();

        while (quizNumberList.size() < NUMBER_LENGTH) {
            randomNumber = pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);

            // 중복된 숫자가 아닐 경우 추가
            if(!quizNumberList.contains(randomNumber)){
                quizNumberList.add(randomNumber);
            }
        }
    }

    /* 유효성 검사 */
    private boolean validation(List<Integer> quizNumberList){
        // 1. 숫자가 부족하거나 많은지 확인
        if (quizNumberList.size() != NUMBER_LENGTH) {
            return VALID_STATE_FALSE;
        }

        // 2. 각각의 숫자가 최소 및 최대 범위에 속하는지 확인
        for (int quizNumber : quizNumberList) {
            if (quizNumber < MIN_RANGE_NUMBER || quizNumber > MAX_RANGE_NUMBER) {
                return VALID_STATE_FALSE;
            }
        }

        // 3. 중복된 숫자가 없는지 확인
        if (quizNumberList.stream().distinct().count() != NUMBER_LENGTH) {
            return VALID_STATE_FALSE;
        }

        return VALID_STATE_TRUE;
    }

    /* 볼 개수 확인 */
    public int ballCount(List<Integer> userNumberList) {
        ball = 0;

        for (int idx = 0; idx < NUMBER_LENGTH; idx++) {
            int userNumber = userNumberList.get(idx);

            // 유저의 숫자를 포함하나 같은 위치에 있지 않을 경우
            if (quizNumberList.contains(userNumber)
                    && userNumber != quizNumberList.get(idx)) {
                ball++;
            }
        }

        return ball;
    }

    /* 스트라이크 개수 확인 */
    public int strikeCount(List<Integer> userNumberList){
        strike = 0;

        for (int idx = 0; idx < NUMBER_LENGTH; idx++) {
            int userNumber = userNumberList.get(idx);

            // 유저의 숫자를 포함하고 같은 위치에 있을 경우
            if (quizNumberList.contains(userNumber)
                    && userNumber == quizNumberList.get(idx)) {
                strike++;
            }
        }

        return strike;
    }
}