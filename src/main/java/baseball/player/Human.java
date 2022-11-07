package baseball.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 입력값을 받을 수 있다. BaseballGame 에서 정답을 맞추는 주체이다.
 */
public class Human implements Playable {
    private List<Integer> answer;

    public Human() {
        this.answer = new ArrayList<>();
    }

    @Override
    public List<Integer> getAnswer() {
        return answer;
    }

    /**
     * 정답을 입력받는다. 길이가 3을 넘거나 숫자가 아닌 문자를 입력할 시, <code>IllegalArgumentException</code>예외를 던진다.
     */
    @Override
    public void inputAnswer() {
        answer.clear();

        String input = Console.readLine();
        validateInputLength(input);
        String[] inputSplit = input.split("");
        try {
            for (String numStr : inputSplit) {
                answer.add(Integer.parseInt(numStr));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

    }

    private void validateInputLength(String input) {
        if(input.length() > 3){
            throw new IllegalArgumentException("입력값의 길이는 무조건 3이여야 합니다.");
        }
    }
}
