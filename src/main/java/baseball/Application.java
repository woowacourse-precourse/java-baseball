package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Application {
    static List<Integer> createRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static List<Integer> getInputNumber(){
        String input;
        int inputNumber = 0;
        try {
            input = Console.readLine();
            inputNumber = Integer.parseInt(input);
            if (inputNumber<100 || inputNumber>999) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalStateException e){
            e.printStackTrace();
            throw e;
        }

        List<Integer> number = new ArrayList<>();
        int cnt=100;
        for (int i = 0; i < 3; i++) {
            number.add(inputNumber/cnt);
            inputNumber %= cnt;
            cnt/=10;
        }
        return number;
    }
    static int checkBall(int index,int value, List<Integer> computer){
        int Ball=0;
        for (int i = 0; i < 3; i++) {
            if(Objects.equals(value, computer.get(i)) && index!=i)
                Ball++;
        }
        return Ball;
    }
    static int checkStrike(int index,int value, List<Integer> computer){
        int strike=0;
        for (int i = 0; i < 3; i++) {
            if(Objects.equals(value, computer.get(i)) && index==i)
                strike++;
        }
        return strike;
    }
    static HashMap<String,Integer> getResult(List<Integer> input, List<Integer> computer){
        HashMap<String,Integer> result = new HashMap<>();
        int ball=0, strike=0;
        for (int i = 0; i < 3; i++) {
            strike += checkStrike(i,input.get(i),computer);
            ball += checkBall(i,input.get(i),computer);
        }
        result.put("strike",strike);
        result.put("ball",ball);
        return result;
    }
    static void repeatInput (List<Integer> computer){
        while(true){
            System.out.print("숫자를 입력해 주세요 : ");
            List<Integer> input = getInputNumber();
            HashMap<String ,Integer> result = getResult(input,computer);

            int strike = result.get("strike");
            int ball = result.get("ball");
            if(strike==0 && ball==0){
                System.out.println("낫싱");
            }
            if(ball!=0){
                System.out.print(ball+"볼 ");
            }
            if(strike!=0){
                System.out.print(strike+"스트라이크");
            }
            System.out.println("\n");

            if(strike==3){
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                return;
            }
        }
    }
    static boolean isPlay() {
        String isPlaying = Console.readLine();
        if (isPlaying.equals("1")) {
            return true;
        } else if (isPlaying.equals("2")){
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        boolean isPlay = true;
        while (isPlay) {
            List<Integer> computer = createRandomNumber();
            repeatInput(computer);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            isPlay = isPlay();
        }
    }
}
