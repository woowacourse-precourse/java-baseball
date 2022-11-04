package baseball.dto;

import baseball.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectedNumberForRestartDTO {
    private static final String BLANK_INPUT_EXCEPTION_MESSAGE = "Null 또는 Empty 를 입력할 수 없습니다.";
    private static final String NUMBER_FORM_EXCEPTION_MESSAGE = "1 또는 2만 입력할 수 있습니다.";
    private static final String SELECTED_NUMBER_FORM_FOR_RESTART = "[1-2]";
    
    private final int selectedNumberForRestart;
    
    public SelectedNumberForRestartDTO(final String selectedNumberForRestart) {
        this(parseCorrectSelectedNumberForRestart(selectedNumberForRestart));
    }
    
    public SelectedNumberForRestartDTO(final int selectedNumberForRestart) {
        this.selectedNumberForRestart = selectedNumberForRestart;
    }
    
    private static int parseCorrectSelectedNumberForRestart(final String selectedNumberForRestart) {
        isValid(selectedNumberForRestart);
        return Integer.parseInt(selectedNumberForRestart);
    }
    
    private static void isValid(final String selectedNumberForRestart) {
        validateBlank(selectedNumberForRestart);
        validateSelectedNumberFormatForRestart(selectedNumberForRestart);
    }
    
    private static void validateBlank(final String selectedNumberForRestart) {
        if (StringUtils.isBlank(selectedNumberForRestart)) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    private static void validateSelectedNumberFormatForRestart(final String selectedNumberForRestart) {
        final Pattern pattern = Pattern.compile(SELECTED_NUMBER_FORM_FOR_RESTART);
        final Matcher matcher = pattern.matcher(selectedNumberForRestart);
        
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NUMBER_FORM_EXCEPTION_MESSAGE);
        }
    }
    
    public int getSelectedNumberForRestart() {
        return selectedNumberForRestart;
    }
}
