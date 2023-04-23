package com.a3fun.learn.learnhotswap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    @RequestMapping(value ="/fib", method = RequestMethod.GET)
    public long fibonacci(int value){
        return fib(value);
    }

    private long fib(int n){
        if (n <= 1) {
            return 1;
        }
        return fib(n-1) * fib(n-2);
    }
}
