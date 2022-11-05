package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    Map<String, Integer> ballAndStrike;
    User user;
    Computer computer;
    boolean restart = false;

    public Game() {
        while(true) {
            initGame();
            playGame();
            playAgain();
        }
    }

    public void initGame() {
        user = new User();
        computer = new Computer();
        computer.setRandomNumber();
        ballAndStrike = new HashMap<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void playGame() {
        boolean again = false;
        while(!again) {
            System.out.print("숫자를 입력해주세요 : ");
            user.input();
            compareNumbers(computer.getRandomNumber() ,user.getInputNumberList());
            again = printResult();
        }
    }

    // 두 수를 비교함.
    public void compareNumbers(List computerNumber, List userNumber){
        int ballCount = 0, strikeCount = 0;
        for(int i = 0; i < userNumber.size(); i++) {
            if(userNumber.get(i) == computerNumber.get(i)) {
                ballAndStrike.put("strike", ++strikeCount);
            } else {
                ballAndStrike.put("ball", ++ballCount);
            }
        }
    }

    public boolean printResult() {
        boolean result = false;
        System.out.println(ballAndStrike.get("ball")+"볼 "+ballAndStrike.get("strike")+"스트라이크");
        if(ballAndStrike.get("strike") == 3) {
            result = true;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return result;
    }

    public boolean playAgain() {
        String result;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        result = Console.readLine();
        if(result == "1") {
            return true;
        } else {
            return false;
        }
    }
}
