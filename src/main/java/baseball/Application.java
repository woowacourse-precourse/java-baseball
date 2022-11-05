package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.*;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");
        start();
    }

    public static void start(){
        List<Integer> computer = computerNumber();
        List<Integer> userNumber = input();


    }

    public static List<Integer> computerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> input() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        String inputNumber = sc.nextLine();
        List<Integer> inputNumberList = new ArrayList<>();
        boolean isNumeric = inputNumber.matches("[0-9]{3}"); //3글자 숫자로 이루어져있는지 확인하는 정규식

        if (!isNumeric) {
            throw new IllegalArgumentException("입력이 잘못 됐습니다.");
        }

        for (int i = 0; i < inputNumber.length(); i++){
            inputNumberList.add(Character.getNumericValue(inputNumber.charAt(i)));
        }
        return inputNumberList;
    }
}
