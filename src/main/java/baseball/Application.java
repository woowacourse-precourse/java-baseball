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

    /**
     * 입력값에 맞는 결과를 반환해주는 함수
     * Strike, Ball 을 기본으로 List에 담아 return함
     * 만약 Strike와 Ball이 없다면 Not을 3Strike라면 Success를 반환
     * @param number
     * @param problem
     * @return
     */
    public static List<String> getResult(String number, List<String> problem) {
        List<String> result = new ArrayList<>();

        int s = 0;
        int b = 0;

        for (int i = 0; i < 3; i++) {
            String value = String.valueOf(number.charAt(i));
            // Strike, Ball 판별
            if (problem.contains(value) && problem.get(i) == value) {
                s++;
            } else if (problem.contains(value)) {
                b++;
            }

            // Strike, Ball의 수에 따라 Return할 결과 저장
            if (s == 3) {
                result.add("Success");
            } else if (s == 0 && b == 0) {
                result.add("Not");
            } else {
                result.add(String.valueOf(s));
                result.add(String.valueOf(b));
            }
        }

        return result;
    }



    public static void reGame() {

    }


}
