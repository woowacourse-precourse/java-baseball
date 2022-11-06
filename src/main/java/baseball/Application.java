package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.error.ElementsShouldBeExactly;

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

    void end(){
        System.out.println("게임 종료");
    }

    void receiveUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        this.strike = 0;
        this.userNum.clear();
        this.userInput = Console.readLine();
    }

    void setUserInput() {
        receiveUserInput();
        this.checkUserInput(userInput);
    }

    void checkUserInput(String userInput){

        if (userInput.length() != 3)
            throw new IllegalArgumentException( );

        for (int i = 0; i < userInput.length(); i++) {
            int userChar =userInput.charAt(i)-'0';

            if (userChar<=0 | userChar>9)
                throw new IllegalArgumentException( );
            else if (userNum.contains(userChar))
                throw new IllegalArgumentException( );
            else
                userNum.add(userChar);
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

    void printBallStrike(){
        if (strike == 0)
            System.out.println(copyUserNum.size() + "볼");
        else if (copyUserNum.size() - strike == 0)
            System.out.println(strike + "스트라이크");
        else
            System.out.println((copyUserNum.size() - strike) + "볼 " + strike + "스트라이크");
    }

    void getRightAnswer(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        chooseGameConditions();
    }

    void chooseGameConditions(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        if(choice.equals("1"))
            Application.GameController();
        else
            end();
    }
}

public class Application {
    public static void GameController() {
        Game game = new Game();
        game.start();
        game.setUserInput();

        while(!game.getGameNums().equals(game.getUserNum())) {
            if(game.isNothing()) {
                game.printNothing();
            }else{
                game.compareNums();
                game.printBallStrike();
            }
            game.setUserInput();
        }

        if(game.getGameNums().equals(game.getUserNum()))
            game.getRightAnswer();
    }

    public static void main(String[] args) {
        GameController();
    }
}
