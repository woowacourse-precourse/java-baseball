package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    public static List<Integer> getRandomNumbers(){
        List<Integer> gameNumbers = new ArrayList<>();
        while (gameNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!gameNumbers.contains(randomNumber)) {
                gameNumbers.add(randomNumber);
            }
        }
        return gameNumbers;
    }

    public static List<Integer> getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        try{
            int input = Integer.parseInt(Console.readLine());
            if (input < 100 || input > 999) {
                throw new IllegalArgumentException("프로그램 종료: 올바른 입력이 아닙니다.");
            }

            List<Integer> userNumbers = new ArrayList<>();
            for(int i = 0; i < 3; i ++){
                int temp = input % 10;
                if (userNumbers.contains(temp)) {
                    throw new IllegalArgumentException("프로그램 종료: 올바른 입력이 아닙니다.");
                }
                userNumbers.add(0, input % 10);
                input = input / 10;
            }
            return userNumbers;
        } catch (Exception e)  {
            throw new IllegalArgumentException("프로그램 종료: 올바른 입력이 아닙니다.");
        }
    }

    public static List<Integer> getCounts(List<Integer> gameNumbers, List<Integer> userNumbers) {
        List<Integer> counts = new ArrayList<>();
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i ++){
            if (gameNumbers.get(i) == userNumbers.get(i)) {
                strike += 1;
            } else if (userNumbers.contains(gameNumbers.get(i))) {
                ball += 1;
            }
        }

        counts.add(ball);
        counts.add(strike);
        return counts;
    }
}
