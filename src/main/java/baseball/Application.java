package baseball;


import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    public static int Strike = 0;
    public static int Ball = 0;

    public static void main(String[] args) {
        printStartJavaBaseball();
        int[] RandomizedArray = makeRandomizedArray();

        while (Strike < 3) {
            int[] input = InputCheckValidAndReturn();
            NumberAndLocationEqualsAddStrike(RandomizedArray, input);
            isNumberEqualsAddBall(RandomizedArray, input);
            Ball = Ball - Strike;
            printCaseBeforeSuccess();

        }
    }

    public static void printStartJavaBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public static int[] InputCheckValidAndReturn() {
        String InputString = descriptionAndInput();
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


    public static String descriptionAndInput() {
        System.out.print("숫자를 입력해주세요:");

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
        int[] RandomArray = new int[3];
        for (int i = 0; i < 3; i++) {
            RandomArray[i] = pickNumberInRange(1, 9);
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


    public static boolean isNumberEqualsAddBall(int[] RandomNumber, int[] inputNumber) {

        for (int i = 0; i < RandomNumber.length; i++) {
            for (int j = 0; j < RandomNumber.length; j++) {
                AddBallIfEquals(RandomNumber[i], inputNumber[j]);
            }
        }

        return (Ball > 0);
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
        if ((Ball == 0) && (Strike != 0)) {
            System.out.println(Strike + " 스트라이크");
        }
    }


}


