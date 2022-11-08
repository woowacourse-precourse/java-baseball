package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<String> problem = pickNumber();
        boolean notAnswer = true;
        while (notAnswer) {
            String number = Console.readLine();
            System.out.println("숫자를 입력해주세요 : " + number);

            checkError(number);

            List<String> result = getResult(number, problem);

            if (result.get(0) == "Success") {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                reGame();
            }

        }


    }

    /**
     * 숫자를 뽑아주는 함수
     * 입력값을 스트링으로 받기 때문에 여기서 스트링으로 변환
     * @return List<String>
     */
    public static List<String> pickNumber() {
        List<String> baseballNum = new ArrayList<>();
        while (baseballNum.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            // 리스트에 없는 값만 넣기 (중복 제거)
            if (!baseballNum.contains(randomNumber)) {
                baseballNum.add(randomNumber);
            }
        }
        return baseballNum;
    }



    public static void reGame() {

    }


}
