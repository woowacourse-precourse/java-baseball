package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        Operator op = new Operator();
        while (op.getRestart()) {
            op.playGame();
        }
    }
}

class Computer {
    private List<Integer> number;

    public void setNumber() {
        showInputStatement();
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        number = numberList;
    }

    public List<Integer> getNumber() {
        return number;
    }
    public void showInputStatement() {
        System.out.println("서로 다른 숫자 3자리 수를 입력하세요");
    }
}

class Player {
    private List<Integer> number;

    public void inputNumber() throws IllegalArgumentException{
        List<Integer> numberList = new ArrayList<>();
        int num;
        try {
            num = Integer.parseInt(Console.readLine());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 잘못 입력했습니다. \n 프로그램을 종료합니다.");
        }
        while (num > 0) {
            numberList.add(num % 10);
            num /= 10;
        }
        if(!Operator.isCorrectNumber(numberList)) {
            throw new IllegalArgumentException("숫자를 잘못 입력했습니다. \n 프로그램을 종료합니다.");
        }
        Collections.reverse(numberList);
        number = numberList;
    }

    public List<Integer> getNumber() {
        return number;
    }
}

class Operator {
    Computer computer;
    Player player;
    private int ballCount;
    private int strikeCount;
    private boolean correctAnswer;
    private boolean restart;

    public Operator() {
        computer = new Computer();
        player = new Player();
        ballCount = 0;
        strikeCount = 0;
        correctAnswer = false;
        restart = true;
    }

    public void playGame() throws IllegalArgumentException{
        showStartStatement();
        computer.setNumber();
        while (!correctAnswer) {
            player.inputNumber();
            compareNumber();
            showResult();
        }
        showRestartStatement();
        inputWhetherToRestart();
    }

    public boolean getRestart() {
        return restart;
    }

    public void compareNumber() {
        int ball = 0;
        int strike = 0;
        List<Integer> computerNumber = computer.getNumber();
        List<Integer> playerNumber = player.getNumber();
        for (int i = 0; i < computerNumber.size(); i++) {
            int index = playerNumber.indexOf(computerNumber.get(i));
            if (index != -1) {
                if (index == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        ballCount = ball;
        strikeCount = strike;
        if (strikeCount == 3) {
            correctAnswer = true;
        }
    }
    public static boolean isCorrectNumber(List<Integer> numberList) {
        if(numberList.size() != 3) return false;
        HashMap<Integer, Integer> mapNumber = new HashMap<>();
        for(Integer num: numberList) {
            if(mapNumber.containsKey(num)) return false;
            else mapNumber.put(num, 1);
        }
        return true;
    }

    public void inputWhetherToRestart() throws IllegalArgumentException{
        String inputString = Console.readLine();
        if (inputString.equals("1")) {
            restart = true;
        } else if (inputString.equals("2")) {
            restart = false;
        }
        else {
            throw new IllegalArgumentException("숫자를 잘못 입력했습니다. \n 프로그램을 종료합니다.");
        }
    }

    public void showResult() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public void showStartStatement() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void showRestartStatement() {
        System.out.println("재시작 하시겠습니까?('1'입력시 재시작/'2'입력시 게임종료): ");
    }
}