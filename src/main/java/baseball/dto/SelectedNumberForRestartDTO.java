package baseball.dto;

public class SelectedNumberForRestartDTO {
    private final int selectedNumberForRestart;
    
    public SelectedNumberForRestartDTO(final String selectedNumberForRestart) {
        this(Integer.parseInt(selectedNumberForRestart));
    }
    
    public SelectedNumberForRestartDTO(final int selectedNumberForRestart) {
        this.selectedNumberForRestart = selectedNumberForRestart;
    }
    
    public int getSelectedNumberForRestart() {
        return selectedNumberForRestart;
    }
}
