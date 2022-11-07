package baseball.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Human implements Playable {
    private List<Integer> answer;

    public Human() {
        this.answer = new ArrayList<>();
    }

    @Override
    public List<Integer> getAnswer() {
        return answer;
    }

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
