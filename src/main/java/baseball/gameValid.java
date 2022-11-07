package baseball;

import java.util.List;

public class gameValid {


    public List<String> Check_Duplication_with_Exception(List<String> threeNumber,String inputNumberFromUser) {
        for (int readLoop = 0; readLoop < 3; readLoop++) {
            String number = String.valueOf(inputNumberFromUser.charAt(readLoop));



            if (!(threeNumber.contains(number)) && !(number.equals("0"))) {
                threeNumber.add(number);
            } else {

                throw new IllegalArgumentException();
            }
        }
        return threeNumber;
    }



    public void validationIsNumber(String inputNumberFromUser) {
        if (inputNumberFromUser.length() != 3 ||
                !(inputNumberFromUser.chars().allMatch(Character::isDigit))) {
            throw new IllegalArgumentException();
        }
    }
}