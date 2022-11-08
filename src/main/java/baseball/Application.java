package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        start();
    }

    public static void start() {
        List<Integer> computerNumber = randomNumber();

        boolean run = true;

        while (run) {
            System.out.print("숫자를 입력해주세요 : ");
            String numbers = Console.readLine();

            isThree(numbers);
            hasDuplicate(numbers);

            List<Integer> playerNumber = player(numbers);

        }
    }

    public static List<Integer> randomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static void isThree(String numbers) throws IllegalArgumentException {
        if(numbers.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void hasDuplicate(String numbers) throws IllegalArgumentException {
        if (numbers.charAt(0) == numbers.charAt(1)
                || numbers.charAt(0) == numbers.charAt(2)
                || numbers.charAt(1) == numbers.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> player(String numbers) throws IllegalArgumentException {
        String[] split = numbers.split("");

        List<Integer> player = new ArrayList<>();

        for(int i=0; i<numbers.length(); i++) {
            try {
                Integer number = Integer.parseInt(split[i]);
                player.add(number);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }

        return player;
    }

}
