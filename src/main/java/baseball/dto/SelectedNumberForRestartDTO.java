package baseball.dto;

import baseball.utils.StringUtils;

public class SelectedNumberForRestartDTO {
    private static final String BLANK_INPUT_EXCEPTION_MESSAGE = "Null 또는 Empty 를 입력할 수 없습니다.";
    
    private final int selectedNumberForRestart;
    
    public SelectedNumberForRestartDTO(final String selectedNumberForRestart) {
        this(parseCorrectSelectedNumberForRestart(selectedNumberForRestart));
    }
    
    public SelectedNumberForRestartDTO(final int selectedNumberForRestart) {
        this.selectedNumberForRestart = selectedNumberForRestart;
    }
    
    private static int parseCorrectSelectedNumberForRestart(final String selectedNumberForRestart) {
        validateBlank(selectedNumberForRestart);
        return Integer.parseInt(selectedNumberForRestart);
    }
    
    private static void validateBlank(final String selectedNumberForRestart) {
        if (StringUtils.isBlank(selectedNumberForRestart)) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    public int getSelectedNumberForRestart() {
        return selectedNumberForRestart;
    }
}
