package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static List<Integer> makeNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputNumber() {
        List<Integer> inputNumber = new ArrayList<>();
        String input = new String();
        input = Console.readLine();
        for (int i = 0; i < input.length(); i++) {
            inputNumber.add(input.charAt(i) - '0');
        }
        return inputNumber;
    }

    public static int[] compare(List<Integer> com, List<Integer> user) {
        int strike = 0;
        int ball = 0;
        int[] result = new int[2];
        for (int i = 0; i < com.size(); i++) {
            if (com.get(i) == user.get(i)) {
                strike++;
            }
        }
        if (com.get(0) == user.get(1) || com.get(0) == user.get(2)) {
            ball++;
        }
        if (com.get(1) == user.get(0) || com.get(1) == user.get(2)) {
            ball++;
        }
        if (com.get(2) == user.get(1) || com.get(2) == user.get(0)) {
            ball++;
        }
        if (strike == 3) {
            System.out.printf("%d스트라이크", strike);
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball != 0) {
            System.out.printf("%d볼 ", ball);
        } else if (strike !=0 && ball==0){
            System.out.printf("%d스트라이크",strike);
        }
          else {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
        result[0] = strike;
        result[1] = ball;
        return (result);
    }

    public static void game() {
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        int[] result = new int[2];
        System.out.println("숫자야구 게임을 시작합니다.");
        computer = makeNumber();
        while (true) {
            System.out.println("숫자를 입력해주세요 :");
            user = inputNumber();
            result = compare(computer, user);
            if (result[0] == 3) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int restart=0;
        boolean next = true;
        Scanner sc= new Scanner(System.in);
        while(next){
            game();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요");
            restart = sc.nextInt();
            if(restart==2){
                System.out.println("게임을 종료합니다.");
                next = false;
            }
        }

    }
}