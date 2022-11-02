package baseball.system.conversion;

public interface Converter<F, T>  {
    T convert(F target);
}
