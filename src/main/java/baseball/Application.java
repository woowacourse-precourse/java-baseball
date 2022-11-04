package baseball;

import baseball.domain.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameStart.gameStart();
        RandomBall.makeRandomBalls();

        InputNumber inputNumber = new InputNumber();
        MyBalls myBalls = new MyBalls();

        List<Integer> myBallNumbers;
        while (!GameStart.isWin) {
            myBallNumbers = myBalls.inputBalls(inputNumber.getNumbers());
            ScoreBoard scoreBoard = new ScoreBoard(myBallNumbers);
            scoreBoard.printResult();
            scoreBoard.checkWin();
        }
    }
}
