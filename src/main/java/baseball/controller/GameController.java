package baseball.controller;

import java.util.List;

public class GameController {
    private int strike = 0;
    private int ball = 0;

    public void calculateScore(List<Integer> userNumbers, List<Integer> computerNumbers){
        for(int i = 0; i < 3; i++){
            if(userNumbers.get(i).equals(computerNumbers.get(i))){
                strike++;
            }
            else if (computerNumbers.contains(userNumbers.get(i))) {
                ball++;
            }
        }
    }
    public int getStrike(){
        return strike;
    }
    public int getBall(){
        return ball;
    }
    public void resetStrikeAndBall(){
        strike = 0;
        ball = 0;
    }
    public void printScore(){
        StringBuffer sb = new StringBuffer();
        String printScoreResult;

        if(getStrike() == 0 && getBall() == 0){
            sb.append("낫싱");
        }
        if(0 < getBall() && getBall() <= 3){
            sb.append(getBall()).append("볼 ");
        }
        if(0 < getStrike() && getStrike() <= 3){
            sb.append(getStrike()).append("스트라이크 ");
        }

        printScoreResult = sb.toString();
        System.out.println(printScoreResult);

        if(getStrike() == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

}
