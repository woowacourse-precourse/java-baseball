package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    //랜덤 값을 출력하는 함수 작성
    public static ArrayList<Integer> createRandomNumber(){
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!randomNumbers.contains(randomNumber)){
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

    }
}
