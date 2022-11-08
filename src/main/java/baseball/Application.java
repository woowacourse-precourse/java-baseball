package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static BufferedReader br;
    static boolean result;
    static boolean restart;

    static List<Integer> computer;
    static List<Integer> numbers;

    static int strick;
    static int ball;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        start(br);
        while(!restart){
            restart(br);
        }
    }
    public static void start(BufferedReader br) throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        selectNumber();
        while(!result){
            inputNumber(br);
            checkNumber(numbers);
        }
    }

    public static void restart(BufferedReader br) throws IOException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String[] temp = br.readLine().split("");
        if(temp.length >= 2){
            throw new IllegalArgumentException();
        }
        int choice = Integer.parseInt(temp[0]);
        if(choice == 1){
            result = false;
            start(br);
        } else restart = true;
    }

    public static void checkNumber(List<Integer> numbers) {
        strick = 0;
        ball = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(computer.get(i) == numbers.get(j)){
                    if(i == j) strick++;
                    else ball++;
                }
            }
        }
        System.out.println(outputResult());
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

    public static void inputNumber(BufferedReader br) throws IOException {
        System.out.print("숫자를 입력해 주세요 : ");
        String[] temp = br.readLine().split("");
        if(temp.length >= 4){
            throw new IllegalArgumentException();
        }
        numbers = new ArrayList<>();
        for(int i=0; i<3;i++){
            numbers.add(Integer.parseInt(temp[i]));
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
