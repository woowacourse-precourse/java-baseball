package baseball;

import baseball.logic.Exception;
import baseball.logic.Generatenumber;
import baseball.logic.Inputnumber;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private int strike;
    private int ball;
    private List<Integer> playerInput;
    private List<Integer> computerOutput;

    private final Generatenumber computerNum;
    private final Inputnumber playerNum;
    private final Exception exception;


    public BaseballGame() {
        strike = 0;
        ball = 0;
        playerInput = new ArrayList<>();
        computerOutput = new ArrayList<>();
        computerNum = new Generatenumber();
        playerNum = new Inputnumber();
        exception = new Exception();
    }

    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerOutput = computerNum.getNum();
        do {
            playerInput = exception.inputException(playerNum.inputNum());
            strike=0;
            ball=0;
            cntScore();
            messageHint();
        }while(!(strike==3));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void cntScore(){
        cntStrike(playerInput, computerOutput);
        cntBall(playerInput, computerOutput);
    }

    public void messageHint(){
        if(strike>0){
            System.out.println(strike + "스트라이크");
        }
        if(ball>0){
            System.out.println(ball + "볼");
        }
        if(strike==0 && ball==0){
            System.out.println("낫싱");
        }
        System.out.println();
    }

    public int cntStrike(List<Integer> player, List<Integer> computer){
        for(int i=0; i<player.size(); i++) {
            if(player.get(i)==computer.get(i)){
                strike++;
            }
        }
        return strike;
    }

    public int cntBall(List<Integer> player, List<Integer> computer){
        for(int i=0; i<player.size(); i++){
            if(computer.contains(player.get(i)) && computer.get(i)!=player.get(i)){
                ball++;
            }
        }
        return ball;
    }
}
