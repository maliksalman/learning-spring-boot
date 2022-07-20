package com.example.learningspringboot.validation;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ValidationController {

    @PostMapping("/validation/foo")
    public Foo addFoo(@RequestBody @Valid Foo foo) {
        return foo;
    }

    @PostMapping("/validation/bar")
    public Bar addBar(@RequestBody @Valid Bar bar) {
        return bar;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public List<FieldError> handleBindException(BindException e) {
        return e.getBindingResult().getFieldErrors();
    }
}
