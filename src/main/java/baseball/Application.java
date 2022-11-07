package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer = setAnswerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해 주세요 : ");

        String numStr = userInputNumber(System.in);

        System.out.println(numStr);

    }

    public static List<Integer> setAnswerNumber(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String userInputNumber(InputStream in){
        String userStr = systemInput(in);

        if(userStr == null || userStr.length() > 3 || userStr.length() < 3){
            throw new IllegalArgumentException();
        }

        try{
            Integer.parseInt(userStr);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        return userStr;
    }

    public static String systemInput(InputStream in){

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        try {
            String input = br.readLine();
            return input;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
