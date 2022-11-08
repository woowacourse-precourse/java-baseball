package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean regameFlag;
        System.out.println("숫자 야구 게임을 시작합니다.");

        do { // depth = 1 -> 이제 do 내부에서 for, while, if 등은 1개까지 더 구현가능
            List<Integer> computerNumberList = computerChoiceNumbers();
            playGame(computerNumberList);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int regameNumber = getRegameNum();
            regameFlag = regameOrNot(regameNumber);
        } while (regameFlag);
    }

    public static List<Integer> computerChoiceNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int order =0;
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(order++,randomNumber);
            }
        }
        return computer;
    }

    public static void playGame(List<Integer> computerNumberList){
        boolean threeStrike;

        do{
            List<Integer> userNumberList = userChoiceNumbers();
            List<Integer> ballAndStrike = compareComputerAndUser(computerNumberList, userNumberList);
            printResult(ballAndStrike);

            threeStrike = threeStrikeOrNot(ballAndStrike); // 3스트라이크 인지 아닌지 검사 -> 3스트라이크면 true -> do-while 종료

        }while(!threeStrike);
    }

    public static List<Integer> userChoiceNumbers(){
        List<Integer> user = new ArrayList<>();
        String userNumbers;
        user.add(0,0);
        user.add(1,0);
        user.add(2,0);

        System.out.print("숫자를 입력해주세요 : ");
        userNumbers = getUserNum();
        for(int order =2; order >=0; order--) {
            user.set(order,Character.getNumericValue(userNumbers.charAt(2-order)));
        }
        return user;
    }

    public static String getUserNum() {
        String userNumbers = readLine();

        if(userNumbers.length() != 3) throw new IllegalArgumentException(); // 길이가 3인지 검사
        for(int i=0;i<userNumbers.length();i++){
            if( userNumbers.charAt(i) <48 || userNumbers.charAt(i) > 58) throw new IllegalArgumentException(); // 0~9의 숫자인지 아닌지 검사
        }

        return userNumbers;
    }

    public static List<Integer> compareComputerAndUser(List<Integer> computerNumberList,List<Integer> userNumberList){
        List<Integer> ballAndStrike = new ArrayList<>();

        ballAndStrike.add(0);
        ballAndStrike.add(0);

        int ballNum = 0;
        int strikeNum =0;
        // 어떻게 ball, strike 개수를 셀 지 만들기 -> 최적화 고민..
        for(int i=0;i<3;i++) if(computerNumberList.get(i) == userNumberList.get(i)) strikeNum++;

        if(computerNumberList.get(0) == userNumberList.get(1)) ballNum++;
        if(computerNumberList.get(0) == userNumberList.get(2)) ballNum++;
        if(computerNumberList.get(1) == userNumberList.get(0)) ballNum++;
        if(computerNumberList.get(1) == userNumberList.get(2)) ballNum++;
        if(computerNumberList.get(2) == userNumberList.get(0)) ballNum++;
        if(computerNumberList.get(2) == userNumberList.get(1)) ballNum++;

        ballAndStrike.set(0,ballNum);
        ballAndStrike.set(1,strikeNum);
        return ballAndStrike;
    }


    public static void printResult(List<Integer> ballAndStrike){
        int ballNum = ballAndStrike.get(0);
        int strikeNum = ballAndStrike.get(1);

        if( ballNum == 0 && strikeNum ==0) System.out.println("낫싱");
        else if(ballNum != 0 && strikeNum == 0) System.out.println(ballNum+"볼\n");
        else if(ballNum == 0 && strikeNum != 0) System.out.println(strikeNum+"스트라이크\n");
        else System.out.println(ballNum+"볼 "+ strikeNum+"스트라이크");
    }

    public static boolean threeStrikeOrNot(List<Integer> ballAndStrike){
        if(ballAndStrike.get(1) == 3) return true;

        else return false;
    }

}
