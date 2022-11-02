package baseball;

import baseball.util.InputOutput;
import java.util.List;

public class Game extends InputOutput {
    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        do match();
        while(askContinue() == GAME_PLAYING);
        System.out.println("게임 종료");
    }
    public int askContinue(){
        return readState("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void match(){
        Player computer = new Player();
        boolean isThreeStrike;
        do {
            List<Integer> balls = readBall("숫자를 입력해주세요 : ");
            Player user = new Player(balls);
            List<Integer> strikeAndBall = computer.getStrikes(user);
            isThreeStrike = writeStrikes(strikeAndBall);
        } while (!isThreeStrike);
    }
}