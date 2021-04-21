package com.spring.reactive;

import com.spring.reactive.model.Foo;
import com.spring.reactive.repo.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ReactiveController {

    @Autowired
    FooRepository fooRepository;

    @GetMapping(value = "/foo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Foo> getFoo() {
        return Flux.fromIterable(fooRepository.getFooList())
                .delayElements(Duration.ofSeconds(1))
                .log();
    }


}
