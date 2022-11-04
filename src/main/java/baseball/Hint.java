package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Hint {
    /**
     * Compare user input with game instance's randomNum and calculate result
     * @param userInput 사용자가 입력한 값
     * @return resultList 볼과 스트라이크의 개수가 차례대로 담긴 리스트
     */
    static List<Integer> result(List<Integer> userInput, Game game) {
        List<Integer> resultList = new ArrayList<>(Arrays.asList(0, 0));
        int ballCount = 0;
        for (int i = 0; i < game.getRandomNum().size(); i++) {
            if (Objects.equals(game.getRandomNum().get(i), userInput.get(i)))
                resultList.set(1, resultList.get(1) + 1);
            else {
                ballCount += checkBall(userInput.get(i), game.getRandomNum());
            }
        }
        resultList.set(0, ballCount);
        return resultList;
    }

    /**
     * Check whether certain digit exists in game instance's randomNum
     * @param digit 사용자가 입력한 값 중 하나
     * @param answer game 인스턴스의 randomNum
     * @return 포함하고 있으면 1, 아니면 0
     */
    static int checkBall(Integer digit, List<Integer> answer) {
        if(answer.contains(digit))
            return 1;
        return 0;
    }

    /**
     * Print result for user's input
     * @param resultList result() 함수로 반환받은 볼과 스트라이크의 개수가 들어있는 리스트
     * @see Hint#result(List, Game)
     */

    static void printResult(List<Integer> resultList) {
        int ball = resultList.get(0);
        int strike = resultList.get(1);
        if (ball == 0 && strike == 0)
            System.out.println("낫싱");
        else if (ball == 0 || strike == 0) {
            if (resultList.indexOf(Integer.max(ball, strike)) == 0)
                System.out.println(ball + "볼");
            else
                System.out.println(strike + "스트라이크");
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
