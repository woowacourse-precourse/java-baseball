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
    static Integer strikeCount = 0;
    static Integer ballCount = 0;

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

    public static void countStrikeAndBall(){
        strikeCount = 0;
        ballCount = 0;

        for(int i=0; i<computerNumber.size(); i++){
            if(computerNumber.get(i) == userNumber.get(i)){
                strikeCount++;
            }else if(computerNumber.contains(userNumber.get(i))){
                ballCount++;
            }
        }
    }

    public static void printStrikeAndBall(){
        if(ballCount > 0){
            System.out.print(ballCount + "볼 " + strikeCount + "스트라이크");
        }else if(strikeCount > 0){
            System.out.print(strikeCount + "스트라이크");
        }else if(ballCount == 0 && strikeCount == 0){
            System.out.print("낫싱");
        }
    }
}


