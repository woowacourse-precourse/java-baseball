package baseball.validator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 입력받은 값이 유효한지 또는 답인지 판별하는 역할을 맡는다.
 */
public class Referee implements Validator {

    private List<Integer> answer;
    private int strike = 0;
    private int ball = 0;

    /**
     * 생성된 정답을 받아 유효성을 판단하고 저장한다. 유효하지 않으면 <code>IllegalArgumentException</code>예외를 던진다.
     *
     * @param answer
     */
    @Override
    public void setAnswer(List<Integer> answer) {
        validateAnswer(answer);
        this.answer = answer;
    }

    @Override
    public List<Integer> getAnswer() {
        return answer;
    }

    /**
     * 입력값이 정답이면 true 를 반환한다. 또한, 입력값을 분석하여 상태를 출력한다.
     *
     * @param input
     * @return 정답이면 true
     */
    @Override
    public boolean checkAnswer(List<Integer> input) {
        validateAnswer(input);
        initStatus();

        for (int index = 0; index < answer.size(); index++) {
            checkAnswerIndex(input, index);
        }
        printCurrentStatus();

        if (strike == 3) {
            return true;
        }
        return false;
    }

    /**
     * index 별로 strike 인지 ball 인지 판별한다. 이후, 현재 상태에 대해 출력한다.
     *
     * @param input
     * @param index
     */
    private void checkAnswerIndex(List<Integer> input, int index) {
        if (answer.contains(input.get(index))) {
            if (Objects.equals(answer.get(index), input.get(index))) {
                strike++;
            } else {
                ball++;
            }
        }
    }

    /**
     * 상태를 초기화시킨다.
     */
    private void initStatus() {
        strike = 0;
        ball = 0;
    }

    /**
     * 현재 상태에 대해 출력한다. ball 과 strike 가 존재하지 않으면 낫싱을 출력한다.
     */
    private void printCurrentStatus() {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        if (isNothing(strike, ball)) {
            sb.append("낫싱");
        }
        System.out.println(sb);
    }

    /**
     * 낫싱인지 판별한다. 낫싱이라면 true 를 반환한다.
     *
     * @param strike
     * @param ball
     * @return 낫싱이라면 true
     */
    private boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    /**
     * 입력값에 대해 유효성을 판별한다. 유효하지 않다면 <code>IllegalArgumentException</code>예외를 던진다.
     * <p>- 길이: 3</p>
     * <p>- 범위: 1이상 9이하</p>
     * <p>- 중복: 불허용</p>
     *
     * @param input
     */
    private void validateAnswer(List<Integer> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException("입력값의 길이는 무조건 3이여야 합니다.");
        }
        if (!isInRange(input)) {
            throw new IllegalArgumentException("입력값의 범위는 1 이상 9 이하여야 합니다.");
        }
        if (isDuplicated(input)) {
            throw new IllegalArgumentException("중복된 값을 입력할 수 없습니다.");
        }
    }

    /**
     * 입력값이 지정된 범위 내에 있는지 판별한다.
     *
     * @param input
     * @return 범위 내에 있으면 true
     */
    private boolean isInRange(List<Integer> input) {
        for (int num : input) {
            if (!(num >= 1 && num <= 9)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 중복 요소가 있는지 판별한다.
     *
     * @param input
     * @return 중복 요소가 없으면 true
     */
    private boolean isDuplicated(List<Integer> input) {
        List<Integer> list = input.stream()
                .distinct()
                .collect(Collectors.toList());

        if (list.size() == 3) {
            return false;
        }
        return true;
    }
}
