package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

/*
1. 게임을 시작한다. -> 게임 시작 메소드 필요
2. 서로 다른 세 자리의 숫자를 생성한다(pickNumberInRange() 이용). -> 난수 발생 메소드 필요
    1. 1~9 사이의 100의 자리 숫자가 먼저 생성되며 배열의 첫 번째로 들어간다.
    2. 1~9 사이의 100의 자리 숫자와 다른 10의 자리 숫자를 배열의 두 번째 자리에 넣는다.
    3. 1~9 사이의 100의 자리 숫자와 10의 자리 숫자와 다른 숫자를 1의 자리 숫자를 배열의 세 번째 자리에 넣는다.
3. 세 자리 수를 정확히 맞출 때까지 반복한다. -> 정답 맞추는 메서드 제시
    1. 참여자로부터 세 자리 숫자를 숫자로 받은 후 검사 후 문자열로 변경한다.
        1-1. 세 자리가 아닌 경우 다시 입력하라는 예외처리(100~999가 아닌 경우)
        1-2. 받은 세 자리 수를 문자열로 변환한 후 10의 자리와 1의 자리가 0인 경우 예외처리
    2. 문자열로 받은 숫자의 각 자리 수를 돌며 같은 자리수에 같은 숫자가 위치하면 스트라이크 카운트를 올린다.
        2-1. 자리수가 다르지만 같은 숫자가 있을 경우 볼 카운트를 올린다.
    3. 볼 카운트와 스트라이크 카운트 수를 알려주며 둘 다 0일 경우 낫싱임을 알린다.
    4. 3스트라이크가 아닌 경우 다시 맞출 때까지 while 반복문을 돈다.
4. 정답을 맞추면 다시 시작할지 종료할지 선택한다.
 */
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Game {

    // 1. 난수 발생 메서드 구현
    public ArrayList<Integer> makingRandomNum() {
        ArrayList<Integer> randomNum = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            randomNum.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNum;
    }

    // 1. 참여자 숫자 입력 메서드
    public String inputNum(){
        return Console.readLine();
    }

}

class ErrorChecking{
    public static boolean errorChecking(String inputNum){
        return checkingInputNum(inputNum) && checkingContaingZero(inputNum) && checkingDigit(inputNum);
    }
    // 2. 참여자 입력 숫자 점검
    public static boolean checkingInputNum(String inputNum) {
        try {
            Integer.parseInt(inputNum);
        } catch (Exception e) {
            try {
                throw new IllegalArgumentException("각 자릿수가 1~9 사이의 정수로 이루어진 세 자리 숫자를 입력해주세요");
            } catch (IllegalArgumentException exception) {
                return false;
            }
        }
        return true;
    }

    // 3. 참여자가 입력 숫자가 세 자리 숫자인지 확인하는 메서드
    public static boolean checkingDigit(String inputNum){
        if(inputNum.length() !=3){
            try {
                throw new IllegalArgumentException("세 자리 정수를 입력해주세요");
            } catch (IllegalArgumentException e){
                return false;
            }
        }
        return true;
    }

    public static boolean checkingContaingZero(String inputNum){
        if(inputNum.contains("0")){
            try {
                throw new IllegalArgumentException("각 자릿수에는 0이 들어가지 않습니다.");
            }catch (IllegalArgumentException e){
                return false;
            }
        }
        return true;
    }
}
