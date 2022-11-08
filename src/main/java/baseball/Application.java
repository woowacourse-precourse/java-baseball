package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        do {
            System.out.println("숫자 야구 게임을 시작합니다!!");
            gamePlay();
            int selectReplayNumber = selectReplay();
            if (selectReplayNumber == 2)
                break;
        }
        while(true);
    }

    public static int inputJudge(){
        while(true){
            System.out.println("재도전 하시려면 1, 종료하시려면 2를 입력하세요");
            int retryInput = Integer.parseInt(Console.readLine());
            if(retryInput == 1)
                return 1;
            if(retryInput == 2)
                return 2;
            System.out.println("잘 못 된 값")
        }

    }

    public static List<Integer> answerGenerator(){
        List<Integer> computerGeneratedNumber = new ArrayList<>();
        while (computerGeneratedNumber.size() < 3) {
            int randomAnswer = Randoms.pickNumberInRange(1,9);
            if (!computerGeneratedNumber.contains(randomAnswer)) {
                computerGeneratedNumber.add(randomAnswer);
            }
        }
        return computerGeneratedNumber;
    }

    public static String handleException(String str){
        int num = 0;
        if(str.length() != 3)
            throw new IllegalArgumentException();
        try{
            num = Integer.parseInt(str);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
        return str;
    }

    private static String userInput(){
        String str = Console.readLine();
        String result = handleException(str);
        return result;
    }

    public static



//기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다
//기능 목록:
//1. 1스트라이크
//2. 1볼
//3. 낫싱
//
//컴퓨터: 임의의 수 3개를 선택
//
//게임 방법: 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력, 컴퓨터는 입력한 숫자에 대한 결과 출력
//게임 종료: 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료

//잘못된 값 입력: IllegalArgumentException

//입력:
//1. 서로 다른 3자리의 수
//2. 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수
//
//출력:
//1. 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
//2. 다 맞추면 3스트라이크, 게임 종료
