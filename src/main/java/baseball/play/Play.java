package baseball.play;

import baseball.computer.computerNumber;
import baseball.user.userNumber;

import java.util.List;

import static baseball.play.isContinue.iscontinue;

/*
 * Class : baseball
 *
 * 버전 정보 0.0.1
 *
 * 날짜 22.11.06
 *
 */
public class Play {
    private static final List<Integer> PLAYING = List.of(0);

    /* -------------------------------------------*/


    public static List<Integer> play(computerNumber computer , userNumber user) {

        user.inputUser();
        Result result = new Result();
        result.init();
        result.setSolutions(computer);

        for(int i = 0 ; i < 3 ; i++){
            result.countStrike(computer,user,i);
        }

        result.print();

        if(result.gameWin()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려먼 2를입력하세요.");
            return iscontinue(result);
        }

        return PLAYING;
    }


}
