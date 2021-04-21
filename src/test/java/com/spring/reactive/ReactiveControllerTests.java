package com.spring.reactive;

import com.spring.reactive.model.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReactiveControllerTests {

    @Autowired
    WebTestClient webTestClient;


    @BeforeEach
    public void setUp() {
        webTestClient = webTestClient
                .mutate()
                .responseTimeout(Duration.ofMillis(50000))
                .build();
    }

    @Test
    public void testGetFoo() {
        webTestClient.get()
                .uri("/foo")
                .accept(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE))
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Foo.class)
                .consumeWith(response -> {
                    Assertions.assertEquals(response.getResponseBody(), getFooList());
                });
    }

    private List<Foo> getFooList() {
        List<Foo> fooList = new ArrayList<>();
        fooList.add(new Foo(1, "abc"));
        fooList.add(new Foo(2, "bcd"));
        fooList.add(new Foo(3, "cde"));
        fooList.add(new Foo(4, "efg"));
        fooList.add(new Foo(5, "ghi"));
        fooList.add(new Foo(6, "ijk"));
        fooList.add(new Foo(7, "klm"));
        fooList.add(new Foo(8, "lmn"));
        fooList.add(new Foo(9, "mno"));
        fooList.add(new Foo(10, "nop"));
        fooList.add(new Foo(11, "opq"));
        fooList.add(new Foo(12, "pqr"));
        fooList.add(new Foo(13, "qrs"));
        fooList.add(new Foo(14, "rst"));
        fooList.add(new Foo(15, "stw"));
        return fooList;
    }

}
