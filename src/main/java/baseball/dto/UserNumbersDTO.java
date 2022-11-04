package baseball.dto;

import baseball.utils.StringUtils;

public class UserNumbersDTO {
    private static final String BLANK_INPUT_EXCEPTION_MESSAGE = "Null 또는 Empty 를 입력할 수 없습니다.";
    
    private final String userNumbers;
    
    public UserNumbersDTO(final String userNumbers) {
        validateBlank(userNumbers);
        this.userNumbers = userNumbers;
    }
    
    private void validateBlank(final String userNumbers) {
        if (StringUtils.isBlank(userNumbers)) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    public String getUserNumbers() {
        return userNumbers;
    }
}
