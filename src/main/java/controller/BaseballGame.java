package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.ComputerNumberList;
import domain.UserInputNumberList;
import service.CompareNumber;

public class BaseballGame {
    public final ComputerNumberList computerNumber;
    public final UserInputNumberList userNumberList;
    public final CompareNumber compareNumber;

    public BaseballGame() {
        boolean correctiveStatus = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.computerNumber = new ComputerNumberList();
        this.userNumberList = new UserInputNumberList();
        this.compareNumber = new CompareNumber(computerNumber.computerNumber);

        while (!correctiveStatus){
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            this.userNumberList.setUserInputNumberList(userInput);
            compareNumber.setUserNumber(userNumberList.userInputNumberList);
            correctiveStatus = compareNumber.compare();
        }
    }
}
