package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computerNumber = new ArrayList<>();
    static List<Integer> userNumber = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            userInputNumbers();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void createRandomNumber(){
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public static void userInputNumbers() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = br.readLine();

        if(!inputStr.matches("[0-9]{3}")){
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        for(String inputSingleStr : inputStr.split("")){
            userNumber.add(Integer.parseInt(inputSingleStr));
        }
    }
}


