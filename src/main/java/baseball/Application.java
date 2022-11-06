package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Baseball_Game Game = new Baseball_Game();

        Game.start();


    }
}

class Baseball_Game {

    public Baseball_Game() {
        System.out.println("Baseball_Game.Baseball_Game");
        int hidden_number;
        hidden_number = randomThreeDigitNumber();
        System.out.println("hidden_number = " + hidden_number);

    }

    /**
     * 숫자야구게임을 시작한다.
     */
    public void start() {
        System.out.println("Baseball_game.Play_game");
    }

    /**
     * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 반환한다.
     */
    public static int randomThreeDigitNumber() {

        List<Integer> num_list = new ArrayList<>();
        Random random = new Random();
        int result = 0;

        while (num_list.size() < 3) {
            int new_random_number = random.nextInt(10);

            if (isValidRandomNumber(new_random_number, num_list)) {
                num_list.add(new_random_number);
            }
        }
        System.out.println("num_list = " + num_list);

        for (int number : num_list) {
            result = result * 10 + number;
        }

        return result;
    }

    /**
     * List에 들어가기에 적합한 숫자인지 확인한다.
     *
     * @param new_number: int
     * @param list:       list
     * @return boolean
     */
    public static boolean isValidRandomNumber(int new_number, List<Integer> list) {
        if (isZero(new_number)) {
            return false;
        }

        return !isDuplicated(new_number, list);
    }

    /**
     * 새로운 숫자가 list에 중복된 숫자가 있는지 확인한다.
     *
     * @param new_number:int
     * @param list:int
     * @return boolean
     */
    public static boolean isDuplicated(int new_number, List<Integer> list) {

        return list.contains(new_number);
    }

    /**
     * 해당 숫자가 0인지 확인한다.
     *
     * @param number:int
     * @return boolean
     */
    public static boolean isZero(int number) {

        return number == 0;
    }

}