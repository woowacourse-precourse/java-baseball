package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberBaseballGame {
    private List<String> computerNumber = new ArrayList<>();
    private List<String> userNumber = new ArrayList<>();
    private HashSet<String> cumputerNumberSet = new HashSet<>();
    private int strike = 0;
    private int ball = 0;

    public void execution() {
        createRandomNumber();
        cumputerNumberSet = new HashSet<>(computerNumber);
        System.out.println("숫자 야구 게임을 시작합니다.");
        strike = 0;
        ball = 0;
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            inputUserNumber();
            calculateResult();
            printResult();
            if (strike == 3) break;
            strike = 0;
            ball = 0;
        }
        isFinishGame();
    }

    public void createRandomNumber() {
        computerNumber.clear();
        while (computerNumber.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public void inputUserNumber(){
        String inputUserStr = Console.readLine();
        userNumber = List.of(inputUserStr.split(""));
        HashSet<String> userNumberSet = new HashSet<>(userNumber);
        if (inputUserStr.length() != 3 || userNumberSet.size() != 3 ||
                userNumberSet.contains("0")  || !isNumeric(inputUserStr)){
            throw new IllegalArgumentException();
        }
    }

    public void calculateResult(){
        if (computerNumber.get(0).equals(userNumber.get(0))) {
            strike++;
        } else if (cumputerNumberSet.contains(userNumber.get(0))){
            ball++;
        }
        if (computerNumber.get(1).equals(userNumber.get(1))) {
            strike++;
        } else if (cumputerNumberSet.contains(userNumber.get(1))){
            ball++;
        }
        if (computerNumber.get(2).equals(userNumber.get(2))) {
            strike++;
        } else if (cumputerNumberSet.contains(userNumber.get(2))){
            ball++;
        }
    }

    public void printResult(){
        String result = "";
        if (ball > 0 && strike > 0){
            result += ball +"볼 "+strike +"스트라이크";
        } else if (ball > 0){
            result += ball +"볼";
        } else if (strike > 0){
            result += strike +"스트라이크";
        } else {
            result += "낫싱";
        }
        System.out.println(result);
    }

    public void isFinishGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int startOrEnd = Integer.parseInt(Console.readLine());
        isRepeatGame(startOrEnd);
    }

    public void isRepeatGame(int startOrEnd){
        if (startOrEnd == 1){
            execution();
        } else if (startOrEnd != 2) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNumeric(String inputNumber){
        try{
            Integer.parseInt(inputNumber);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
