package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CorrectAnswer {
    List<Integer> randomNumberList = new ArrayList<>();
    List<Boolean> isAlreadyExists = new ArrayList<>(9);
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
     * 1~9사이의 수가 이미 존재하는지 체크합니다
     * @param number 1~9사이의 수
     * @return 중복여부
     */
    private boolean isExists(int number){
        return isAlreadyExists.get(number);
    }

    /**
     * 1~9중 isAlreadyExists에 체크되지 않는 숫자를 반환합니다.
     * @return 1~9사이의 한자리 수
     */
    private int generateRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (isExists(randomNumber))
            randomNumber = Randoms.pickNumberInRange(1, 9);
        return randomNumber;
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
