package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class Game {
    public final int RESTART = 1;
    public final int END = 2;

    public void restartGame(int userInputNum) {
        if (userInputNum == RESTART)
            System.out.println("게임시작함수");

        if (userInputNum == END)
            System.out.println("게임종료함수");
    }


    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}


class Computer {
    public List<Integer> NumberList;
    public List<String> result;


    public List<Integer> makeRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public boolean isEqualNumList(List<Integer> userNumList) {
        for (int i = 0; i < 3; i++) {
            if (userNumList.get(i) != NumberList.get(i))
                return false;
        }
        return true;
    }

    public String strikeCheck(int index) {
        return "스트라이크";
    }

    public void printResultAll(Map<String, Integer> result) {
        System.out.println("결과출력");
    }

    public void printResult(List<Integer> userList) {
        Map<String, Integer> result = new HashMap<>();
        result.put("볼", 0);
        result.put("스트라이크", 0);
        result.put("낫싱", 0);

        //각 자리를 보며 결과값을 모음
        for (int i = 0; i < 3; i++) {
            int indexNum = userList.get(i);
            String indexNumResult = strikeCheck(indexNum);
            result.put(indexNumResult, result.get(indexNumResult) + 1);
        }

        // 최종값 합쳐서 출력
        printResultAll(result);
    }
}


public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();



        //game.end();
    }
}
