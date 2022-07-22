package com.example.learningspringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class ObjectForTestingTest {

    @Test
    void testDoWork() {

        // GIVEN
        InnerObjectForTesting mockInner = mock(InnerObjectForTesting.class);
        ObjectForTesting underTest = new ObjectForTesting(mockInner);

        // WHEN
        underTest.doWork(10);

        // THEN
        verify(mockInner, Mockito.times(1)).innerWork("foo", 10);
    }

    @Test
    void testMoreWork() {

        // GIVEN
        InnerObjectForTesting mockInner = mock(InnerObjectForTesting.class);
        ObjectForTesting underTest = new ObjectForTesting(mockInner);

        // WHEN
        underTest.moreWork(10);

        // THEN
        verify(mockInner, never()).innerWork(any(), anyInt());

        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        verify(mockInner).moreInnerWork(captor.capture());

        Assertions.assertThat(captor.getValue().getAge()).isEqualTo(10);
        Assertions.assertThat(captor.getValue().getName()).isEqualTo("joe");
    }
}