package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.CheckBall.ball;
import static baseball.CheckInput.make_error;
import static baseball.CheckStrike.strike;
import static baseball.MakeComputerNumber.make_computer_number;
import static baseball.PrintScore.print_score;

public class GameController {
    private GameController(){
    }
    public static void gameController(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<String> computer = make_computer_number();
        int strike = 0;
        int ball = 0;
        while (true){
            System.out.println("숫자를 입력해주세요 : " );
            String ans = Console.readLine();
            if(ans.equals("1")){
                computer = make_computer_number();
                continue;
            }
            else if(ans.equals("2")){
                return;
            }
            else{
                make_error(ans);
            }
            strike = strike(ans,computer);
            ball = ball(ans,computer);
            print_score(strike,ball);
        }
    }
}
