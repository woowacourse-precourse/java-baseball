package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //랜덤한 숫자 3개 뽑기

        List<String> computerNumber = new ArrayList<>();

        for(int i=0; i<3; i++) {
            computerNumber.add(Integer.toString(Randoms.pickNumberInRange(1, 9)));
        }

        //사용자에게 숫자 입력받기
        String readNumber = Console.readLine();

        String[] numberToArray = readNumber.split("");
        List<String> userNumber = new ArrayList<String>(Arrays.asList(numberToArray));



    }
}
