package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final int LENGTH_OF_NUMBER = 3;
    private boolean isEnd = false;
    private boolean isContinue = true;
    private int ballCount = 0;
    private int strikeCount = 0;
    private Rival computer;
    private List<Integer> player;

    BaseballGame(){
        computer = new Rival();
    }

    public void play(){
        initializeGame();
        computer.createNumber();
        printGameStartStatement();

        while(!isEnd) {
            initializeTurn();
            printInputStatement();
            getPlayerNumber();
            checkBall();
            checkStrike();
            printHint();
            checkGameEnd();
        }
        printGameEndStatement();
        getPlayerOption();
    }

    private void initializeGame(){
        isEnd = false;
        isContinue = true;
    }

    private void initializeTurn(){
        ballCount = 0;
        strikeCount = 0;
    }

    private void getPlayerNumber(){
        player = new ArrayList<>();
        String input = Console.readLine();

        checkNonNumericException(input);
        checkLengthException(input);
        checkDuplicationException(input);

        int number = Integer.parseInt(input);
        for(int i = LENGTH_OF_NUMBER-1; i >= 0; i--) {
            int digit = number % 10;
            player.add(0, digit);
            number = number / 10;
        }
    }

    private void checkNonNumericException(String input){
        final String NUMERIC_VERIFICATION_PATTERN = "^[1-9]+$";
        if(!input.matches(NUMERIC_VERIFICATION_PATTERN)){
            throw new IllegalArgumentException();
        }

    }
    private void checkLengthException(String input){
        if(input.length() != LENGTH_OF_NUMBER){
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicationException(String input){
        int number = Integer.parseInt(input);
        for(int i = LENGTH_OF_NUMBER-1; i >= 0; i--) {
            int digit = number % 10;
            if(!isUniqueDigit(digit)){
                throw new IllegalArgumentException();
            }
            number = number / 10;
        }
    }

    private void checkInvalidOptionException(String input){
        if(!input.equals("1") && !input.equals("2")){
            throw new IllegalArgumentException();
        }
    }

    private boolean isUniqueDigit(int digit){
        for(int i = 0; i < player.size(); i++){
            if(digit == player.get(i)){
                return false;
            }
        }
        return true;
    }

    private void getPlayerOption(){
        String input = Console.readLine();
        checkInvalidOptionException(input);

        if(input.equals("1")){
            isContinue = true;
        }else if(input.equals("2")){
            isContinue = false;
        }
    }

    public boolean getIsContinue(){
        return isContinue;
    }

    private void printGameStartStatement(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printGameEndStatement(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void printInputStatement(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printHint(){
        if(ballCount == 0 && strikeCount == 0){
            printNothing();
        }else{
            printBall();
            printStrike();
        }
    }
    private void printNothing(){
        System.out.println("낫싱");
    }

    private void printBall(){
        if(ballCount != 0 && strikeCount != 0){
            System.out.print(ballCount + "볼 ");
        }else if(ballCount != 0 && strikeCount == 0){
            System.out.println(ballCount + "볼");
        }
    }

    private void printStrike(){
        if(strikeCount != 0){
            System.out.println(strikeCount + "스트라이크");
        }
    }

    private void checkBall(){
        for(int i = 0; i < LENGTH_OF_NUMBER; i++){
            int digit = player.get(i);
            if(computer.contains(digit) && computer.getIndexOf(digit) != i){
                ballCount++;
            }
        }
    }

    private void checkStrike(){
        for(int i = 0; i < LENGTH_OF_NUMBER; i++){
            if(player.get(i) == computer.getNumber().get(i)){
                strikeCount++;
            }
        }
    }

    private void checkGameEnd(){
        if(strikeCount == 3){
            isEnd = true;
        }
    }

}
