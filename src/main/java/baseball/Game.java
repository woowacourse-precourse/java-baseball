package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    Map<String, Integer> ballAndStrike;
    int strikeCount, ballCount;
    User user;
    Computer computer;
    boolean restart = true;

    public Game() {
        while(restart) {
            initGame();
            playGame();
            restart = playAgain();
        }
    }

    public void initGame() {
        user = new User();
        computer = new Computer();
        computer.setRandomNumber();
        ballAndStrike = new HashMap<String, Integer>();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void playGame() {
        boolean again = false;
        while(!again) {
            System.out.print("숫자를 입력해주세요 : ");
            user.input();
            compareNumbers();
            again = printResult();
        }
    }

    // 두 수를 비교함.
    public void compareNumbers(){
        ballCount = 0; strikeCount = 0;
        List userNumber = user.getInputNumberList();
        for(int i = 0; i < userNumber.size(); i++) {
            containsOrEqual(i);
        }
    }

    public void containsOrEqual(int index) {
        List computerNumber = computer.getRandomNumber();
        List userNumber = user.getInputNumberList();
        if(computerNumber.contains(userNumber.get(index))) {
            if(computerNumber.get(index) == userNumber.get(index)){
                ballAndStrike.put("strike", ++strikeCount);
            } else{
                ballAndStrike.put("ball", ++ballCount);
            }
        }
    }

    public boolean printResult() {
        boolean result = false;
        int ball = ballAndStrike.get("ball");
        int strike = ballAndStrike.get("strike");

        if(ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if(strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if(strike == 3) {
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
