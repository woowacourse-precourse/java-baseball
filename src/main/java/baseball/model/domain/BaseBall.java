package baseball.model.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBall {

    private Long id;
    private Integer ball = 0;
    private Integer strike = 0;
    private boolean isMatch = false;
    private List<Integer> answer;

    public BaseBall() {
        this.answer = createAnswer();
    }

    public BaseBall(Long id, Integer ball, Integer strike, boolean isMatch, List<Integer> answer) {
        this.id = id;
        this.ball = ball;
        this.strike = strike;
        this.isMatch = isMatch;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public Integer getBall() {
        return ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }

    private List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }

    public void match(String input) {
        List<Integer> inputs = Arrays.stream(input.split(""))
                .collect(Collectors.toList())
                .stream().map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());


        this.ball = calBallCount(inputs);
        this.strike = calStrikeCount(inputs);

        this.isMatch = this.strike == 3 && this.ball == 0;
    }

    private Integer calBallCount(List<Integer> inputs) {
        int result = 0;

        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < inputs.size(); j++) {
                if (i != j && answer.get(i).equals(inputs.get(j))) {
                    result++;
                }
            }
        }

        return result;
    }

    private Integer calStrikeCount(List<Integer> inputs) {
        int result = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(inputs.get(i))) {
                result++;
            }
        }

        return result;
    }
}
