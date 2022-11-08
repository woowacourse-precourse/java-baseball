package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.List;

public class BaseballGame {
    public static int strike;
    public static int ball;
    public static List<Integer> comNum;
    public static List<Integer> userNumbers;

    public BaseballGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.comNum = Computer.createGameNumber();
    }

    public void playGame(){
        System.out.println("숫자를 입력해주세요 : ");
        userNumbers = User.inputGameNumber();
        validateUserNum();
        ballCount();
        System.out.println(hintPrint());
    }
    public static void validateUserNum(){

        if(userNumbers.size() != 3){
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 세자리 숫자를 입력해주세요.");
        }
        // 사이즈가 3이 아닌 경우

        if(userNumbers.contains(0)){
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 0을 제외한 숫자를 입력해주세요.");
        }
        // 0을 포함한 경우

        for(int i =0; i< userNumbers.size(); i++){
            if(Collections.frequency(userNumbers, userNumbers.get(i)) != 1){
                throw new IllegalArgumentException("올바른 숫자가 아닙니다. 서로 다른 숫자로 이루어져야 합니다.");
            }
        }
        // 중복 숫자를 입력한 경우
    }
    public void ballCount(){
        this.strike = 0;
        this.ball = 0;
        for(int i = 0; i < userNumbers.size(); i++) {
            //스트라이크 카운트
            if (comNum.indexOf(userNumbers.get(i)) == i) {
                strike++;
                continue;
            }
            //볼 카운트
            if (comNum.contains(userNumbers.get(i))) {
                ball++;
            }
        }
    }
    public String hintPrint(){
        if(ball != 0 && strike != 0){
            return (ball + "볼 " + strike + "스트라이크");
        }
        if(ball ==0 && strike != 0){
            return (strike + "스트라이크");
        }
        if(ball != 0 && strike ==0){
            return (ball + "볼");
        }
        return ("낫싱");
    }
    public boolean gameEnd() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

            String response = Console.readLine();
            if (response.equals("1")) {
                this.comNum = Computer.createGameNumber();
                return true;
            }
            if (response.equals("2")) {

                return false;
            }
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 1 또는 2를 입력하세요.");
        }
        return true;
    }
}
