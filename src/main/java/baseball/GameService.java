package baseball;

import java.util.List;

public class GameService {
    private static final int NUMBER_LENGTH = 3;
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String ALL_STRIKE_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_STRIKE_MESSAGE = "낫싱\n";
    private static final String STRIKE_MESSAGE = "%d스트라이크\n";
    private static final String BALL_MESSAGE = "%d볼\n";

    private int ball;
    private int strike;

    public void getPlayResult(List<Integer> userNumber, List<Integer> answer){
        initBallAndStrike();
        for(int digit = 0; digit < NUMBER_LENGTH; digit++){
            if(answer.contains(userNumber.get(digit))){
                ball++;
            }
            if(answer.get(digit) == userNumber.get(digit)){
                ball--;
                strike++;
            }
        }
    }

    public void initBallAndStrike(){
        this.ball = 0;
        this.strike = 0;
    }
}
