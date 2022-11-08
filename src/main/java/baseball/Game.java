package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Objects;

import static baseball.Number.computerNumber;
import static baseball.Number.userNumber;
import static baseball.Validation.checkAnswer;
import static baseball.Validation.isCorrectType;

public class Game {

    public Game(){}

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean newGame = true;

        while(newGame){
            playGame();
            newGame = restartGame();
        }
    }

    public void playGame(){
        List<Integer> computer = computerNumber();
        boolean isAnswer = false;

        while(!isAnswer){
            List<Integer> user = userNumber();
            isAnswer = checkAnswer(computer, user);
        }
    }

    public static boolean restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String command = Console.readLine();
        isCorrectType("^[1-2]$", command);

        if(Objects.equals(command, "1")){
            return true;
        }
        return false;
    }
    public static String printResult(int ball, int strike){
        StringBuilder sb = new StringBuilder();

        if(ball == 0 && strike == 0){
            sb.append("낫싱");
            return sb.toString();
        }
        if(ball > 0){
            sb.append(ball + "볼");
        }
        if(ball * strike > 0){
            sb.append(" ");
        }
        if(strike > 0){
            sb.append(strike + "스트라이크");
        }

        return sb.toString();
    }
}
