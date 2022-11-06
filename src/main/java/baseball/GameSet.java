package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameSet {
    private List<Integer> computerAnswer;
    public static int strikeCount;
    public static int ballCount;

    public GameSet(){
        computerAnswer = CreateRandomNumber.setComputerAnswer();
    }

    //게임을 시작하는 함수
    public void playBaseballGame(){
        PrintMessage.inputMessage();
        List<Integer> userAnswer = CreateUserNumber.userAnswer(Console.readLine());
        ValidCheck.validInputNumber(userAnswer);
        strikeCount = GetGameResult.countStrike(userAnswer, computerAnswer);
        ballCount = GetGameResult.countBall(userAnswer, computerAnswer);
        PrintMessage.ballStrikeMessage(ballCount, strikeCount);
    }

    // 게임이 끝났는지 물어보는 함수
    public boolean isGameEnd(){
        if(strikeCount == 3){
            PrintMessage.answerMessage();
            PrintMessage.gameContinueMessage();
            if(ValidCheck.isValidPress(Console.readLine())){
                computerAnswer = CreateRandomNumber.setComputerAnswer();
                return true;
            }
            return false;
        }
        return true;
    }
}
