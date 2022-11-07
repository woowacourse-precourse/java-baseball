package baseball.referee;

import baseball.console.ConsoleOutput;
import baseball.hint.Hint;
import baseball.hint.HintType;

import static baseball.hint.HintType.*;
import static baseball.referee.JudgeType.GAME_WIN;
import static baseball.util.CharacterUtil.SPACE;

public class Megaphone {
    private final ConsoleOutput consoleOutput = new ConsoleOutput();

    public void speakGameStart() {
        consoleOutput.printStartGame();
    }

    public void speakToInputNumbers() {
        consoleOutput.printExplainToInputNumbers();
    }

    public void speakJudgement(JudgeType judgeType, Hint hint) {
        String hintMessage = composeHint(hint);
        consoleOutput.printHint(hintMessage);
        if (judgeType == GAME_WIN) {
            consoleOutput.printWinner();
        }
    }

    private String composeHint(Hint hint) {
        if (hint.isNothing()) {
            return NOTHING.getHintType();
        }

        StringBuilder hintBuilder = new StringBuilder();
        handleHintBuilder(hint, BALL, hintBuilder);
        handleHintBuilder(hint, STRIKE, hintBuilder);
        return hintBuilder.toString();
    }

    private void handleHintBuilder(Hint hint, HintType hintType, StringBuilder hintBuilder) {
        if (hint.isExistsFrom(hintType)) {
            hintBuilder.append(hint.findCountBy(hintType))
                    .append(hintType.getHintType())
                    .append(SPACE.getUnit());
        }
    }
}
