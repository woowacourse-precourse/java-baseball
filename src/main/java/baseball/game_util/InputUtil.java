import static baseball.common.Constants.MAX_USER_NUMBER_INPUT;
    private static boolean isMaxLength(String userInput) {
        return (userInput.length() == MAX_USER_NUMBER_INPUT);
    }

    private static boolean isInRange(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicate(String userInput) {
        Set<Character> characterSet = new HashSet<>();
        for (Character character : userInput.toCharArray()) {
            characterSet.add(character);
        }
        return characterSet.size() == MAX_USER_NUMBER_INPUT;
    }

    private static boolean isDigit(String userInput) {
        return userInput.matches(Constants.VALID_NUMBER_PATTERN);
    }

