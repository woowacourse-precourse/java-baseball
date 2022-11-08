package baseball.service;

import java.util.ArrayList;

public class GameService {


    public void checkInputPlayerNumber(String inputPlayerNumbers){
        checkForCharacterExistence(inputPlayerNumbers);
        checkTheLength(inputPlayerNumbers);
        checkForDuplicateNumber(inputPlayerNumbers);
        checkThePresenceOfZeros(inputPlayerNumbers);
    }

    public void checkTheLength(String inputPlayerNumbers){
        if (inputPlayerNumbers.length() != 3) {
            throw  new IllegalArgumentException();
        }
    }

    public void checkForDuplicateNumber(String inputPlayerNumbers){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0;i<3;i++) {
            if (numbers.contains(Character.getNumericValue(inputPlayerNumbers.charAt(i)))){
                throw  new IllegalArgumentException();
            }
            numbers.add(Character.getNumericValue(inputPlayerNumbers.charAt(i)));
        }
    }

    public void checkThePresenceOfZeros(String inputPlayerNumbers){
        if (inputPlayerNumbers.contains("0")){
            throw  new IllegalArgumentException();
        }
    }

    public void checkForCharacterExistence(String inputPlayerNumbers){
        for (int i=0;i<3;i++) {
            try{
                Integer.parseInt(inputPlayerNumbers);
            }catch (IllegalArgumentException e){
                throw  new IllegalArgumentException();
            }
        }
    }

}
