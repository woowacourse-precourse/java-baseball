package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    Map<String, Integer> ballAndStrike;
    User user;
    Computer computer;

    public Game() {
        while(true) {
            initGame();
            playGame();
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


}
