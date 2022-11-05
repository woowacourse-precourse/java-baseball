package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

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

    private String getUserInput(){
        return Console.readLine();
    }

    public List<Integer> getUserNumberList() {
        List<Integer> lst = new ArrayList<>();
        String input = getUserInput();
        if (!isValidSize(input)) {
            throw new IllegalArgumentException();
        }
        for (int index = 0; index < 3; index++) {
            int indexInt = charToInt(input.charAt(index));
            if (!isValidNumber(indexInt, lst)) {
                throw new IllegalArgumentException();
            }
            lst.add(indexInt);
        }
        return lst;
    }

    private int charToInt(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException();
        }
        return c - '0';
    }

    private boolean isValidSize(String input) {
        return input.length() == 3;
    }

    private void printStartingGuide(){
        System.out.println("숫자 아구 게임을 시작합니다.");
    }

    private void printInputGuide(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printEndingGuide(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printRestartGuide(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
    }

    public boolean isEnding(){
        int gameOption = getGameOption();
        return gameOption == 2;
    }

    private int getGameOption(){
        String userInput = getUserInput();
        int userInputNumber = strToInt(userInput);
        if(!isValidOption(userInputNumber)){
            throw new IllegalArgumentException();
        }
        return userInputNumber;
    }

    private boolean isValidOption(int number){
        return number == 1 || number == 2;
    }

    private int strToInt(String input){
        try{
            return Integer.parseInt(input);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }
}
