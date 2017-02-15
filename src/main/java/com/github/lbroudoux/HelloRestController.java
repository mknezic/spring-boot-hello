package com.github.lbroudoux;

import com.github.lbroudoux.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lbroudoux
 */
@RestController
@RequestMapping("/api")
public class HelloRestController {

  @Autowired
  private HelloService helloService;

  @RequestMapping(method = RequestMethod.GET, value = "/hello")
  public Greeting hello(@RequestParam(value="name", defaultValue="World") String name) {
    return helloService.sayHello(name);
  }
}
