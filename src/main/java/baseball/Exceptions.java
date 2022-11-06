package baseball;

import constantfield.*;

public class Exceptions {

    public static void checkInputIsNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.ISNOTNUMBER);
        }
    }

    public static void checkInputIsTooLong(String userInput) {
        if (userInput.length() > Detail.LENGTH) {
            throw new IllegalArgumentException(Message.ISTOOLONG);
        }
    }

    public static void checkInputIsTooShort(String userInput) {
        if (userInput.length() < Detail.LENGTH) {
            throw new IllegalArgumentException(Message.ISTOOSHORT);
        }
    }

    public static void checkOpinionMessage(String userOpinion) {
        if (!(userOpinion.equals(Message.REPLAY) || userOpinion.equals(Message.END)))
            throw new IllegalArgumentException(Message.ISWRONGCOMMAND);
    }
}
