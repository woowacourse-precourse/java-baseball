package baseball.controller;

import baseball.dto.NumListDto;
import baseball.view.PrintConsole;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ReceiveConsole {

    public static int choiceGameContinue() {
        String answer = Console.readLine();
        
        while (!Valid.isValidRestartAns(answer)) {
            PrintConsole.reAnswer();
            choiceGameContinue();
        }
        
        int answerToInt = Integer.parseInt(answer);
        return answerToInt;
    }

    public static List<Integer> receiveNumIncludeAllException() throws IllegalArgumentException {
        List<Integer> numList;
        try {
            numList = receiveNum();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return numList;
    }

    private static List<Integer> receiveNum() throws IllegalArgumentException{
        List<Integer> numList = new ArrayList<>();
        String numString = Console.readLine();
        for (int i = 0; i < numString.length(); i++) {
            numList.add((int) (numString.charAt(i)-'0'));
        }

        NotValidInputException(numList);

        return numList;
    }

    private static void NotValidInputException(List<Integer> numList) {
        if (!Valid.isValidNumList(numList)) {
            throw new IllegalArgumentException();
        }
    }


}
