package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    static boolean isInputSizeEqualToAnswerSize(String playerInput){
        return playerInput.length() == Game.ANSWER_SIZE;
    }

    static boolean doesNotHaveDuplicateInputElement(String playerInput){
        List<String> guessTokenList = Arrays.asList(playerInput.split(""));
        Set<String> guessTokenSet = new HashSet<>(guessTokenList);

        return guessTokenList.size() == guessTokenSet.size();
    }
}
