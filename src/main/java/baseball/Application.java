package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    private boolean isNumberWithoutZero(String str){
        if(str == null || str.isEmpty())
            return false;
        long numOfDigit = str.chars()
            .mapToObj(ch -> (char)ch)
            .filter(ch -> Character.isDigit(ch) && !Objects.equals(ch,'0'))
            .count();
        return numOfDigit == str.length();
    }

    private boolean is3DigitNumberWithoutZero(String str){
        return isNumberWithoutZero(str) && str.length() == 3;
    }

    private boolean hasUniqueCharacter(String str){
        if(str == null || str.isEmpty())
            return false;
        long numOfUniqueCharacter = str.chars()
                .distinct()
                .count();
        return numOfUniqueCharacter == str.length();
    }

    private void validateUserInput(String userInput, boolean gameover){
        if(gameover){
            if(!Objects.equals(userInput,"1") && !Objects.equals(userInput,"2")){
                throw new IllegalArgumentException("userInput should be 1 or 2.");
            }
        } else{
            if(!is3DigitNumberWithoutZero(userInput) || !hasUniqueCharacter(userInput)){
                throw new IllegalArgumentException("userInput should be 3 distinct digit number.");
            }
        }
    }
    private List<Integer> createComputerNumbers(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private int numOfStrike(List<Integer> userInput, List<Integer> computer){
        return (int)IntStream.range(0, 3)
                .filter(i -> Objects.equals(userInput.get(i), computer.get(i)))
                .count();
    }

    private int numOfBall(List<Integer> userInput, List<Integer> computer){
        return (int)IntStream.range(0, 3)
                .filter(i -> !Objects.equals(userInput.get(i), computer.get(i)) && computer.contains(userInput.get(i)))
                .count();
    }

    private void printBallCount(int strike, int ball){
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if(strike == 0){
            System.out.println(ball+"볼");
        } else if(ball == 0){
            System.out.println(strike+"스트라이크");
        } else{
            System.out.println(ball +"볼 "+strike+"스트라이크");
        }
    }

    private List<Integer> scanUser3DigitInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        validateUserInput(userInput, false);
        return userInput.chars()
                .mapToObj(ch -> ch - '0')
                .collect(Collectors.toList());
    }

    private boolean scanWhetherNewGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        validateUserInput(userInput, true);
        if(Objects.equals(userInput,"1")){
            return true;
        } else{
            return false;
        }
    }

    public void startGame(){
        List<Integer> computer = createComputerNumbers();
        boolean gameover = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(!gameover){
            List<Integer> userInput = scanUser3DigitInput();
            int strike = numOfStrike(userInput, computer);
            int ball = numOfBall(userInput, computer);
            printBallCount(strike, ball);

            if(strike == 3){
                gameover = true;
            }
            if(gameover && scanWhetherNewGame()){
                computer = createComputerNumbers();
                gameover = false;
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application baseballGame = new Application();
        baseballGame.startGame();
    }
}
