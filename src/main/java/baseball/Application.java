package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            Operator op = new Operator();
            op.playGame();
            if (!op.getRestart()) {
                break;
            }
        }
    }
}

class Computer {
    private List<Integer> number;

    public void setNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        number = numberList;
        // System.out.println("컴퓨터 생성숫자: " + number);
    }

    public List<Integer> getNumber() {
        return number;
    }
}

class Player {
    private List<Integer> number;

    public void inputNumber() throws IllegalArgumentException {
        showInputStatement();
        List<Integer> numberList = new ArrayList<>();
        int num;
        try {
            num = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 잘못 입력했습니다. 프로그램을 종료합니다.(숫자가 아님)");
        }
        while (num > 0) {
            numberList.add(num % 10);
            num /= 10;
        }
        if (!Operator.isCorrectNumber(numberList)) {
            throw new IllegalArgumentException("숫자를 잘못 입력했습니다. 프로그램을 종료합니다.(서로 다른 3자리 숫자가 아님)");
        }
        Collections.reverse(numberList);
        number = numberList;
        //System.out.println("플레이어 입력 숫자: " + number);
    }

    public void showInputStatement() {
        System.out.print("숫자를 입력해주세요 : ");
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

    public void playGame() throws IllegalArgumentException {
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
            if (index == -1) {
                continue;
            }
            if (index == i) {
                strike++;
            } else {
                ball++;
            }
        }
        ballCount = ball;
        strikeCount = strike;
        if (strikeCount == 3) {
            correctAnswer = true;
        }
    }

    public static boolean isCorrectNumber(List<Integer> numberList) {
        if (numberList.size() != 3) {
            return false;
        }
        HashMap<Integer, Integer> mapNumber = new HashMap<>();
        for (Integer num : numberList) {
            if (num == 0) {
                return false;
            }
            if (mapNumber.containsKey(num)) {
                return false;
            } else {
                mapNumber.put(num, 1);
            }
        }
        return true;
    }

    public void inputWhetherToRestart() throws IllegalArgumentException {
        String inputString = Console.readLine();
        if (inputString.equals("1")) {
            restart = true;
        } else if (inputString.equals("2")) {
            restart = false;
        } else {
            throw new IllegalArgumentException("숫자를 잘못 입력했습니다. 프로그램을 종료합니다.(재시작/종료 숫자가 아님)");
        }
        // System.out.println("재시작 숫자: " + inputString);
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}