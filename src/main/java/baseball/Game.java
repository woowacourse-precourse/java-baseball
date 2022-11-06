package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int strike;
    private int ball;

    private List<Integer> comNum;
    private List<Integer> userNum;

    public Game(){
        computerNumbers();
    }

    public void computerNumbers() {
        comNum = new ArrayList<>();
        while (comNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNum.contains(randomNumber)) {
                comNum.add(randomNumber);
            }
        }
    }


    public void playGame() {
        System.out.println("숫자를 입력해주세요 : ");
        userNum = User.userInputNumber();
        cnt_StrikeOrBall();
        System.out.println(strike_ball_nothing_Message());
    }



    public void cnt_StrikeOrBall() {
        this.strike = 0;
        this.ball = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if (comNum.indexOf(userNum.get(i)) == i) {
                strike++;
                continue;
            }
            if (comNum.contains(userNum.get(i))) {
                ball++;
            }
        }
    }

    public String strike_ball_nothing_Message() {
        String message;
        if (strike != 0 && ball == 0) {
            message = (strike + "스트라이크");
            return message;
        }
        else if (strike == 0 && ball !=0 ) {
            message = (ball + "볼");
            return message;
        }
        else if (strike != 0 && ball !=0) {
            message = (ball + "볼 " + strike +"스트라이크");
            return message;
        }
        else {
            message = ("낫싱");
            return message;
        }
    }

    public boolean restartOrEnd() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

            String answer = Console.readLine();
            if (answer.equals("1")) {
                computerNumbers();
                return true;
            }
            else if (answer.equals("2")) {
                return false;
            }
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 1 또는 2를 입력해주세요");
        }
        return true;
    }

}
