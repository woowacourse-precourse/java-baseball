package baseball;

/*
* [O] 랜덤 번호 생성
* [O] 잘못된 입력 예외 처리(어플리케이션 종료)
* [X] 입력된 숫자에 대한 스트라이크/볼/낫싱 판별
* [X] 숫자 반복 입력 기능
* [X] 게임 종료 시 재시작 기능
* [X] 기능별 테스트 작성
* [X] 테스트 확인
*/

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        String userInput = "";
        Integer strike = 0, ball = 0, out = 0;

        initRandomNumber(computer);

        while(strike != 3) {
            userInput = Console.readLine();

            strike = checkStrike(computer, userInput, strike);

            try {
                validateUserInput(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Integer checkStrike(List<Integer> computer, String userInput, Integer strike) {
        for (int idx = 0; idx < userInput.length(); idx++) {
            if(userInput.charAt(idx) - '0' == computer.get(idx)){
                strike++;
            }
        }
        return strike;
    }

    public static void validateUserInput(String s) {
        if(s.length() != 3)
            throw new IllegalArgumentException("자릿수가 모자랍니다.");

        for(int i = 0; i < s.length(); i++){
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                throw new IllegalArgumentException("숫자가 아닌 문자 입력 예외.");
        }
    }

    private static void initRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
