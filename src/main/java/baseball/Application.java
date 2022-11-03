package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    //잘못된 입력을 받을 경우
    public static void IllegalInput(int input) {
        //입력이 3자리의 숫자가 아님
        if(String.valueOf(input).length()!=3){
            throw new IllegalArgumentException("올바른 값을 입력해주세요.");
        }
    }

    //랜덤값을 추출
    public static List<Integer> RandomNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void main(String[] args) {
        System.out.print("숫자 야구 게임을 시작합니다.");

    }
}
