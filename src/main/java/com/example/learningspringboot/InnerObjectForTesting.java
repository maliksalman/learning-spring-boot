package com.example.learningspringboot;

import org.apache.commons.lang3.StringUtils;

public class InnerObjectForTesting {

    public String innerWork(String toRepeat, int count) {
        return StringUtils.repeat(toRepeat, "-", count);
    }

    public String moreInnerWork(Person person) {
        return person.getCity() + "-" + person.getName();
    }
}
