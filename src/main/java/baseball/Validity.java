package baseball;

public class Validity {

    public int[] InputCheckValidAndReturn() {
        Revert revert = new Revert();
        Computer computer = new Computer();

        String InputString = computer.descriptionAndInput("숫자를 입력해주세요:");
        char[] InputCharArray = revert.revertStringToCharArray(InputString);
        int[] InputAsciiArray = revert.revertCharArrayToAsciiArray(InputCharArray);

        isInputNumberValid(InputAsciiArray);

        return revert.revertCharArrToIntArr(InputCharArray);
    }

    public void isInputNumberValid(int[] inputAsciiArray) {

        if (!isLength3(inputAsciiArray)) {
            throw new IllegalArgumentException();
        } else if (!isAsciiArrayValid(inputAsciiArray)) {
            throw new IllegalArgumentException();
        }
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

    public static boolean isLength3(int[] array) {
        return (array.length == 3);
    }

    public void checkEndInput(String input){
        InGame game= new InGame();

        if ((Integer.parseInt(input) == 1)) {
            game.afterGameStart();
        } else if (Integer.parseInt(input) == 2) {

        } else {
            throw new IllegalArgumentException();
        }
    }
}
