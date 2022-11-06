package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = randomPick();
        answer(computer);
    }

    /*1.랜덤으로 컴퓨터가 임의의 값 선택.*/
    public static List<Integer> randomPick() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }

    /*2. 게임 플레이어가 입력한 숫자 받기*/
    public static List<Integer> inputNumber() {
        Scanner scan = new Scanner(System.in);
        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String strNumber = scan.next();

        for (String chr : strNumber.split("")) {
            user.add(Integer.parseInt(chr));
        }
        return user;
    }

    /*3. 컴퓨터와 입력숫자를 비교해서 스트라이크 판정 int로 반환*/
    public static int strike(List<Integer> user, List<Integer> computer) {
        int countStrike = 0;
        for (int i = 0; i < 3; i++) {
            if (user.get(i).equals(computer.get(i))) {
                countStrike++;
            }
        }
        return countStrike;
    }

    /*4. 컴퓨터와 입력숫자를 비교해서 볼 판정 int로 반환*/
    public static int ball(List<Integer> user, List<Integer> computer) {
        int countBall = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i))) {
                countBall++;
            }
            if (user.get(i).equals(computer.get(i))) {
                countBall--;
            }
        }
        return countBall;
    }

    /*5. 결과 두개 합쳐서 출력하는 메서드*/
    public static String counting(int countStrike, int countBall) {
        if (countStrike == 0 && countBall == 0) {
            return "낫싱";
        } else if (countStrike == 3) {
            return "3스트라이크";
        } else {
            String result = Integer.toString(countBall) + "볼 " + Integer.toString(countStrike)+"스트라이크";
            return result;
        }
    }

    /*6. 시작문구 입력, 새로시작 및 종료 메서드*/
    public static void answer(List<Integer> computer) {
        List<Integer> user = inputNumber();
        /*예외처리: 세자리가 아닐때 같은 숫자가 있을때*/
        if (user.get(0).equals(user.get(1)) ||user.get(0).equals(user.get(2))||user.get(1).equals(user.get(2))) {
//            System.out.println("중복 숫자를 입력하지 마세요");
//            user = inputNumber();
            throw new IllegalArgumentException();
        }
        if (!(user.size() == 3)) {
//            System.out.println("세자리 숫자를 입력해주세요");
//            user = inputNumber();
            throw new IllegalArgumentException();
        }
        int countStrike = strike(user, computer);
        int countBall = ball(user, computer);
        String counting = counting(countStrike, countBall);
        System.out.println(counting);
        if (counting.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            int game = scanner.nextInt();
            if (game == 1) {
                List<Integer> computerNext = randomPick();
                answer(computerNext);
            }
        } else {
            answer(computer);
        }
    }
}
