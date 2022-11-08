package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isGameOver = false;

        while (!isGameOver) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = makeRandomInteger();

            // 게임 실행
            if (gaming(computer)) {
                isGameOver = !wantReGame();
            }
        }
    }
    // 재시작 메서드
    public static boolean wantReGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while(true) {
            String reGameInput = Console.readLine();
            if( reGameInput.equals("1")){
                return true;
            }
            else if(reGameInput.equals("2")){
                return false;
            }else {
                throw new IllegalArgumentException();
            }
        }

    }
    // 게임 시작
    public static boolean gaming(List<Integer> computer) {
        boolean notGameOver = true;
        while(notGameOver){
            List<Integer> user = inputNumber();
            notGameOver = !compareNum(user,computer);
        }
        return true;
    }
    // 숫자 비교
    public static boolean compareNum(List<Integer> computer, List<Integer> user) {
        int strikeCount = countStrike(computer, user);
        int ballCount = countBall(computer, user) - strikeCount;

        return isGameOverPrint(strikeCount, ballCount);
    }
    // 볼 개수 계산
    public static int countBall(List<Integer> computerNum, List<Integer> userNum) {
        int ballCount = 0;
        for(int i=0; i< computerNum.size(); i++) {
            if(computerNum.contains(userNum.get(i))){
                ballCount++;
            }
        }
        return ballCount;
    }
    // 스트라이크 개수 계산
    public static int countStrike(List<Integer> computerNum, List<Integer> userNum) {
        int strikeCount = 0;
        for (int i = 0; i < computerNum.size(); i++) {
            if (computerNum.get(i) == userNum.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
    // 비교한 숫자 결과 출력
    public static boolean isGameOverPrint(int strikeCount, int ballCount) {
        if(strikeCount==3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if(ballCount== 0 && strikeCount == 0 ){
            System.out.println("낫싱");
        }
        else if(strikeCount!=0 && ballCount!=0) {
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
        }
        else if(strikeCount==0 && ballCount!=0){
            System.out.println(ballCount+"볼");
        }
        else if(strikeCount!=0 && ballCount==0){
            System.out.println(strikeCount+"스트라이크");
        }
        return false;
    }
    // 숫자 입력
    public static List<Integer> inputNumber() {

        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> user = inputExeption();
        System.out.println(user);
        return user;
    }
    // 예외 처리 후 String to List<Integer>
    public static List<Integer> stringToListInteger(String num) {
        List<Integer> userInputNum = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            userInputNum.add(Integer.parseInt(num.charAt(i) + ""));
        }
        return userInputNum;
    }
    // 입력 예외 처리
    public static List<Integer> inputExeption() {
        List<Integer> userInputNum;
        String num = Console.readLine();

        // 3개가 아닐때
        if (num.length() != 3) {
            throw new IllegalArgumentException("숫자를 잘못입력하셨습니다. 게임을 종료합니다.");
        }

        // 숫자가 아닐때
        if (!inputExeptionIsDigit(num)) {
            throw new IllegalArgumentException("숫자를 잘못입력하셨습니다. 게임을 종료합니다.");
        }

        // 서로 다른게 아닐 때
        if (!inputExeptionIsDifferent(num)) {
            throw new IllegalArgumentException("숫자를 잘못입력하셨습니다. 게임을 종료합니다.");
        }

        // inputNumList 생성
        userInputNum = stringToListInteger(num);
        return userInputNum;
    }
    public static boolean inputExeptionIsDifferent(String num) {
        Set strSet = new HashSet();
        strSet.add(num.charAt(0));
        strSet.add(num.charAt(1));
        strSet.add(num.charAt(2));

        if (strSet.size() == 3) {
            return true;
        }
        return false;
    }

    public static boolean inputExeptionIsDigit(String num) {
        boolean isDigit;
        isDigit = Character.isDigit(num.charAt(0)) && Character.isDigit(num.charAt(1)) && Character.isDigit(num.charAt(2));
        return isDigit;
    }
    // 난수 발생기
    public static List<Integer> makeRandomInteger() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
