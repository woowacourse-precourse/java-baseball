package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class Application {
    public static void makeRandomValue(List<Integer> computer){
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void checkInputNumber(String input){
        if(input.matches("[0-9]+"))
            throw new IllegalArgumentException("숫자로 이루어진 입력이 아닙니다.");
        if(input.length() != 3)
            throw new IllegalArgumentException("길이가 3인 숫자 입력이 아닙니다.");
        HashSet<Integer> checkHastSet = new HashSet<>();
        for(int i=0; i<3; i++)
            checkHastSet.add(Integer.parseInt(input.substring(i,i+1)));
        if(checkHastSet.size() != 3)
            throw new IllegalArgumentException("중복된 숫자가 포함된 숫자 입력입니다.");
    }

    public static List<Integer> makeList(String input){
        ArrayList<Integer> returnList = new ArrayList<>();
        for(int i=0; i<3; i++){
            returnList.add(Integer.parseInt(input.substring(i,i+1)));
        }
        return returnList;
    }

    public static int countStrike(List<Integer> computer, List<Integer> user){
        int count = 0;
        for(int i=0; i<3; i++){
            if(computer.get(i) == user.get(i))
                count++;
        }
        return count;
    }

    public static boolean gameOverCheck(int strikeNum){
        if(strikeNum == 3){
            int n = askRestartOrGameOver();
            if(n == 2)
                return true;
        }
        return false;
    }

    public static int askRestartOrGameOver(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨스니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        checkRestartInput(input);
        if(input.equals("1"))
            return 1;
        else
            return 2;
    }

    public static void checkRestartInput(String input){
        input.trim();
        if(input.matches("[0-9]+"))
            throw new IllegalArgumentException("숫자로 이루어진 입력이 아닙니다.");
        if(input.length() != 1)
            throw new IllegalArgumentException("길이가 1인 숫자 입력이 아닙니다.");
        if(!input.equals("1") && !input.equals("2")){
            throw new IllegalArgumentException("1 또는 2의 입력이 아닙니다.");
        }
    }

    public static int countBall(List<Integer> computer, List<Integer> user){
        int count = 0;
        for(int i=0; i<3; i++){
            if(computer.get(i) != user.get(i) && computer.contains(user.get(i)))
                count++;
        }
        return count;
    }

    public static void printResult(int strikeNum, int ballNum){
        String result = "";
        if(ballNum > 0)
            result += ballNum + "볼 ";
        if(strikeNum > 0)
            result += strikeNum + "스트라이크";
        if(strikeNum == 0 && ballNum == 0)
            result = "낫싱";
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        makeRandomValue(computer);

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            checkInputNumber(input);
            List<Integer> user = makeList(input);
            int strikeNum = countStrike(computer, user);
            boolean gameOver = gameOverCheck(strikeNum);
            if(gameOver)
                break;
            if(strikeNum == 3){
                makeRandomValue(computer);
                continue;
            }
            int ballNum = countBall(computer, user);
            printResult(strikeNum, ballNum);
        }
        System.out.println("게임 종료");
    }
}
