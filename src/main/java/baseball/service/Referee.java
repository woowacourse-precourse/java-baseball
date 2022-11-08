package baseball.service;

import java.util.List;

import static baseball.constant.constants.*;

public class Referee {
    /**
     * User와 Computer의 숫자를 비교하여 Strike, Ball 갯수를 구하는 메소드
     * @param computer computer가 생성한 random 수
     * @param user user가 입력한 수
     * @return index : 0 스트라이크 갯수, index : 1 볼 갯수
     */
    public int[] getJudgementCount(List<Integer> computer, List<Integer> user){
        int strike = 0, ball = 0;

        for(int i=0;i<NUMBER_LIMIT_LENGTH;i++){
            if(computer.get(i) == user.get(i)) {
                strike++;
            }else if(user.contains(computer.get(i))) {
                ball++;
            }
        }
        return new int[]{strike,ball};
    }

    /**
     * Strike와 Ball의 갯수에 따라 출력 String을 만드는 메소드
     * @param count strike와 ball의 갯수를 가지고 있는 배열
     * @return 볼의 갯수에 따라 스트라이크, 볼, 낫싱을 가진 String
     */
    public String printStrikeAndBall(int[] count){
        int strike = count[0];
        int ball = count[1];

        if(strike == 0 && ball == 0) {
            return NOTHING;
        }
        if(strike == 0 && ball != 0) {
            return ball + BALL;
        }
        if(strike != 0 && ball == 0) {
            return strike + STRIKE;
        }
        return ball + BALL + " " + strike + STRIKE;
    }
}
