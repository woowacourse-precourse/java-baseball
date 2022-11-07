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
    int ball;
    int strike;
    public BaseballGame() {
        computer = new ArrayList<>();
        player = new ArrayList<>();
        inputCondition=true;
        ball=0;
        strike=0;
        newGame(computer);
    }
    private void newGame(List<Integer> computer) {
        selectNumbersByComputer(computer);
        while (inputCondition) { // 여기서 숫자를 계속 입력받아야한다.
            System.out.print(getPleaseInput());
            String input=Console.readLine();
            selectNumberByPlayer(player,input);
            // 여기서 스트라이크인지 볼인지 판단하여 inputCondition을 조절하여야 한다.
            getBallCounts(getComputerNumberList(), getPlayerNumberList());
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
    private void getBallCounts(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        for (Integer n : computerNumberList) {
            increaseBallCount(playerNumberList, n);
        }
        for(int i=0;i<computerNumberList.size();i++){
            increaseStrikeCount(computerNumberList, playerNumberList, i);
        }
    }

    private void increaseStrikeCount(List<Integer> computerNumberList, List<Integer> playerNumberList, int i) {
        if (computerNumberList.get(i).equals(playerNumberList.get(i))) {
            strike+=1;
        }
    }

    private void increaseBallCount(List<Integer> playerNumberList, Integer n) {
        if (playerNumberList.contains(n)) {
            ball+=1;
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