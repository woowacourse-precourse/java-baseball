package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Game {

    private static final int DIGIT = 3;
    private static final String RESTART_COMMAND = "1";
    private static final String EXIT_COMMAND = "2";

    private Computer computer;
    private Player player;
    private int strike = 0;
    private int ball = 0;
    private boolean nothing = false;

    private boolean EXIT = false;


    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = new Computer();
        player = new Player();
        computer.setNumber();
        while (!EXIT) {
            resetResult();
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            player.setNumber(input);

            calculateResult();
            printResult();
            checkIfAnswer();
        }
    }

    public void resetResult(){
        strike = 0;
        ball = 0;
        nothing = false;
    }

    public void makeNewRound(){
        computer.setNumber();
        EXIT = false;
    }

    public void checkExit(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if(!userInput.equals(RESTART_COMMAND) && !userInput.equals(EXIT_COMMAND)){
            throw new IllegalArgumentException();
        }
        if (userInput.equals(RESTART_COMMAND)){
            makeNewRound();
        }
        if(userInput.equals(EXIT_COMMAND)){
            EXIT = true;
        }
    }

    public void checkIfAnswer(){
        if (strike == DIGIT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            checkExit();
        }
    }


    public void printResult() {
        String result = getResult();
        System.out.println(result);
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();

        if (nothing) {
            sb.append("낫싱");
        }
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }

        return sb.toString();
    }

    public void calculateResult() {
        for (int i = 0; i < DIGIT; i++) {
            checkIfStrikeOrBall(i);
        }
        nothing = checkIfNothing();
    }

    public boolean checkIfNothing() {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }

    public void checkIfStrikeOrBall(int index) {
        if (isStrike(index))
            strike++;
        if (isBall(index))
            ball++;
    }

    public boolean isBall(int index) {
        return !isStrike(index) && computer.getNumber().contains(player.getNumber().get(index));
    }

    public boolean isStrike(int index) {
        return computer.getNumber().get(index) == player.getNumber().get(index);
    }
}
