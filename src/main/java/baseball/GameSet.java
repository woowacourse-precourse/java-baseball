package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameSet {
    private List<Integer> computerAnswer;
    private List<Integer> userAnswer;
    public static int strikeCount;
    public static int ballCount;

    public GameSet(){
        computerAnswer = CreateRandomNumber.setComputerAnswer();
    }

    //게임을 시작하는 함수
    public void playBaseballGame(){
        PrintMessage.inputMessage();
        System.out.println(computerAnswer);
        userAnswer = CreateUserNumber.userAnswer(Console.readLine());
        ValidCheck.validInputNumber(userAnswer);
        compareAnswer();
        PrintMessage.ballStrikeMessage(ballCount, strikeCount);
    }

    // 볼과 스트라이크 갯수를 세어주는 함수
    public void compareAnswer(){
        strikeCount = 0;
        ballCount = 0;
        for(int i = 0; i < userAnswer.size(); i++){
            if(computerAnswer.indexOf(userAnswer.get(i)) == i){
                strikeCount++;
                continue;
            }
            if(computerAnswer.contains(userAnswer.get(i))){
                ballCount++;
            }
        }
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
