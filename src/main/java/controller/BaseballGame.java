package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.ComputerNumberList;
import domain.UserInputNumberList;

public class BaseballGame {
    public final ComputerNumberList computerNumber;
    public final UserInputNumberList userNumberList;

    public BaseballGame() {
        String userInput = Console.readLine();
        this.computerNumber = new ComputerNumberList();
        this.userNumberList = new UserInputNumberList(userInput);
    }
}
