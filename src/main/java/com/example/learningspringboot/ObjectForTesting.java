package com.example.learningspringboot;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ObjectForTesting {

    private final InnerObjectForTesting innerObjectForTesting;

    public void doWork(int count) {
        String resultOfSomeSuperOperations = "foo";
        String repeated = innerObjectForTesting.innerWork(resultOfSomeSuperOperations, count);
        System.out.println(repeated);
    }


    public void moreWork(int age) {
        String resultOfSomeSuperOperations = "foo";
        String somethingElse = innerObjectForTesting.moreInnerWork(Person.builder()
                .city("canton")
                .age(age)
                .name("joe")
                .build());
        System.out.println(somethingElse);
    }

}
