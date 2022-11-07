package baseball.system.conversion;

public interface Converter<F, T>  {
    boolean supports(Object from, Class<?> to);

    T convert(F target);
}
