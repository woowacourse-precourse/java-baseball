package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberBaseballGame {

    public void execution() {
        List<String> computerNumber = createRandomNumber();
        System.out.println(computerNumber);
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<String> userNumber = inputUserNumber();
            List<Integer> strike_ball_count = calculateResult(computerNumber, userNumber);
            int strike = strike_ball_count.get(0);
            int ball = strike_ball_count.get(1);
            System.out.println(printResult(strike, ball));
            if (strike == 3) break;
        }
        isFinishGame();
    }

    public List<String> createRandomNumber() {
        List<String> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public List<String> inputUserNumber(){
        String inputUserStr = Console.readLine();
        List<String> userNumber = List.of(inputUserStr.split(""));
        HashSet<String> userNumberSet = new HashSet<>(userNumber);
        if (inputUserStr.length() != 3 || userNumberSet.size() != 3 ||
                userNumberSet.contains("0")  || !isNumeric(inputUserStr)){
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    public List<Integer> calculateResult(List<String> computerNumber, List<String> userNumber){
        int strike = 0;
        int ball = 0;
        List<Integer> strike_ball_count = new ArrayList<>();
        if (computerNumber.get(0).equals(userNumber.get(0))) {
            strike++;
        } else if (computerNumber.contains(userNumber.get(0))){
            ball++;
        }
        if (computerNumber.get(1).equals(userNumber.get(1))) {
            strike++;
        } else if (computerNumber.contains(userNumber.get(1))){
            ball++;
        }
        if (computerNumber.get(2).equals(userNumber.get(2))) {
            strike++;
        } else if (computerNumber.contains(userNumber.get(2))){
            ball++;
        }
        strike_ball_count.add(strike);
        strike_ball_count.add(ball);
        return strike_ball_count;
    }

    public String printResult(int strike, int ball){
        String result = "";
        if (ball > 0 && strike > 0){
            result += ball +"볼 "+strike +"스트라이크";
        } else if (ball > 0){
            result += ball +"볼";
        } else if (strike > 0){
            result += strike +"스트라이크";
        } else {
            result += "낫싱";
        }
        return result;
    }

    public void isFinishGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int startOrEnd = Integer.parseInt(Console.readLine());
        isRepeatGame(startOrEnd);
    }

    public void isRepeatGame(int startOrEnd){
        if (startOrEnd == 1){
            execution();
        } else if (startOrEnd != 2) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNumeric(String inputNumber){
        try{
            Integer.parseInt(inputNumber);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
