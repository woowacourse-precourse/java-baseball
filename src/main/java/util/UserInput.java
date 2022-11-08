package util;

public class UserInput {

    public static boolean isValidUserInput(String userInput) {

        return hasNotCharacter(userInput) && isRightLength(userInput) && isRightRange(userInput) && isNotDuplicate(userInput);
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

    private static boolean isNotDuplicate(String userInput){

        for (int i= 0; i<userInput.length(); i++){
            if (isSame(i, userInput)){
                return false;
            }
        }

        return true;
    }

    private static boolean isSame(int curIndex, String userInput) {

        for (int i=0; i<userInput.length(); i++){

            int curValue = Character.getNumericValue(userInput.charAt(curIndex));
            int nextValue = Character.getNumericValue(userInput.charAt(i));
            if (i != curIndex && curValue == nextValue){
                return true;
            }
        }

        return false;
    }

    public static boolean isValidGameStateInput(String userInput) {
        return isValidRestart(userInput) || isValidEnd(userInput);
    }

    private static boolean isValidRestart(String userInput) {

        if (hasNotCharacter(userInput)){
            if (userInput.equals(Integer.toString(Constants.RESTART))){
                return true;
            }
        }

        return false;
    }
    private static boolean isValidEnd(String userInput) {

        if (hasNotCharacter(userInput)){
            if (userInput.equals(Integer.toString(Constants.END))){
                return true;
            }
        }
        return false;
    }

}
