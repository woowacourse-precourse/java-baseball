package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    static List<Integer> randNumber() {
                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
        return computer;
    }
    static List<Integer> userHasNumber(int userNumber) {

        int[] Numberdata = Stream.of(String.valueOf(userNumber).split("")).mapToInt(Integer::parseInt).toArray();
        List<Integer> userNumbers = Arrays.stream(Numberdata) .boxed() .collect(Collectors.toList());
        if(!InputNumberValidator.inputNumberExceptionCheck(userNumbers))
        {
            throw new IllegalArgumentException();
        }
        return userNumbers;
    }
    static int inputUserNumber(){
        String userNumber_str;
        int userNumber;
        System.out.print("숫자를 입력해주세요 : ");
        userNumber_str = Console.readLine();
        if (userNumber_str.isBlank()) throw new IllegalArgumentException();
        try{
            userNumber = Integer.parseInt(userNumber_str);
            System.out.println(userNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return userNumber;


    }
    static int ballCheck(List<Integer> computerNumber,List<Integer>userNumber)
    {
        int ballCnt = 0;
        for(Iterator<Integer> i = userNumber.iterator(); i.hasNext();){
            if(computerNumber.contains(i.next())){
                ballCnt++;
            }
        }
        return ballCnt;
    }
    static int strikeCheck(List<Integer> computerNumber,List<Integer>userNumber)
    {
        int strikeCnt = 0;
        for(int i =0;i < userNumber.size();i++){
            if(computerNumber.get(i) == userNumber.get(i)){
                strikeCnt++;
            }
        }
        return strikeCnt;
    }
    static boolean checkGame(List<Integer> computerNumber, List<Integer> userNumber) {
        int ballCnt=ballCheck(computerNumber,userNumber);
        int strikeCnt=strikeCheck(computerNumber,userNumber);
        ballCnt = ballCnt-strikeCnt;
        if(strikeCnt == 3)
        {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        else if(ballCnt ==0 && strikeCnt ==0)
        {
            System.out.println("낫싱");
            return true;
        }
        else {
            if (ballCnt != 0) {
                System.out.print(ballCnt + "볼 ");
            }
            if (strikeCnt != 0) {
                System.out.print(strikeCnt + "스트라이크");
            }
            System.out.println("\n");
            return true;
        }
    }
    static void startGame(List <Integer> computerNumber) {
        List<Integer> userNumber = null;
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean checkPlayingGame = true;
        int input_user_number = 000;
        try {
            while (checkPlayingGame) {
                input_user_number = inputUserNumber();
                userNumber = userHasNumber(input_user_number);
                checkPlayingGame = checkGame(computerNumber, userNumber);
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }




    public static void main(String[] args) {
        // TODO: 프로그램 구현
            boolean Game = true;
            int ret = 0;
            while(Game) {
                List<Integer> computerNumber = randNumber();
                startGame(computerNumber);
                Game = reTry();
            }
    }
}
