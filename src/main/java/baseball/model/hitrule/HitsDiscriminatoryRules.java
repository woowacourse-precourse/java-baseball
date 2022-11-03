package baseball.model.hitrule;

public interface HitsDiscriminatoryRules {
    boolean isType(String homeRun, String hits, int index);
}
