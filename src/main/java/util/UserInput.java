package util;

public class UserInput {

    public static boolean isValidUserInput(String userInput) {

        return hasNotCharacter(userInput) && isRightLength(userInput) && isRightRange(userInput) && isDiffer(userInput);
    }

    private static boolean hasNotCharacter(String userInput){

        final String REGEX = "[0-9]+";
        if (!userInput.matches(REGEX)){
            return false;
        }

        return true;
    }

    private static boolean isRightLength(String userInput){

        if (!(userInput.length() == Constants.NUMBER_LENGTH)){
            return false;
        }

        return true;
    }

    private static boolean isRightRange(String userInput){

        for (int i=0; i<userInput.length(); i++){
            int value = Character.getNumericValue(userInput.charAt(i));
            if (Constants.MIN_NUMBER > value || value > Constants.MAX_NUMBER){
                return false;
            }
        }

        return true;
    }

    private static boolean isDiffer(String userInput){

        for (int i=0; i<userInput.length()-1; i++){
            int curValue = Character.getNumericValue(userInput.charAt(i));
            int nextValue = Character.getNumericValue(userInput.charAt(i+1));
            if (curValue == nextValue){
                return false;
            }
        }

        return true;
    }
}
