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
        isEnd = false;
        computer.createNumber();
        printGameStartStatement();
        try{
            while(isEnd == false){
                printInputStatement();
                getPlayerNumber();
                //checkBall();
                //checkStrike();
                printHint();
            }
            printGameEndStatement();
            getPlayerOption();
        }catch(IllegalArgumentException e){
            isContinue = false;
            System.out.println("잘못된 값을 입력하셨습니다. 게임 종료");
        }

    }

    private void getPlayerNumber() throws IllegalArgumentException {
        player = new ArrayList<>();
        String input = Console.readLine();
        if(input.length() != LENGTH_OF_NUMBER){
            throw new IllegalArgumentException();
        }
        int number = Integer.parseInt(input);
        for(int i = LENGTH_OF_NUMBER-1; i >= 0; i--) {
            int digit = number % 10;
            if(!isUniqueDigit(digit)){
                throw new IllegalArgumentException();
            }
            player.add(0, digit);
            number = number / 10;
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

    private void getPlayerOption() throws IllegalArgumentException{
        String input = Console.readLine();
        if(input.equals("1")){
            isContinue = true;
        }else if(input.equals("2")){
            isContinue = false;
        }else{
            throw new IllegalArgumentException();
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

}
