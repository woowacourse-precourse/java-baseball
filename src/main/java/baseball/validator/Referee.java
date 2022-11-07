package baseball.validator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Referee implements Validator {

    private List<Integer> answer;
    private int strike = 0;
    private int ball = 0;

    @Override
    public void setAnswer(List<Integer> answer) {
        validateAnswer(answer);
        this.answer = answer;
    }

    @Override
    public List<Integer> getAnswer() {
        return answer;
    }

    @Override
    public boolean checkAnswer(List<Integer> input) {
        validateAnswer(input);
        initStatus();

        for (int i = 0; i < answer.size(); i++) {
            checkAnswerIndex(input, i);
        }
        printCurrentStatus();

        if (strike == 3) {
            return true;
        }
        return false;
    }

    private void checkAnswerIndex(List<Integer> input, int i) {
        if (answer.contains(input.get(i))) {
            if (Objects.equals(answer.get(i), input.get(i))) {
                strike++;
            } else {
                ball++;
            }
        }
    }

    private void initStatus() {
        strike = 0;
        ball = 0;
    }

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

    private boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

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

    private boolean isInRange(List<Integer> input) {
        for (int num : input) {
            if (!(num >= 1 && num <= 9)) {
                return false;
            }
        }
        return true;
    }

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
