package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class GameStatusView {

    private static final String END_GAME_COMMAND = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_OPINION_COMMAND = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String WRONG_ANSWER_ALERT = "잘못된 입력입니다.";
    private static final String FINISH_COMMAND = "게임 종료";
    private static final String MORE_GAME_NUMBER = "1";
    private static final String END_GAME_NUMBER = "2";
    String opinion;

    public GameStatusView(){
        opinion = "";
    }

    public String inquireOpinion(){
        while(isNotCorrectAnswer()){
            askOpinion();
            readOpinion();
            checkAlert();
        }
        return getOpinion();
    }

    public void askOpinion(){
        System.out.println(END_GAME_COMMAND);
        System.out.println(ASK_OPINION_COMMAND);
    }

    public void readOpinion(){
        opinion = Console.readLine();
    }

    public boolean isNotCorrectAnswer(){
        return !opinion.equals(MORE_GAME_NUMBER) && !opinion.equals(END_GAME_NUMBER);
    }

    public void alertWrongAnswer(){
        System.out.println(WRONG_ANSWER_ALERT);
    }

    public void checkAlert(){
        if(isNotCorrectAnswer())alertWrongAnswer();
    }

    public String getOpinion(){
        return opinion;
    }

    public void printTheEnd(){
        System.out.println(FINISH_COMMAND);
    }
}
