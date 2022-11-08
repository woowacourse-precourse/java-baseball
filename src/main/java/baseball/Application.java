package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

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



public class Application {
    public static void main(String[] args) {
        do {
            System.out.println("숫자 야구 게임을 시작합니다!!");
            gamePlay();
            int selectReplayNumber = inputJudge();
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
            System.out.println("잘 못 된 값");
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

    public static String BaseBallScore(List<Integer> RandomNum, String num) {

        int ballCount = 0;
        int strikeCount = 0;

        String result = null;

        List<Integer> scoreList = new ArrayList<>();
        scoreList.add(num.charAt(0) - '0');
        scoreList.add(num.charAt(1) - '0');
        scoreList.add(num.charAt(2) - '0');

        for(int i = 0; i < 3; i++){
            int userRandomNum = RandomNum.get(i);
            if(scoreList.contains(userRandomNum) && scoreList.get(i)==userRandomNum){
                strikeCount ++;
            }
            else if (scoreList.contains(userRandomNum)) {
                ballCount ++;
            }
        }
        String strikeShow = "";
        String ballShow = "";
        if (strikeCount > 0)
            strikeShow = strikeCount + "스트라이크";
        if(ballCount > 0)
            ballShow = ballCount + "볼";

        String finalResult = ballShow + " " + strikeShow;
        if(ballCount + strikeCount > 0 )
            return finalResult.trim();
        return "낫싱";
    }

    public static void gamePlay() {
        List<Integer> RandomAnswer = answerGenerator();
        while (true) {
            System.out.print("3자리 숫자를 입력해 주세요: ");
            String inputNum = userInput();
            String finalResult = BaseBallScore(RandomAnswer, inputNum);
            System.out.println(finalResult);
            if (finalResult.equals("3스트라이크")) {
                System.out.println("축하드립니다! 게임 종료");
                break;
            }
        }
    }
}




