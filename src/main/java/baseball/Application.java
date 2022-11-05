package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> createComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber))
                computerNum.add(randomNumber);
        }
        return computerNum;
    }

    public static List<Integer> getUserInput() throws IllegalArgumentException{
        List<Integer> userNum = new ArrayList<>();
        String userInput = Console.readLine();

        if(userInput.length() != 3)
            throw new IllegalArgumentException("게임 종료");

        for (int i = 0; i < userInput.length(); i++){
            if((int)userInput.charAt(i) == 0)
                throw new IllegalArgumentException("게임 종료");
            userNum.add((int) userInput.charAt(i));
        }
        return userNum;
    }

    public void startGame() {
        List<Integer> computerNum = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNum = createComputerNum();
        boolean continueGame = true;

        while (continueGame) {
            try{
                List<Integer> userNum = getUserInput();
            }catch(IllegalArgumentException e){
                System.out.println(e.toString());
            }
        }
    }

    public static void main(String[] args) {
    }
}
