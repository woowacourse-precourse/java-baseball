package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Computer computer;
    private User user;
    private View view;

    public Controller(Computer computer, User user, View view){
        this.computer = computer;
        this.user = user;
        this.view = view;
    }

    public void setUserNumeralList(List<Integer> userNumeralInputList){
        user.setUserNumeralList(userNumeralInputList);
    }
    public List<Integer> toList(String userInput){
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++){
            userInputList.add(userInput.charAt(i) - '0');
        }
        return userInputList;
    }

}
