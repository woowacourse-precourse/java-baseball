package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Computer {
    private int strikeCount = 0;
    private int ballCount = 0;
    private Number numFactory;
    private List<Integer> computerNumber;
    public Computer() {
        numFactory = new ComputerNum();
        computerNumber = numFactory.createNumber();
        numFactory.verifyNumber(computerNumber);
    }

    public void calculateCount(int i, List<Integer> playerNumber) {
        if (computerNumber.contains(playerNumber.get(i))) {
            if (computerNumber.indexOf(playerNumber.get(i)) == i)
                strikeCount++;
            else
                ballCount++;
        }
    }

    public String getResult(List<Integer> playerNumber) {
        resetCount();
        for (int i = 0; i < 3; i++) {
            calculateCount(i, playerNumber);
        }

        if (strikeCount == 3) {
            System.out.println(GameComment.THREE_STRIKE);
            System.out.println(GameComment.GAME_END_MSG);
            return closeGame();
        } else if (ballCount < 1 && strikeCount < 1) {
            System.out.println(GameComment.NOTHING);
        }else if (strikeCount < 1){
            System.out.println(ballCount + GameComment.BALL);
        }else if (ballCount < 1) {
            System.out.println(strikeCount + GameComment.STRIKE);
        }else {
            System.out.println(ballCount + GameComment.BALL + " " + strikeCount + GameComment.STRIKE);
        }
        return GameComment.NOT_GAME_END;
    }

    public String closeGame() {
        System.out.print(GameComment.RESTART_MSG);
        String input = Console.readLine();
        return getStatusByInput(input);
    }

    public String getStatusByInput(String input) {
        if (input.equals("1")) {
            return GameComment.RESTART;
        } else if (input.equals("2"))
            return GameComment.TERMINATE;
        else
            throw new IllegalArgumentException();
    }


    public void resetCount() {
        strikeCount = 0;
        ballCount = 0;
    }

}
