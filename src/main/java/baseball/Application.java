package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
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

            if (result.get(0).equals("Success")) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                notAnswer = reGame();
                // notAnswer이 false라면 problem이 변해도 while문이 돌지 않음
                problem = pickNumber();

            } else if (result.get(0).equals("Not")){
                System.out.println("낫싱");

            } else if (result.get(0).equals("0")){
                String b = result.get(1);
                System.out.println(String.format("%s볼",b));

            } else if (result.get(1).equals("0")) {
                String s = result.get(0);
                System.out.println(String.format("%s스트라이크",s));

            } else {
                String s = result.get(0);
                String b = result.get(1);
                System.out.println(String.format("%s볼 %s스트라이크",b,s));
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

        Integer s = 0;
        Integer b = 0;

        for (int i = 0; i < 3; i++) {
            String value = String.valueOf(number.charAt(i));
            // Strike, Ball 판별
            if (problem.contains(value) && problem.get(i).equals(value)) {
                s += 1;
            } else if (problem.contains(value)) {
                b += 1;
            }
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
        return result;
    }

    /**
     * 에러 체크해서 에러면 IllegalArgumentException을 터뜨리는 함수
     * 입력값이 3글자가 아닐 때
     * 숫자로 변환가능한 문자열이 아닐때,
     * 중복된 수가 있을 때 에러가 터짐
     * @param number
     */
    public static void checkError(String number) {
        // number의 길이가 3이면 패스 아니라면 에러 발생
        // 띄워쓰기의 경우는 제거해서 편하게 해주자
        if (number.trim().length()==3) {}
        else {
            System.out.println("세 자리 수만 입력 가능합니다.");
            throw new IllegalArgumentException();
        }

        // 같은 값이 있는 지 확인할 List
        List<String> check = new ArrayList<>();

        // for문을 돌아서 숫자로 변환 가능한 문자열인지,
        // 동일한 값을 가지지 않은 문자열인지 확인
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException();
            } else if (check.contains(String.valueOf(number.charAt(i)))) {
                System.out.println("서로 다른 숫자만 입력 가능합니다.");
                throw  new IllegalArgumentException();
            } else if (!check.contains(String.valueOf(number.charAt(i)))) {
                check.add(String.valueOf(number.charAt(i)));
            }
        }
    }

    /**
     * 재시작 여부를 확인하는 함수
     * 재시작한다면 true를 반환하고 끝낸다면 false를 반환하여 notAnswer에 재할당
     * @return boolean
     */
    public static boolean reGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        System.out.println(restart);
        if (restart.equals("1")) {
            return true;
        } else if (restart.equals("2")) {
            return false;
        } else {
            // 호옥시... 다른 숫자가 나온다면 에러내기
            System.out.println("1과 2만 입력 가능합니다.");
            throw new IllegalArgumentException();
        }
    }


}
