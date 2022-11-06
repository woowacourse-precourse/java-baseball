package baseball;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

public class Application {

    public static int Strike = 0;
    public static int Ball = 0;

    public static void main(String[] args) {
        printStartJavaBaseball();
        int[] RandomizedArray = makeRandomizedArray();
        System.out.println(Arrays.toString(RandomizedArray));

        while (Strike < 3) {
            Strike = 0;
            Ball = 0;
            int[] input = InputCheckValidAndReturn();
            NumberAndLocationEqualsAddStrike(RandomizedArray, input);
            isNumberEqualsAddBall(RandomizedArray, input);
            Ball = Ball - Strike;
            printCaseBeforeSuccess();

            if (Strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }

    }

    public static void printStartJavaBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public static int[] InputCheckValidAndReturn() {
        String InputString = descriptionAndInput("숫자를 입력해주세요:");
        char[] InputCharArray = revertStringToCharArray(InputString);
        int[] InputAsciiArray = revertCharArrayToAsciiArray(InputCharArray);

        if (!isLength3(InputAsciiArray)) {
            throw new IllegalArgumentException();
        } else if (!isAsciiArrayValid(InputAsciiArray)) {
            throw new IllegalArgumentException();
        }
        return revertCharArrToIntArr(InputCharArray);
    }

    public static int[] revertCharArrToIntArr(char[] charArr) {
        int[] intArr = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            intArr[i] = Integer.parseInt(String.valueOf(charArr[i]));
        }
        return intArr;
    }


    public static String descriptionAndInput(String description) {
        System.out.print(description);

        return readLine();
    }

    public static char[] revertStringToCharArray(String input) {
        return input.toCharArray();
    }

    public static int[] revertCharArrayToAsciiArray(char[] charArray) {
        int[] asciiArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            asciiArray[i] = charArray[i];
        }
        return asciiArray;
    }

    public static boolean isLength3(int[] array) {
        return (array.length == 3);
    }

    public static boolean isAsciiArrayValid(int[] asciiArray) {
        int count = 0;
        for (int asciiValue : asciiArray) {
            if (asciiValue >= 49 && asciiValue <= 59) {
                count++;
            }
        }
        return (count == 3);
    }

    public static int[] makeRandomizedArray() {
        List<Integer> numbers= new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        int[] RandomArray = new int[3];
        for (int i = 0; i < 3; i++) {
            RandomArray[i] = pickNumberInList(numbers);
            numbers.remove(Integer.valueOf(RandomArray[i]));
        }
        return RandomArray;
    }

    public static void NumberAndLocationEqualsAddStrike(int[] RandomNumber, int[] inputNumber) {

        for (int i = 0; i < RandomNumber.length; i++) {
            if (RandomNumber[i] == inputNumber[i]) {
                Strike++;
            }
        }
    }


    public static void isNumberEqualsAddBall(int[] RandomNumber, int[] inputNumber) {

        for (int i = 0; i < RandomNumber.length; i++) {
            for (int j = 0; j < RandomNumber.length; j++) {
                AddBallIfEquals(RandomNumber[i], inputNumber[j]);
            }
        }

    }

    public static void AddBallIfEquals(int RandomNumber, int InputNumber) {
        if (RandomNumber == InputNumber) {
            Ball++;
        }
    }

    public static void printCaseBeforeSuccess() {
        if ((Ball == 0) && (Strike == 0)) {
            System.out.println("낫싱");
        }
        if ((Ball != 0) && (Strike != 0)) {
            System.out.println(Ball + " 볼 " + Strike + " 스트라이크");
        }
        if ((Strike == 0) && (Ball != 0)) {
            System.out.println(Ball + " 볼");
        }
        if ((Ball == 0) && (Strike != 0) && (Strike !=3)) {
            System.out.println(Strike + " 스트라이크");
        }
    }

    public static void afterGameEnded(){
        String input= descriptionAndInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}


