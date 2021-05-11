package com.filos.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import com.filos.data.DataReader;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "statistics",name = "load.movie")
public class DataLoader {
    private final ReactiveRedisConnectionFactory factory;
    private final ReactiveRedisOperations<String, Long> operations;
    private final DataReader dataReader;

    @SneakyThrows
    @PostConstruct
    public void loadData() {
        factory.getReactiveConnection().serverCommands().flushAll()
               .thenMany(
                       Flux.fromIterable(dataReader.readDataFromFile().entrySet())
                           .flatMap(value -> operations.opsForValue().set(value.getKey(), value.getValue()))
               )
               .thenMany(operations.keys("*")
                                   .flatMap(operations.opsForValue()::get))
               .subscribe(System.out::println);
    }
}
