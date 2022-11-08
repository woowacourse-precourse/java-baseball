package baseball;

import baseball.Domain.ValidInputNumber;
import baseball.Domain.baseballSystem;
import baseball.Domain.computerAnswerNumberGenerator;
import baseball.Util.ValidHandler;
import baseball.View.inputView;
import baseball.View.outputView;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        do {
            List<Integer> computerAnswerNumber = setAnswerNumberList();
            startNewGame(computerAnswerNumber);
        } while(startOrQuit());
    }

    private static void startNewGame(List<Integer> answerNumberList) {
        List<Integer> userNumberList = setUserNumberList();
        baseballSystem baseballSystem = new baseballSystem(userNumberList, answerNumberList);

        if(!baseballSystem.isWinTheGame()) {
            printResult(baseballSystem);
            startNewGame(answerNumberList);
        }
        outputView.printWinMessage();
    }
    private static List<Integer> setAnswerNumberList() {
        computerAnswerNumberGenerator computerAnswerNumberGenerator = new computerAnswerNumberGenerator();
        return computerAnswerNumberGenerator.getAnswerNumberList();
    }

    private static List<Integer> setUserNumberList() {
        String userAnswerString = inputView.getUserAnswer();
        ValidInputNumber validInputNumber = new ValidInputNumber(userAnswerString);
        if(!validInputNumber.setIsValidString()) {
            throw new IllegalArgumentException("입력 오류");
        }
        return ValidHandler.addList(userAnswerString);

    }

    private static void printResult(baseballSystem baseballSystem) {
        if(baseballSystem.isNothingInNumber()) {
            outputView.printNothing();
            return;
        }
        outputView.printBallAndStrike(baseballSystem.getStrikeNumber(), baseballSystem.getBallNumber());

    }

    private static boolean startOrQuit() {
        final int NEW_GAME = 1;
        final int QUIT = 2;

        int userInputStartOrQuit = Integer.parseInt(inputView.getRestartOrQuit());
        if(userInputStartOrQuit != NEW_GAME && userInputStartOrQuit != QUIT) {
            throw new IllegalArgumentException("입력 오류");
        }
        return userInputStartOrQuit == NEW_GAME;
    }
}
