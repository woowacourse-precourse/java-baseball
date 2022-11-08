package baseball.Service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    private static final int NUMBER_SIZE=3;
    private static final int RANGE_START=1;
    private static final int RANGE_END=9;
    private static final int RESTART=1;
    private static final int END=2;

    //랜덤 숫자 생성
    public List<String> createRandomNumber(){

        List<String> computerNumber = new ArrayList<>();

        for(int i=0; i<NUMBER_SIZE; i++) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));
            isDuplicate(computerNumber, number);
            computerNumber.add(number);
        }

        return computerNumber;
    }

    //입력받은 숫자의 리스트 크기가 3이 아닐 경우 예외처리
    public void isValidInputSize(List<String> inputNumber) {
        if (inputNumber.size()!=NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

}
