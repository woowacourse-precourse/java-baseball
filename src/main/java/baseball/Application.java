package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Randoms;


public class Application {

    public static ArrayList<Integer> randomNum() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static ArrayList<Integer> userInput(){
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> already = new ArrayList<>();
        for(int i=0; i<3; i++){
            int number = Integer.valueOf(Console.readLine());
            already.add(number);
            if(!input.contains(number)){
                input.add(number);
            }
            if(input.get(i)==0){
                throw new IllegalArgumentException();
            }
        }
        return input;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList A = randomNum();

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요 :");
        Scanner scanner = new Scanner(System.in);
        ArrayList B = userInput();

    }
}