package tech.devnylo.rest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingsController {

    public static final String template = "Hello %s!";
    public final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greetings")
    public Greetings greetings(@RequestParam(value = "name" , defaultValue = "World") String name){

            return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }
}
