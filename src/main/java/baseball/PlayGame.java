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
                throw new IllegalArgumentException("게임종료: 숫자의 갯수가 3개가 아닙니다.");
            }

            List<Integer> userNumbers = new ArrayList<>();

            for(int i = 0; i < 3; i ++){
                userNumbers.add(0, input % 10);
                input = input / 10;
            }
            return userNumbers;

        } catch (IllegalArgumentException e)  {
            throw new IllegalArgumentException("게임종료: 입력이 숫자가 아닙니다.");
        }
    }
}
