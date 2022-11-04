package baseball.dto;

public class UserNumbersDTO {
    private final String userNumbers;
    
    public UserNumbersDTO(final String userNumbers) {
        this.userNumbers = userNumbers;
    }
    
    public String getUserNumbers() {
        return userNumbers;
    }
}
