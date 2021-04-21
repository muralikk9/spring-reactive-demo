package com.spring.reactive.repo;

import com.spring.reactive.model.Foo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FooRepository {

    public List<Foo> getFooList() {
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
