package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputMapping inputMapping = new InputMapping();
        GameString gameString = new GameString();

        int flag = 1;
        while (flag == 1){
            RandomNumber randomNumber = new RandomNumber();
            System.out.println(randomNumber.getRandomNumberList());
            int numberOfStrike = 0;
            int numberOfBall;
            while (numberOfStrike < 3) {
                System.out.print(gameString.getInputComment());
                List<Integer> userNumberList = inputMapping.getGameNumberList();

                numberOfStrike = randomNumber.getNumberOfStrike(userNumberList);
                numberOfBall = randomNumber.getNumberOfBall(userNumberList) - numberOfStrike;
                System.out.println(gameString.getPlayingString(numberOfStrike, numberOfBall));
            }
            System.out.println(gameString.getCorrectComment());
            System.out.println(gameString.getRestartComment());
            flag = inputMapping.getRestartFlag();
        }
        // TODO: 프로그램 구현
    }
}
