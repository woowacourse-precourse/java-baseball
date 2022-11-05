package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Game{
    private List<Integer> computerNum = new ArrayList<>();
    String userInput;
    private List<Integer> userNum = new ArrayList<>();
    List<Integer> copyUserNum = new ArrayList<>();
    private int strike;

    public Game(){
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber))
                computerNum.add(randomNumber);
        }
    }

    public List<Integer> getGameNums(){
        return computerNum;
    }

    public List<Integer> getUserNum(){
        return userNum;
    }

    void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    void setUserInput() {
        userInput = Console.readLine();
        checkUserInput();
    }

    void checkUserInput() throws IllegalArgumentException{
        if (userInput.length() != 3)
            throw new IllegalArgumentException("게임 종료");

        for (int i = 0; i < userInput.length(); i++) {
            int userChar = (int)userInput.charAt(i);
            if (userChar<=0 | userChar>9)
                throw new IllegalArgumentException("게임 종료");
            userNum.add((int) userInput.charAt(i));
        }
    }

    boolean isNothing(){
        copyUserNum = new ArrayList<>(userNum);
        copyUserNum.retainAll(computerNum);

        return copyUserNum.isEmpty();
    }

    void printNothing(){
        System.out.println("낫싱");
    }

    void compareNums(){
        for (Integer integer : copyUserNum) {
            int indexComputer = computerNum.indexOf(integer);
            int indexUser = userNum.indexOf(integer);
            if (indexComputer == indexUser)
                this.strike++;
        }
    }
}

public class Application {
    public static void GameController() {
        Game game = new Game();
        game.start();
        game.setUserInput();

        while(!game.getGameNums().equals(game.getUserNum())) {

        }
    }

    public static void main(String[] args) {
    }
}
