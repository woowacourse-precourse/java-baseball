package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameManger {
    private List<Integer> computerAnswer;
    public static int strikeCount;
    public static int ballCount;

    public static final int ANSWER = 3;

    public GameManger(){
        computerAnswer = CreateRandomNumber.getComputerAnswer();
    }

    //게임을 시작하는 함수
    public void playBaseballGame(){
        PrintMessage.requestInputMessage();
        List<Integer> userAnswer = CreateUserNumber.userAnswer(Console.readLine());
        ValidCheck.validInputNumber(userAnswer);
        strikeCount = GetGameResult.countStrike(userAnswer, computerAnswer);
        ballCount = GetGameResult.countBall(userAnswer, computerAnswer);
        PrintMessage.ballStrikeMessage(ballCount, strikeCount);
    }

    // 게임이 끝났는지 물어보는 함수
    public boolean isGameEnd(){
        if(strikeCount == ANSWER){
            PrintMessage.resultMessage();
            PrintMessage.askContinueMessage();
            if(ValidCheck.isContinueGame(Console.readLine())){
                computerAnswer = CreateRandomNumber.getComputerAnswer();
                return true;
            }
            return false;
        }
        return true;
    }
}
