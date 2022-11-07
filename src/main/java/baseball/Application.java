package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int strike=0;
        int matchCount=0;

        //랜덤한 숫자 3개 뽑기

        List<String> computerNumber = new ArrayList<>();

        for(int i=0; i<3; i++) {
            computerNumber.add(Integer.toString(Randoms.pickNumberInRange(1, 9)));
        }

        //사용자에게 숫자 입력받기
        String readNumber = Console.readLine();

        String[] numberToArray = readNumber.split("");
        List<String> userNumber = new ArrayList<String>(Arrays.asList(numberToArray));

        //스트라이크, 볼, 낫싱 판정
        for(String number: userNumber) {
            if(computerNumber.contains(number)) {
                if(computerNumber.indexOf(number)==userNumber.indexOf(number)) {
                    strike+=1;
                }
                matchCount+=1;
            }
        }

        if (matchCount==0) {
            System.out.println("낫싱");
        } else {
            int ball = matchCount - strike;
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }

        


    }
}
