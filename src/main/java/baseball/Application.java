package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//1.랜덤한 3자리수를 생성한다.
//2.플레이어에게 세자리 수를 입력받는다.
//3.입력받은 세 자리 수 중 컴퓨터가 생성한 랜덤한 수와 같은 숫자가 있으면 1볼
//4.그 중에 자리까지 같으면 1스트라이크가 된다.
//5.최종 결과를 보고 다 맞추면 3스트라이크
//6.아니라면 힌트를 반환
public class Application {
    public static void main(String[] args) {
        List<Integer> randomNumber = makeRandomNumber();
        List<Integer> userInput = getUserInput();

        for (int i = 0; i < randomNumber.size(); i++) {

        }
    }

    private static List<Integer> getUserInput() {
        ArrayList<Integer> result = new ArrayList<>();
        String userInputString = Console.readLine();
        checkUserInput(result, userInputString);
        return result;
    }

    private static void checkUserInput(ArrayList<Integer> result, String userInputString) {
        if(userInputString.length()!=3){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < userInputString.length(); i++) {
            int userInputOneNum = Integer.parseInt(String.valueOf(userInputString.charAt(i)));
            if(result.contains(userInputOneNum)){
                throw new IllegalArgumentException();
            }
            result.add(userInputOneNum);
        }
    }

    public static List<Integer> makeRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        makeRandomNumbers(computer);

        return computer;
    }

    private static void makeRandomNumbers(List<Integer> computer) {
        while (computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            addRandomOneNumber(computer, randomNumber);
        }
    }

    private static void addRandomOneNumber(List<Integer> computer, int randomNumber) {
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber);
        }
    }
}
