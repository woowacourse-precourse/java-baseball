package baseball.domain;

public interface Verification{

    void onlyNumberVerification(String str);
    void lengthVerification(String str);
    void rangeVerification(String str);

    void uniqueNumberVerification(String str);
}
