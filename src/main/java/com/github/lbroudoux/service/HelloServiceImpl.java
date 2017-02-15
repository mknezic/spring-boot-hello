package com.github.lbroudoux.service;

import com.github.lbroudoux.Greeting;
import com.github.lbroudoux.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mladen on 15.2.2017..
 */
@Service
public class HelloServiceImpl implements HelloService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private HelloDao helloDao;

    @Override
    public Greeting sayHello(String name) {
        String template = helloDao.getTemplate();
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
