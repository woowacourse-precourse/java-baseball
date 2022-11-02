package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameMachine {
    boolean gaming;
    public List<Integer> computer;
    public List<Integer> gamer;

    GameMachine() {
        gaming = false;
        computer = Collections.emptyList();
        gamer = Collections.emptyList();
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> random = new ArrayList<>();
        while(random.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!random.contains(randomNumber)) {
                random.add(randomNumber);
            }
        }

        return random;
    }

    public List<Integer> convertGamerNumber(String input) throws RuntimeException {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> number = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(!('1' <= ch && ch <= '9')) {
                throw new IllegalArgumentException();
            }

            int n = Character.getNumericValue(ch);
            number.add(n);
        }

        return number;
    }

    public boolean restart(String input) throws  RuntimeException {
        if(!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }

        return input.equals("1");
    }

    public List<Integer> strikeAndBall() {
        int strike = 0, ball = 0;

        for(int i = 0; i < 3; i++) {
            if(computer.get(i).equals(gamer.get(i))) {
                strike++;
            }
        }

        for(int i = 0; i < 3; i++) {
            if(computer.contains(gamer.get(i))) {
                ball++;
            }
        }

        ball -= strike;

        return Arrays.asList(strike, ball);
    }

    public boolean keepGoing(int strike, int ball) {
        if(ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if(strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();

        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        return true;
    }

    public void run() {
        while(true) {
            gaming = true;
            computer = generateRandomNumber();
            while (gaming) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                gamer = convertGamerNumber(input);

                List<Integer> sb = strikeAndBall();
                int strike = sb.get(0), ball = sb.get(1);

                gaming = keepGoing(strike, ball);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            if(!restart(input))
                break;
        }
    }
}
