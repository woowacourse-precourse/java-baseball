package baseball.utils.converter;

public interface Converter<S, T> {
    T convert(S source);
}
