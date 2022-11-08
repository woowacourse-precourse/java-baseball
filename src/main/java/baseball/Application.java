package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final int len = 3; //항상 3자리 수로 고정이므로 len변수에 값 저장
    private static List<Integer> computerNum; //컴퓨터 숫자

    public static void main(String[] args) {

    }


    //1. 컴퓨터 3자리 랜덤 숫자 생성
    public static List<Integer> getComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < len) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    //2번부터 4번까지 반복
    //2. 사용자가 3자리 숫자 입력
    public static List<Integer> getUserNum(){
        List<String> scope = new ArrayList<>(List.of("1","2","3","4","5","6","7","8","9"));

        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        System.out.println(input);

        String[] inputArray = input.split(""); //사용자가 입력한 숫자 쪼개기
        List<Integer> userNum = new ArrayList<>(); //사용자가 입력한 최종 숫자
        userException(scope, input, inputArray, userNum); //예외상황 판별

        return userNum;
    }

    //2-1. 사용자가 3자리 숫자 입력 예외상황
    public static void userException(List<String> scope, String userInput, String[] inputArray, List<Integer> userNum){
        //0 입력
        if(userInput.contains("0")){
            throw new IllegalArgumentException("다시 입력해주세요.");
        }

        //3자리의 수가 아닐 때
        if (userInput.length()!=len){
            throw new IllegalArgumentException("다시 입력해주세요.");
        }

        //숫자 중복되었을 때
        int cnt = 0;
        int left = 0;
        int right = 1;
        while(cnt < len){
            if(inputArray[left].equals(inputArray[right])){
                throw new IllegalArgumentException("다시 입력해주세요.");
            }
            else if (right != len-1){
                right++;
            }
            else {
                left++;
            }
            cnt++;
        }

        //문자를 입력했을 때
        for(int i=0; i<inputArray.length; i++){
            if(!scope.contains(inputArray[i])){
                throw new IllegalArgumentException("다시 입력해주세요.");
            }
            else{
                userNum.add(Integer.valueOf(inputArray[i]));
            }
        }
    }





}
