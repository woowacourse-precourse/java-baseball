package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");

        int start = 1;
        // 2가 나올 때까지 게임 시작
        while (start == 1) {
            // 게임진행
            List<Integer> listComputer = randomNum();

            int correct = 0;
            while (correct != 1) {
                System.out.print("숫자를 입력해주세요 : ");
                int answer = sc.nextInt();
                err(answer);
                List<Integer> listAnswer = makeList(answer);
                correct = check(listComputer, listAnswer);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restart = sc.nextInt();
            start = restart;
        }
    }

    // 3자리 난수 리스트 생성
    public static List<Integer> randomNum() {
        List<Integer> listComputer = new ArrayList<>();
        while (listComputer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!listComputer.contains(randomNumber)) {
                listComputer.add(randomNumber);
            }
        }
        return listComputer;
    }

    // 리스트 생성
    public static List<Integer> makeList(int num) {
        List<Integer> list = new ArrayList<>();
        list.add(num / 100);
        list.add((num % 100) / 10);
        list.add(num % 10);
        return list;
    }

    // 예외처리
    public static void err(int num) {
        if (num / 1000 > 0 || num / 100 == 0) {
            throw new IllegalArgumentException();
        }
    }

    // 입력 결과 확인
    public static int check(List<Integer> listComputer, List<Integer> listAnswer) {
        int correct = 0;
        int ball = 0;
        int strike = 0;
        // 볼 판단
        for (int i = 0; i < 3; i++) {
            if (listAnswer.contains(listComputer.get(i))) {
                ball++;
            }
        }
        if (ball == 0) {
            System.out.println("낫싱");
            return correct;
        }
        // 스트라이크 판단
        for (int i = 0; i < 3; i++) {
            if (listComputer.get(i) == listAnswer.get(i)) {
                ball--;
                strike++;
            }
        }

        if (strike == 0) {
            // 볼만 있을 때
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            // 스트라이크만 있을 때
            System.out.println(strike + "스트라이크");
            // 3스트라이크 == 정답일 떼
            if (strike == 3) {
                correct = 1;
            }
        } else {
            // 볼과 스트라이크 모두 있을 때
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return correct;
    }
}
