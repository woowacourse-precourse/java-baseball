package baseball;

public class Scorer {
    static int[] hint;
    static void findHint(String userInput, String answer) {
        hint = new int[2];
        for (int i = 0; i < userInput.length(); i++) {
            if (answer.charAt(i) == userInput.charAt(i)) {
                hint[1]++;
            } else if (answer.indexOf(userInput.charAt(i)) != -1) {
                hint[0]++;
            }
        }
    }
    public static void generateHint(String userInput, String answer) {
        StringBuilder hintOut = new StringBuilder();
        findHint(userInput, answer);
        if (hint[0] + hint[1] == 0) {
            hintOut.append("낫싱");
        }
        if (hint[0] > 0) {
            hintOut.append(String.format("%d볼 ", hint[0]));
        }
        if (hint[1] > 0) {
            hintOut.append(String.format("%d스트라이크", hint[1]));
        }
        System.out.println(hintOut.toString());
    }
}
