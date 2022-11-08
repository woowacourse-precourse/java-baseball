package baseball.service;

import baseball.utils.PrintMessage;
import baseball.utils.RandomNumber;
import camp.nextstep.edu.missionutils.Console;
import domain.Game;
import domain.User;


public class GameService {

    PrintMessage print = new PrintMessage();
    RandomNumber computer = new RandomNumber();
    Game game;
    User user = new User();
    InGame inGame = new InGame();


    public void playGame() {
        game = new Game(computer.getRandomNumber());
        int strike = 0;
        while (strike != 3) {
            print.inputRequest();
            play();
            print.status(game.getBall(), game.getStrike());
            strike = game.getStrike();
        }
    }

    private void play() {
        game.initStrike();
        game.initBall();
        int[] userNumbers = getUserNumbers();
        user.setUserNumber(userNumbers);
        getScore();
    }
    private int[] getUserNumbers() throws IllegalArgumentException{
        String input = Console.readLine();

        return inGame.userInputToInt(input);
    }

    private void getScore() {
        for (int i = 0; i < 3; i++) {
            scoreCalculate(game.getComputerNumber(), user.getUserNumber(), i);
        }
    }

    private void scoreCalculate(int[] computerNumber, int[] userNumber, int index) {
        int temp = -1;
        for (int i = 0; i < computerNumber.length; i++) {
            if (computerNumber[i] == userNumber[index]) {
                temp = i;
                break;
            }
        }
        increaseCount(index, temp);
    }

    private void increaseCount(int index, int temp) {
        if (temp != index && temp != -1) {
            game.increaseBall();
        }
        if (temp == index) {
            game.increaseStrike();
        }
    }

}
