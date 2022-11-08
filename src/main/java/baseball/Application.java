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

    static List<Integer> computer;
    static List<Integer> numbers;

    static int strick;
    static int ball;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        selectNumber();
        while(!result){
            inputNumber(br);
            checkNumber(numbers);
        }
    }

    private static void checkNumber(List<Integer> numbers) {
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
    }

    private static void inputNumber(BufferedReader br) throws IOException {
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

    private static void selectNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
//        System.out.println(computer);
    }
}
