package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        int userEndingResponse = 1;
        int userAnswer;
        int countStrike = 0;
        int countBall;
        List<Integer> computerAnswerList;
        List<Integer> notStrikeZone;
        List<Integer> userAnswerList;

        while (userEndingResponse == 1){

            printStartMessage();
            computerAnswerList = createComputerLength3IntegerAnswerToList();
            /* ����
            computerAnswerList.add(7);
            computerAnswerList.add(1);
            computerAnswerList.add(3);
            */

            while (countStrike!=3){

                printGetInputMessage();
                userAnswer = getUserNumberToInteger();
                checkIllegalInputForBaseballGame(userAnswer);
                userAnswerList = convertIntegerToList(userAnswer);

                notStrikeZone = checkWhereIsNotStrike(computerAnswerList, userAnswerList);
                countStrike = countStrike(notStrikeZone);
                countBall = countBall(computerAnswerList, userAnswerList, notStrikeZone);
                printUserScore(countStrike, countBall);
            }

            printEndingMessage();
            userEndingResponse = getUserNumberToInteger();
            countStrike = 0;
        }
        // TODO: ���α׷� ����
    }

    public static List<Integer> createComputerLength3IntegerAnswerToList(){
        List<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        return computerAnswer;
    }

    public static void printStartMessage(){
        System.out.println("���� �߱� ������ �����մϴ�.");
    }
    public static void printGetInputMessage(){
        System.out.print("���ڸ� �Է����ּ��� : ");
    }
    public static int getUserNumberToInteger() {
        String userAnswer = Console.readLine();
        return Integer.parseInt(userAnswer);
    }
    public static List<Integer> convertIntegerToList(int num){
        List<Integer> numList = new ArrayList<>();

        String numStr = String.valueOf(num);
        for (String tmpStr : numStr.split("")){
            numList.add(Integer.valueOf(tmpStr));
        }

        return numList;
    }
    public static void checkIllegalInputForBaseballGame(int input){

        // 1. 3�ڸ��� �ƴ� ���
        String inputStr = String.valueOf(input);
        int lengthOfInput = inputStr.length();
        if (lengthOfInput != 3)
            throw new IllegalArgumentException("������ ��� �ڸ����� 0�� ���Ե��� �ʴ� 3�ڸ��� ���ڸ� �Է��Ͻʽÿ�.");

        List<Character> appearedNumList = new ArrayList<>();
        for (int inputStringIndex = 0; inputStringIndex < lengthOfInput; inputStringIndex++){

            // 2. ���� 1-9 �̿��� ���� ���ԵǾ����� ��
            char tmpInputStr = inputStr.charAt(inputStringIndex);
            if (tmpInputStr < 49 || tmpInputStr > 58)
                // 1: 49, 9: 57
                throw new IllegalArgumentException("1~9 ������ ���ڸ� �����մϴ�.");

            // 3. 3�ڸ� �� �� �ߺ��� ���� ��
            if (appearedNumList.contains(tmpInputStr))
                throw new IllegalArgumentException("3�ڸ��� ���� �� �ߺ��Ǵ� ���� �����ؼ��� �ȵ˴ϴ�.");
            else
                appearedNumList.add(tmpInputStr);
        }
    }

    public static List<Integer> checkWhereIsNotStrike(List<Integer> computerAnswer,
                                                   List<Integer> userAnswer){
        List<Integer> notStrikeZone = new ArrayList<>();
        for (int digit=0; digit<3; digit++){
            if (!computerAnswer.get(digit).equals(userAnswer.get(digit)))
                notStrikeZone.add(digit);
        }
        return notStrikeZone;
    }
    public static int countStrike(List<Integer> notStrikeList){
        return 3 - notStrikeList.size();
    }
    public static void printEndingMessage(){
        System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����\n" +
                            "������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
    }
    public static int countBall(List<Integer> computerAnswer,
                                 List<Integer> userAnswer,
                                 List<Integer> notStrikeList){
        int countBall = 0;
        for (int digit : notStrikeList){
            if (computerAnswer.contains(userAnswer.get(digit)))
                countBall++;
        }
        return countBall;
    }
    public static void printUserScore(int countStrike, int countBall){
        if (countStrike!=0) {
            if (countStrike == 3 || countBall == 0)
                System.out.println(countStrike + "��Ʈ����ũ");
            else
                System.out.println(countBall+"�� "+countStrike+"��Ʈ����ũ");
        } else {
            if (countBall != 0)
                System.out.println(countBall+"��");
            else
                System.out.println("����");
        }
    }
}