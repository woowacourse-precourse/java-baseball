package baseball;

import java.util.List;

public class Validity {


    public void isNumberValid(String input){
        char[] charArray = Revert.revertStringToCharArray(input);
        isInputNumberLength3(charArray);
        isInputNumberIs1To9(charArray);
        isNumberOverlaped(input);
    }
    private void isInputNumberLength3(char[] InputCharArray) {
        int[] inputAsciiArray = Revert.revertCharArrayToAsciiArray(InputCharArray);

        if (!isLength3(inputAsciiArray) ) {
            throw new IllegalArgumentException();
        }
    }
    private void isInputNumberIs1To9(char[] InputCharArray) {
        int[] inputAsciiArray = Revert.revertCharArrayToAsciiArray(InputCharArray);

        if (!isAsciiArrayValid(inputAsciiArray) ) {
            throw new IllegalArgumentException();
        }
    }


    private boolean isAsciiArrayValid(int[] asciiArray) {
        int count = 0;
        for (int asciiValue : asciiArray) {
            if (asciiValue >= 49 && asciiValue <= 59) {
                count++;
            }
        }
        return (count == 3);
    }

    private boolean isLength3(int[] array) {
        return (array.length == 3);
    }

    public static boolean checkEndInput(String inputString){

        if ((Integer.parseInt(inputString) == 1)) {
            return true;
        } else if (Integer.parseInt(inputString) == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void isNumberOverlaped(String inputString){
        List<Integer> inputList= Revert.revertStringToList(inputString);
        int count=0;
        for(int i=0; i<inputList.size(); i++){
            if(inputList.contains(inputList.get(i))){
                count++;
            }
        }
        if(!(count ==3)){
             throw new IllegalArgumentException();
        }
    }

}
