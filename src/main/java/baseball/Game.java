package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int END_STRIKE_COUNT = 3;

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> setComputersRandomAnswer() {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            int addNumber = ListUtil.getRandomIntegerExcludeInList(answer);
            answer.add(addNumber);
        }
        return answer;
    }

    public boolean isPlayingNewGame() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");\
        String choice = Console.readLine().trim();

        if (UserInputException.isIllegalChoice(choice)) {
            throw new IllegalArgumentException("잘못된 선택입니다.");
        }

        if (choice.equals("1")){
            return true;
        }
        System.out.println("게임 종료");
        return false;
    }

    public boolean getGameResultOfJudge(List<Integer> ballStrikeCount) {
    }
}
