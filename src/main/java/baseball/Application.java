package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static boolean result;
    static boolean restart;

    static List<Integer> computer;
    static List<Integer> numbers;

    static int strick;
    static int ball;

    public static void main(String[] args){
        start();
    }

    public static void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        selectNumber();

        while (!result) {
            System.out.print("숫자를 입력해 주세요 : ");
            inputNumber();
            disitException(numbers.size());

            checkNumber(numbers);
            System.out.println(outputResult());
        }
        while (!restart) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart();
        }
    }

    public static void restart(){
        String input = readLine();
        if(input.equals("1")){
            result = false;
            start();
        }else if(input.equals("2")){
            restart = true;
        }else{
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

    public static void checkNumber(List<Integer> numbers) {
        strick = 0;
        ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(i) == numbers.get(j)) {
                    if (i == j) strick++;
                    else ball++;
                }
            }
        }
    }

    public static String outputResult() {
        if(strick == 0 && ball == 0){
            return "낫싱";
        }else if(strick == 3){
            result = true;
            return "3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }else if(ball != 0 && strick != 0){
            return ball+"볼 "+strick+"스트라이크";
        }else if(ball == 0 && strick != 0){
            return strick+"스트라이크";
        }else if(ball != 0 && strick == 0){
            return ball+"볼";
        }
        return null;
    }

    public static void inputNumber(){
        String input = readLine();
        numbers = new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
    }

    public static void disitException(int size){
        if(size != 3){
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
    }

    public static void selectNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

}
