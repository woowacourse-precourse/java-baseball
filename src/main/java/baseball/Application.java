package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static final int numLen = 3;
    private static List<Integer> computerNum;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }
    public static void startGame(){
        computerNum = getRandomNum();
    }

    public static List<Integer> getRandomNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < numLen) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    public static List<Integer> getInputNum(){
        List<String> numbers = new ArrayList<>(List.of("1","2","3","4","5","6","7","8","9"));

        System.out.print("숫자를 입력해주세요: ");
        String userInput = Console.readLine();
        System.out.println(userInput);

        String[] inputNum = userInput.split("");
        List<Integer> userNum = new ArrayList<>();

        exception(numbers, userInput, inputNum, userNum);

        return userNum;
    }

    public static void exception(List<String> numbers, String userInput, String[] inputNum, List<Integer> userNum){
        if(userInput.contains("0")){
            throw new IllegalArgumentException("1부터 9사이의 숫자만 입력해주세요.");
        }
        for(int inputIdx=0; inputIdx < inputNum.length; inputIdx++){
            if(!numbers.contains(inputNum[inputIdx])){
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
            else{
                userNum.add(Integer.valueOf(inputNum[inputIdx]));
            }
        }
        if (userNum.size()!=numLen){
            throw new IllegalArgumentException("3자리의 숫자만 입력해주세요.");
        }
        int cnt = 0;
        int startIdx = 0;
        int endIdx = 1;
        while(cnt<numLen){
            if(userNum.get(startIdx).equals(userNum.get(endIdx))){
                throw new IllegalArgumentException("중복된 값이 입력되었습니다.");
            }
            else if(endIdx!=numLen-1){
                endIdx++;
            }
            else if(endIdx==numLen-1){
                startIdx++;
            }
            cnt++;
        }
    }


    public static int CountBall(List<Integer> computerNum, List<Integer> userNum){
        int ballCnt=0;
        int cnt=0;
        int startIdx=0;
        int endIdx=0;

        while(cnt<numLen*numLen){
            if(startIdx!=endIdx && computerNum.get(startIdx).equals(userNum.get(endIdx))){
                ballCnt++;
            }
            endIdx++;
            cnt++;
            if(endIdx==3){
                startIdx++;
                endIdx=0;
            }
        }
        return ballCnt;
    }
    public static int CountStrike(List<Integer> computerNum, List<Integer> userNum){
        int strikeCnt=0;
        for (int index = 0; index < numLen; index++) {
            if(computerNum.get(index).equals(userNum.get(index))){
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public static String getHint(int ballCnt, int strikeCnt) {
        String result = "";
        if(ballCnt+strikeCnt==0){
            System.out.println("낫싱");
            result = "낫싱";
        }
        else if(ballCnt>0 && strikeCnt==0){
            System.out.println(ballCnt+"볼");
            result = ballCnt+"볼";
        }
        else if(ballCnt==0 && strikeCnt>0){
            System.out.println(strikeCnt+"스트라이크");
            result = strikeCnt+"스트라이크";
        }
        else if(ballCnt>0 && strikeCnt>0){
            System.out.println(ballCnt+"볼"+" "+strikeCnt+"스트라이크");
            result = ballCnt+"볼"+" "+strikeCnt+"스트라이크";
        }
        return result;
    }
}
