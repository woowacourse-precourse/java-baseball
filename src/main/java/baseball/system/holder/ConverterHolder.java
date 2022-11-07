package baseball.system.holder;

import baseball.system.conversion.Converter;
import baseball.system.exception.ConverterNotFoundException;

import java.util.Iterator;
import java.util.List;

public class ConverterHolder {
    private static ThreadLocal<List<Converter>> converterHolder = new ThreadLocal<>();

    public static void setConverters(List<Converter> converters) {
        converterHolder.set(converters);
    }

    public static <T extends Object> T convert(Object target, Class convertTo) {
        List<Converter> converters = converterHolder.get();
        Iterator<Converter> iterator = converters.iterator();
        while (iterator.hasNext()) {
            Converter converter = iterator.next();
            if (converter.supports(target, convertTo)) {
                return (T) converter.convert(target);
            }
        }
        throw new ConverterNotFoundException();
    }

    public static void clearHolder() {
        converterHolder.remove();
    }
}
