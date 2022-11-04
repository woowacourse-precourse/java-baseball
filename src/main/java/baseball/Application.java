package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static List<Integer> setComputerNumbers(List<Integer> computerNumbers){

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

public static void setUserNumbers(){
        String inputNumber;
        List<String> userNumbers = new ArrayList<>();

        inputNumber = readLine();
//        String[] a = inputNumber.split("");

//        userNumbers.add(inputNumber.split(""));

        for(int i =0;i<inputNumber.length();i++){
            userNumbers.add(String.valueOf(inputNumber.charAt(i)));
            // 자바 컨벤션으로 인해 수정.
            // computer의 숫자를 String으로 바꾸면 해결 가능.
            // 점의 개수를 줄이기 위해 임시배열 생성 후 값을 int로 변환하여 리스트에 더한다.
        }

        for(String a : userNumbers) System.out.println(a);
}

    public static void playBaseball(){
        /*List<Integer> computerNumbers = new ArrayList<>();

        computerNumbers = setComputerNumbers(computerNumbers);

        for(int numbers : computerNumbers) System.out.println(numbers); //난수 출력 확인.*/

        setUserNumbers();
    }

    public static void main(String[] args) {
        playBaseball();
    }
}

