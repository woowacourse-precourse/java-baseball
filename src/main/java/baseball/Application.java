package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class BaseballGame {
    private List<Integer> computer;
    private List<Integer> player;
    private static final String pleaseInput = "숫자를 입력해주세요 : ";
    private static boolean inputCondition;
    public BaseballGame() {
        computer = new ArrayList<>();
        player = new ArrayList<>();
        inputCondition=true;
        newGame(computer);
    }
    private void newGame(List<Integer> computer) {
        selectNumbersByComputer(computer);
        while (inputCondition) { // 여기서 숫자를 계속 입력받아야한다.
            System.out.print(getPleaseInput());
            String input=Console.readLine();
            selectNumberByPlayer(player,input);
            break;
        }
    }
    private void selectNumbersByComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumberIfDifferent(computer, randomNumber);
        }
    }

    private void addNumberIfDifferent(List<Integer> integerList, int randomNumber) {
        if (!integerList.contains(randomNumber)) {
            integerList.add(randomNumber);
        }
    }
    public List<Integer> getComputerNumberList() {
        return this.computer;
    }
    public List<Integer> getPlayerNumberList() {
        return this.player;
    }
    public static String getPleaseInput() {
        return pleaseInput;
    }
    private List<Integer> selectNumberByPlayer(List<Integer> player,String input) throws IllegalArgumentException {
        try {
            isValidPlayerInput(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return player;
    }
    private boolean isValidPlayerInput(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력이 변환가능한 정수가 아님");
        }
        if (input.length()!=3) {
            throw new IllegalArgumentException("입력이 규정길이를 초과");
        } else{
            checkEqualityOfPlayerInput(input);
        }
        return true;
    }
    private void checkEqualityOfPlayerInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            addNumberIfDifferent(player,Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        if (player.size() < 3) {
            throw new IllegalArgumentException("서로 다른 임의의 수가 아님");
        }
    }
}

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            BaseballGame game = new BaseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            break;
        }
    }
}