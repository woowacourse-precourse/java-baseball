package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int END_STRIKE_COUNT = 3;

    public List<Integer> setComputersRandomAnswer() {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int addNumber = getRandomIntegerExcludeInList(answer);
            answer.add(addNumber);
        }

        return answer;
    }

    public boolean isPlayingNewGame(String choice) throws IllegalArgumentException {
        if (UserInputException.isIllegalChoice(choice)) {
            throw new IllegalArgumentException("잘못된 선택입니다.");
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if(choice.equals("1")){
            return true;
        }
        System.out.println("게임 종료");
        return false;
    }

    public boolean getGameResultOfJudge(List<Integer> result) {
        int ballCount = result.get(0);
        int strikeCount = result.get(1);

        if (strikeCount == END_STRIKE_COUNT) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (ballCount != 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        System.out.println();

        return false;
    }

    private int getRandomIntegerExcludeInList(List<Integer> answer) {
        int number;

        do {
            number = Randoms.pickNumberInRange(1, 9);
        } while (answer.contains(number));

        return number;
    }
}
