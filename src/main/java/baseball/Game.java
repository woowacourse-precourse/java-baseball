package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    private static List<Integer> computerNumberList = new ArrayList<>();

    public void start() {
        boolean isRestart = false;
        do {
            computerNumberList = getComputerNumberList();
            // 라운드 시작;
            Round round = new Round();
            round.run(computerNumberList);
            // 재시작 가이드;
            printRestartGuide();
            // 재시작 옵션
            isRestart = getRestartOptionAndUpdateIsRestart();
        } while (isRestart);
    }

    public List<Integer> getComputerNumberList() {
        ArrayList<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = getValidRandomNumber(computerNumberList);
            computerNumberList.add(randomNumber);
        }
        return computerNumberList;
    }

    private int getValidRandomNumber(List<Integer> lst) {
        int pickNumber;
        do {
            pickNumber = Randoms.pickNumberInRange(1, 9);
        } while (!isValidNumber(pickNumber, lst));
        return pickNumber;
    }

    public boolean isValidNumber(int number, List<Integer> lst) {
        if (number < 1 || number > 9) {
            return false;
        }
        return !lst.contains(number);
    }

    private void printRestartGuide(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
    }

    public boolean getRestartOptionAndUpdateIsRestart(){
        int gameOption = getRestartOption();
        return gameOption == 1;
    }

    private int getRestartOption(){
        String userInput = getUserInput();
        int userInputNumber = strToInt(userInput);
        if(!isValidOption(userInputNumber)){
            throw new IllegalArgumentException();
        }
        return userInputNumber;
    }


    private String getUserInput(){
        return Console.readLine();
    }

    private int strToInt(String input){
        try{
            return Integer.parseInt(input);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidOption(int number){
        return number == 1 || number == 2;
    }

}
