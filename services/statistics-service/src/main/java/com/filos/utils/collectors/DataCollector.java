package com.filos.utils.collectors;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class DataCollector implements Collector<Map<String, Long>, Map<String, Long>, Map<String, Long>> {
    @Override
    public Supplier<Map<String, Long>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, Long>, Map<String, Long>> accumulator() {
        return (provider, newValues) -> newValues.forEach((key, value) -> provider.put(key, provider.containsKey(key) ?
                                                                                            value + provider.get(key) : value
        ));
    }

    @Override
    public BinaryOperator<Map<String, Long>> combiner() {
        return (provider, newValues) -> {
            Map<String, Long> combined = new HashMap<>(provider);
            newValues.forEach((key, value) -> combined.put(key, provider.containsKey(key) ?
                                                                value + provider.get(key) :
                                                                value
            ));
            return combined;
        };
    }

    @Override
    public Function<Map<String, Long>, Map<String, Long>> finisher() {
        return o -> o;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Collector.Characteristics.CONCURRENT,
                      Collector.Characteristics.IDENTITY_FINISH);
    }

    public static Collector<Map<String, Long>, Map<String, Long>, Map<String, Long>> toMap() {
        return new DataCollector();
    }

}
