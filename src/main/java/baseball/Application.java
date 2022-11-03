package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static void main(String[] args) {
        gameStart();

    }

    static void gameStart(){
        int[] computer = initializeComputerNumber();
        boolean playBaseball = true;
        while(playBaseball){
            getUserInput();
        }
    }

    static int[] initializeComputerNumber(){
        List<Integer> computerNumberList = new ArrayList<>();
        while(computerNumberList.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumberList.contains(randomNumber)){
                computerNumberList.add(randomNumber);
            }
        }
        int[] computerNumberArray = computerNumberList.stream().mapToInt(i -> i).toArray();
        return computerNumberArray;
    }

    static String getUserInput(){
        System.out.print(INPUT_MESSAGE);
        String userInput = Console.readLine();
        return userInput;
    }
}
