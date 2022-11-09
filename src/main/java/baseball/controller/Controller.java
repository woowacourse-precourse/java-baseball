package baseball.controller;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.User;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Controller {
    private Computer computer;
    private User user;
    private View view;
    private Game game;

    public Controller(Computer computer, User user, Game game, View view){
        this.computer = computer;
        this.user = user;
        this.game = game;
        this.view = view;
    }

    public void runGame(){
        view.printGameStart();
        while (getGameState() == Game.GameState.RUNNING){
            String userInput = Console.readLine();
            setUserNumeralList(toList(userInput));
            judge();
        }
    }

    public void judge(){
        countBall();
        countStrike();
        printJudgement();
        beatGame();
    }

    private Game.GameState getGameState(){
        return game.getGameState();
    }

    private void setGameState(Game.GameState state){
        game.setGameState(state);
    }

    private void setUserNumeralList(List<Integer> userNumeralInputList){
        user.setNumeralList(userNumeralInputList);
    }
    private List<Integer> toList(String userInput){
        checkNumeralInputValidation(userInput);

        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++){
            userInputList.add(userInput.charAt(i) - '0');
        }

        return userInputList;
    }

    private void checkNumeralInputValidation(String userInput){
        try {
            if (userInput.length() != Game.ANSWER_LENGTH){
                throw new IllegalArgumentException();
            }

            if (!isPatternMatched(userInput)){
                throw new IllegalArgumentException();
            }

            if (hasDuplicate(userInput)){
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    private boolean isPatternMatched(String userInput){
        if (Pattern.matches("^[0-9]*$", userInput)){
            return true;
        }
        return false;
    }

    private boolean hasDuplicate(String userInput){
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++){
            Character character = userInput.charAt(i);
            if (!hashSet.contains(character)){
                hashSet.add(character);
            }
            else {
                return true;
            }
        }
        return false;
    }

    private void countBall() {
        game.countBall(computer.getNumeralList(), user.getNumeralList());
    }

    private void countStrike() {
        game.countStrike(computer.getNumeralList(), user.getNumeralList());
    }

    private boolean isGameClear(){
        if (game.getStrikeCount() == Game.ANSWER_LENGTH){
            return true;
        }
        return false;
    }

    private void beatGame() {
        if (isGameClear()) {
            view.printGameClear(Game.ANSWER_LENGTH);
            game.setGameState(Game.GameState.CLEAR);
            view.printReplay();
            askReplay();
        }
    }

    private void askReplay(){
        String userInput = Console.readLine();
        checkReplayInputValidation(userInput);
        if (userInput.equals(Game.REPLAY)) {
            setGameState(Game.GameState.RUNNING);
            computer = new Computer();
        }
        else if (userInput.equals(Game.OVER)) setGameState(Game.GameState.OVER);
    }


    private void checkReplayInputValidation(String userInput){
        try {
            if (!userInput.equals(Game.REPLAY) && !userInput.equals(Game.OVER)){
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }


    public void printJudgement(){
        if (game.getBallCount() != 0 && game.getStrikeCount() != 0){
            view.printBallAndStrike(game.getBallCount(), game.getStrikeCount());
        }
        else if (game.getBallCount() != 0) {
            view.printBall(game.getBallCount());
        }
        else if (game.getStrikeCount() != 0){
            view.printStrike(game.getStrikeCount());
        }
        else {
            view.printNothing();
        }
    }


}
