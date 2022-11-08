package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

/**
 * Java-baseball.
 */

public class Application {
    /**
     * userNumber를 입력받아 배열에 저장하며, 입력값이 적절한지 검사를 시행한다.
     * 입력 값이 부적절한 경우 IllegalArgumentException을 발생시킨다.
     * - Method : readFromUser, getUserAnswer, isEmpty,
     * isDifferentNumber, isInSize, toIntegerList, clear
     * - Variables : userNumber, userNumberString
     */
    public static class UserAnswer {

        public static List<Integer> userNumber = new ArrayList<>();
        public static String userNumberString;

        public static void readFromUser() {
            System.out.print("숫자를 입력해주세요 : ");
            userNumberString = Console.readLine();
        }

        public static List<Integer> getUserAnswer() {
            return userNumber;
        }

        private void isEmpty() {
            if (userNumberString.length() == 0) {
                throw new IllegalArgumentException("Please Enter number.");
            }
        }

        private void isDifferentNumber() {
            Set<Character> userNumberWithoutRedundancy = new HashSet<>();
            for (int i = 0; i < userNumberString.length(); i++) {
                userNumberWithoutRedundancy.add(userNumberString.charAt(i));
            }
            if (userNumberString.length() != userNumberWithoutRedundancy.size()) {
                throw new IllegalArgumentException();
            }
        }

        private void isInSize() {
            if (userNumberString.length() != 3) {
                throw new IllegalArgumentException("Please Enter 3 digits.");
            }
        }

        private void isNumber() {
            for (int i = 0; i < userNumberString.length(); i++) {
                if (userNumberString.charAt(i) > '9' || userNumberString.charAt(i) < '1') {
                    throw new IllegalArgumentException("Please Enter number.");
                }
            }
        }

        /**
         * String인 userNumberString 배열을 Int List인 userNumber에 저장한다.
         */
        public void toIntegerList() {
            for (int i = 0; i < userNumberString.length(); i++) {
                userNumber.add((int) (userNumberString.charAt(i) - '0'));
            }
        }

        public void clear() {
            userNumber.clear();
        }
    }

    /**
     * computerAnswer class는 아래의 역할을 수행한다.
     * - 임의의 수 3개를 computerAnswer 배열에 저장하고 리턴하는 클래스
     * - int형 ArrayList computerNumber, createRandomAnswer, getComputerAnswer
     */
    public static class ComputerAnswer {
        public static List<Integer> computerNumber = new ArrayList<>();

        /**
         * - createRandomAnswer : 난수를 3개 생성하여 computerNumber에 추가한다.
         */
        public static void createRandomAnswer() {
            while (computerNumber.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumber.contains(randomNumber)) {
                    computerNumber.add(randomNumber);
                }
            }
        }

        /**
         * - getComputerAnswer : computerNumber ArrayList를 Return한다.
         */
        public List<Integer> getComputerAnswer() {
            return computerNumber;
        }
    }

    /**
     * strikeBallCounter Class는 아래의 역할을 수행한다.
     * - userAnswer와 computerAnswer를 비교하여 strike와 ball의 개수를 count하여 return한다.
     * - int형 strikeCount, ballCount
     * - compareAnswers, isStrike, isBall, getStrikeCount, getBallCount, clear
     */
    public static class StrikeBallCounter {

        public static int strikeCount = 0;
        public static int ballCount = 0;

        private static void compareAnswers(List<Integer> userAnswer, List<Integer> computerAnswer) {
            for (int index = 0; index < computerAnswer.size(); index++) {
                if (computerAnswer.contains(userAnswer.get(index))) {
                    isStrike(userAnswer.get(index), computerAnswer.get(index));
                    isBall(userAnswer.get(index), computerAnswer.get(index));
                }
            }
        }

        private static void isStrike(Integer userNumber, Integer computerNumber) {
            if (Objects.equals(userNumber, computerNumber)) {
                strikeCount++;
            }
        }

        private static void isBall(Integer userNumber, Integer computerNumber) {
            if (!Objects.equals(userNumber, computerNumber)) {
                ballCount++;
            }
        }

        private static int getStrikeCount() {
            return strikeCount;
        }

        private static int getBallCount() {
            return ballCount;
        }

        private static void clear() {
            strikeCount = 0;
            ballCount = 0;
        }
    }

    /**
     * ProcessorPrinter Class는 아래의 역할을 수행한다.
     * - ballCount와 strikeCount가 0인지 확인하여 경우에 따른 출력 type에 맞게 count 출력한다.
     * - processAndPrint, nothing, onlyBall, onlyStrike, bothStrikeBall
     */
    public static class ProcessorPrinter {

        private static void processAndPrint(int ballCount, int strikeCount) {
            if (ballCount != 0 && strikeCount != 0) {
                bothStrikeBall();
            } else if (strikeCount != 0) {
                onlyStrike();
            } else if (ballCount != 0) {
                onlyBall();
            } else {
                nothing();
            }
        }

        private static void nothing() {
            ResultPrinter.printNothing();
        }

        private static void onlyBall() {
            ResultPrinter.printBall();
            ResultPrinter.printEndOfLine();
        }

        private static void onlyStrike() {
            ResultPrinter.printStrike();
            ResultPrinter.printEndOfLine();
        }

        private static void bothStrikeBall() {
            ResultPrinter.printBall();
            ResultPrinter.printSpace();
            ResultPrinter.printStrike();
            ResultPrinter.printEndOfLine();
        }

    }

    /**
     * ResultPrinter class는 아래의 역할을 수행한다.
     * - ProcessorPrinter에서 호출함에 따라 strike, ball count를 출력한다.
     * - printNothing, printBall, printStrike, printSpace, printEndOfLine
     */
    public static class ResultPrinter {

        private static void printNothing() {
            System.out.println("낫싱");
        }

        private static void printBall() {
            System.out.print(StrikeBallCounter.getBallCount() + "볼");
        }

        private static void printStrike() {
            System.out.print(StrikeBallCounter.getStrikeCount() + "스트라이크");
        }

        private static void printSpace() {
            System.out.print(" ");
        }

        private static void printEndOfLine() {
            System.out.println();
        }
    }

    /**
     * GameRestarter Class는 아래의 역할을 수행한다.
     * - 게임 스타트 메시지와 게임 종료 메세지를 출력한다.
     * - 리스타트 플래그를 입력받는다.
     * - printEndMessage, printStartMessage, getRestartFlag, endGame, restartGame
     */
    public static class GameRestarter {

        public static String restartFlag = "1";

        private static void printEndMessage() {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

        private static void printStartMessage() {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }

        private static String getRestartFlag() {
            restartFlag = Console.readLine();
            return restartFlag;
        }

        private static boolean endGame(String restartFlag) {
            if (restartFlag.equals("2")) {
                return true;
            }
            return false;
        }

        private static boolean restartGame(String restartFlag) {
            if (restartFlag.equals("1")) {
                return true;
            }
            return false;
        }
    }

    /**
     * main method는 순차적으로 아래의 역할을 수행한다.
     * - UserAnswer에서 userAnswer를 입력받아 userAnswer 배열에 저장한다.
     * - ComputerAnswer에서 random으로 생성한 3개의 수를 computerAnswer 배열에 저장한다.
     * - StrikeBallCounter는 값을 순차적으로 비교하여 strike와 ball count를 증가시킨다.
     * - ProcessorPrinter는 strike, ball count에 따라 적절한 출력양식을 ResultPrinter에 보낸다.
     * - ResultPrinter는 strike, ball count를 받아 출력한다.
     * - GameRestarter는 게임이 종료된 경우 RestartFlag를 입력받아 종료, 재개를 결정한다.
     */
    public static void main(String[] args) {
        int ballCount = 0;
        int strikeCount = 0;
        String restartFlag = "1";
        List<Integer> computerAnswer;
        List<Integer> userAnswer;
        ComputerAnswer comAnswer = new ComputerAnswer();
        UserAnswer myAnswer = new UserAnswer();
        GameRestarter.printStartMessage();
        while (GameRestarter.restartGame(restartFlag)) {
            computerAnswer = getComputerAnswer(comAnswer);
            while (StrikeBallCounter.getStrikeCount() != 3) {
                StrikeBallCounter.clear();
                userAnswer = getUserAnswer(myAnswer);
                StrikeBallCounter.compareAnswers(userAnswer, computerAnswer);
                ballCount = StrikeBallCounter.getBallCount();
                strikeCount = StrikeBallCounter.getStrikeCount();
                ProcessorPrinter.processAndPrint(ballCount, strikeCount);
                myAnswer.clear();
            }
            StrikeBallCounter.clear();
            computerAnswer.clear();
            GameRestarter.printEndMessage();
            restartFlag = GameRestarter.getRestartFlag();
            if (GameRestarter.endGame(restartFlag)) {
                return;
            }
        }
    }

    private static List<Integer> getComputerAnswer(ComputerAnswer comAnswer) {
        comAnswer.createRandomAnswer();
        return comAnswer.getComputerAnswer();
    }

    private static List<Integer> getUserAnswer(UserAnswer myAnswer) {
        myAnswer.readFromUser();
        myAnswer.isEmpty();
        myAnswer.isDifferentNumber();
        myAnswer.isInSize();
        myAnswer.isNumber();
        myAnswer.toIntegerList();
        return myAnswer.getUserAnswer();
    }


}
