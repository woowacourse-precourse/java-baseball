package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int GameSwitch = 1;
        StartGame(GameSwitch);


    }
    public static void StartGame(int GameSwitch){
        while(GameSwitch==1){
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = getNumberBaseball();
            GameSwitch=checkNumber(computer);
        }

    }

    public static List<Integer> getNumberBaseball() {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            checkDuplicate(randomNumber, computer);
        }
        return computer;
    }

    public static void checkDuplicate(int randomNumber, List<Integer> computer) {

        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    public static List<Integer> getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String tryNumber = Console.readLine();
        List<Integer> user = transformInteger(tryNumber);
        return user;

    }

    public static List<Integer> transformInteger(String tryNumber) {

        List<Integer> Number = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Number.add(Character.getNumericValue(tryNumber.charAt(i)));
        }

        return Number;
    }

    public static int checkNumber(List<Integer> computer) {
        while(true) {
            List<Integer> user = getInput();
            int strikeCount = strikeCount(user, computer);
            if(strikeCount==3){
                break;
            }
            int ballCount = ballCount(user, computer);
            resultAnswer(strikeCount, ballCount);
            System.out.println();
        }
        return CheckGameover();


    }

    public static int strikeCount(List<Integer> user, List<Integer> computer) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            strikeCount += strikeCheck(user.get(i), computer.get(i));
        }
        return strikeCount;
    }

    public static int strikeCheck(int user, int computer) {

        if (user == computer) {
            return 1;
        }
        return 0;
    }

    public static int ballCount(List<Integer> user, List<Integer> computer) {

        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            ballCount += ballCheck(user.get(i), computer, i);
        }
        return ballCount;
    }

    public static int ballCheck(int user, List<Integer> computer, int index) {

        if (computer.contains(user)) {
            return ballorstrikeCheck(user, computer, index);
        }
        return 0;
    }

    public static int ballorstrikeCheck(int user, List<Integer> computer, int index) {

        if (index != computer.indexOf(user)) {
            return 1;
        }
        return 0;
    }

    public static void resultAnswer(int strikeCount, int ballCount) {

        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("나싱");

        } else {
            ballAnswer(ballCount);
            strikeAnswer(strikeCount);
        }
    }

    public static void ballAnswer(int ballCount) {

        if (ballCount > 0) {
            System.out.print(ballCount + " 볼 ");
        }
    }

    public static void strikeAnswer(int strikeCount) {

        if (strikeCount > 0) {
            System.out.print(strikeCount + " 스트라이크 ");
        }
    }
    public static int CheckGameover(){
        printWin();
        return gameSwitch();
    }
    public static void printWin(){
        System.out.println("3 스트라이크 ");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static int gameSwitch() {

        String regameAnswer = Console.readLine();
       return reGame(regameAnswer);
    }
    public static int reGame(String regameAnswer){
        if (regameAnswer.equals("1")) {
            return 1;
        } else if (regameAnswer.equals("2")) {
            return 2;
        } else return 3;
    }
    }

