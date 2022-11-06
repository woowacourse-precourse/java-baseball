package baseball;

import baseball.Players.Computer;
import baseball.Players.User;
import baseball.Utils.NumberListComparator;
import baseball.Utils.MessagePrinter;

import java.util.List;

public class Game {

    private final MessagePrinter print;
    private final NumberListComparator comparator;

    private Computer computer;
    private List<Integer> answerNumbers;

    private User user;
    List<Integer> userNumbers;

    private boolean isFirstGame;

    public Game() {
        this.print = new MessagePrinter();
        this.comparator = new NumberListComparator();
        this.computer = new Computer();
        this.user = new User();
        this.isFirstGame = true;
    }

    public void start() {
        if (isFirstGame) {
            print.gameStart();
        }

        print.inputNumbers();

        userNumbers = user.getInputNumbersList();
        answerNumbers = computer.getRandomNumbersList();

        comparator.setAnswerNumberListForComparing(answerNumbers);

        play();
    }

    private void play() {
        boolean isAnswerNumbers = comparator.isAnswerNumbers(userNumbers);
        comparator.compareUserNumbersAndAnswer(userNumbers);

        while (!isAnswerNumbers) {
            print.inputNumbers();
            userNumbers = user.getInputNumbersList();

            isAnswerNumbers = comparator.isAnswerNumbers(userNumbers);
            comparator.compareUserNumbersAndAnswer(userNumbers);
        }

        end();
    }

    private void end() {
        print.gameEnd();

        boolean isContinue = user.isUserWantsNewGame();

        if (isContinue) {
            isFirstGame = false;
            start();
        }
    }
}
