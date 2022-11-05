package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        BullsAndCows bullsAndCows = new BullsAndCows();

        while (true) {
            String input = Console.readLine();
            if(bullsAndCows.isEnd()) {

                if(input.equals("1")) {
                    bullsAndCows.restart();
                }

                if(input.equals("2")) {
                    System.out.println("게임 종료");
                    break;
                }

            }

            System.out.println(bullsAndCows.getResultOfGuessNumber(input));
        }
    }
}
