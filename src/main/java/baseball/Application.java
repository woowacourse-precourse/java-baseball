package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List answer = answer();
        playGame(answer);
    }
    public static void playGame(List list){

        System.out.println("숫자를 입력해주세요 : ");
        String guess = Console.readLine();

        System.out.println(guess);
        checkString(guess);
        checkAnswer(guess,list);
    }
    public static List<Integer> answer(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)) computer.add(randomNumber);
        }

        System.out.println(computer);

        return computer;
    }

    public static void checkString(String str){
        System.out.println("스트링을 체크합니다");

        if (str.length()!=3) {
            throw new IllegalArgumentException("입력 오류1");
        }

        for (int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                throw new IllegalArgumentException("입력 오류2");
            }
        }
    }

    public static void printResult(Integer ball, Integer strike, List list){
        System.out.println("결과를 출력합니다");

        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            playGame(list);
        }
        else if (strike > 0 && ball > 0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
            playGame(list);
        }
        else if (strike == 0 && ball > 0) {
            System.out.println(ball+"볼");
            playGame(list);
        }
        else if(strike > 0 && strike <= 2) {
            System.out.println(strike+"스트라이크");
            playGame(list);
        }
        else {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
            String flag = Console.readLine();
            restart(flag);
        }
    }

    public static void checkAnswer(String str, List answer){
        System.out.println("정답을 확인합니다");
        int strike = 0;
        int ball = 0;

        if(answer.get(0).toString().charAt(0) == str.charAt(0)) strike += 1;
        else if (answer.get(0).toString().charAt(0) == str.charAt(1) || answer.get(0).toString().charAt(0) == str.charAt(2))
            ball += 1;

        if(answer.get(1).toString().charAt(0) == str.charAt(1)) strike += 1;
        else if (answer.get(1).toString().charAt(0) == str.charAt(0) || answer.get(1).toString().charAt(0) == str.charAt(2))
            ball += 1;

        if(answer.get(2).toString().charAt(0) == str.charAt(2)) strike += 1;
        else if (answer.get(2).toString().charAt(0) == str.charAt(0) || answer.get(2).toString().charAt(0) == str.charAt(1))
            ball += 1;

        printResult(ball,strike,answer);
    }

    public static void restart(String flag){
        System.out.println("restart");
        System.out.println(flag);
        if(flag.charAt(0) == '1') {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List answer = answer();
            playGame(answer);
        }
        else System.out.println("게임 종료");
    }
}