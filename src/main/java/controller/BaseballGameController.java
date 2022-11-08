package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.ComputerNumberList;
import domain.UserInputNumberList;
import service.CompareNumber;

public class BaseballGameController {
    private static final String RESTART = "1";
    private static final String QUIT = "2";

    public final ComputerNumberList computerNumberList;
    public final UserInputNumberList userNumberList;
    public final CompareNumber compareNumber;

    public BaseballGameController() {
        this.computerNumberList = new ComputerNumberList();
        this.userNumberList = new UserInputNumberList();
        this.compareNumber = new CompareNumber(computerNumberList.getComputerNumber());
    }

    public void gameStart() {
        boolean correctiveStatus = false;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!correctiveStatus) {
            getUserInput();
            correctiveStatus = compareNumber.compare();
            correctiveStatus = reRunStatus(correctiveStatus);
        }
    }

    private void getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        this.userNumberList.setUserInputNumberList(userInput);
        compareNumber.setUserNumber(userNumberList.getUserInputNumberList());
    }

    private boolean reRunStatus(boolean correctiveStatus) {
        String userInput;

        if (correctiveStatus) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInput = Console.readLine();
            if (userInput.equals(RESTART)) {
                correctiveStatus = false;
                computerNumberList.generateNewRandomNumber();
                compareNumber.setComputerNumber(computerNumberList.getComputerNumber());
            } else if (userInput.equals(QUIT)) {
                System.out.println("게임을 종료합니다.");
            }
            else{
                throw new IllegalArgumentException("1 또는 2를 입력하셔야 합니다.");
            }
        }
        return correctiveStatus;
    }
}
