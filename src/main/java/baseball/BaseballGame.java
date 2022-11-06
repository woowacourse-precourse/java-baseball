package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final int LENGTH_OF_NUMBER = 3;
    private boolean isEnd = false;
    private boolean isContinue = true;
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
            while(true){
                getPlayerNumber();
                //게임 진행

                /*
                getPlayerOption(); //3스트라이크로 게임이 끝난 후
                 */
            }
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

    private void getPlayerOption(){
        String input = Console.readLine();
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


}
