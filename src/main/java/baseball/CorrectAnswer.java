package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CorrectAnswer {
    List<Integer> randomNumberList = new ArrayList<>();
    /**
     * 정답 배열과 비교
     *
     * @param number 입력된 수
     * @param index 해당 수의 위치
     * @return 0: 불일치, 1: 볼, 2: 스트라이크
     * */
    public int batPitchedBall(int number, int index) {
        int strike = 0, ball = 0;
        if(randomNumberList.get(index) == number)return 2;
        if(randomNumberList.contains(number))return 1;
        //비교 후 결과를 출력한다.
        //3스트라이크면 true 아니면 false 반환
        return 0;
    }

    /**
     * 랜덤한 1~9의 중복없는 3자리 수를 생성합니다.
     *
     */
    public CorrectAnswer() {
        //랜덤 숫자 생성 후 리스트에 추가합니다.
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while(randomNumber > 0){
            randomNumberList.add(randomNumber%10);
            randomNumber/=10;
        }
    }
}
