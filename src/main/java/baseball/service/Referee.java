package baseball.service;

import java.util.List;

public class Referee {
    /**
     * User와 Computer의 숫자를 비교하여 Strike, Ball 갯수를 구하는 메소드
     * @param computer computer가 생성한 random 수
     * @param user user가 입력한 수
     * @return index : 0 스트라이크 갯수, index : 1 볼 갯수
     */
        public int[] getJudgementCount(List<Integer> computer, List<Integer> user){
        int strike = 0, ball = 0;

        for(int i=0;i<computer.size();i++){
            if(computer.get(i) == user.get(i))
                strike++;
            else if(user.contains(computer.get(i)))
                ball++;
        }
        return new int[]{strike,ball};
    }
}
