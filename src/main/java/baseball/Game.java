package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void startGame(GameException gameException) {
        Computer computer = new Computer();

        boolean endPoint = true;

        while (endPoint) {
            System.out.println("숫자를 입력해주세요 : ");
            String inputNum = Console.readLine();

            gameException.inputException(inputNum);


            endPoint = checkEndPoint(computer, inputNum);
        }

        endGame(gameException);
    }

    private void endGame(GameException gameException) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int startOrEnd = Integer.parseInt(Console.readLine());

        gameException.restartException(startOrEnd);

        if (startOrEnd == 1) {
            startGame(gameException);
        }
    }

    private boolean checkEndPoint(Computer computer, String inputNum) {
        System.out.println(computer.getScore(inputNum));

        if (computer.countStrike(inputNum) == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        return true;
    }


}
