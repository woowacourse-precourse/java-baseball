package baseball.controller;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.User;
import baseball.view.View;

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

    public void setUserNumeralList(List<Integer> userNumeralInputList){
        user.setUserNumeralList(userNumeralInputList);
    }
    public List<Integer> toList(String userInput){
        checkInputValidation(userInput);

        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++){
            userInputList.add(userInput.charAt(i) - '0');
        }

        return userInputList;
    }

    public Game.GameState getGameState(){
        return game.getGameState();
    }

    private void checkInputValidation(String userInput){
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

    private boolean isPatternMatched(String userInput){
        if (Pattern.matches("^[0-9]*$", userInput)){
            return true;
        }
        return false;
    }




}
