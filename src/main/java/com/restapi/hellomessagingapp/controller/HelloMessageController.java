package com.restapi.hellomessagingapp.controller;
import com.restapi.hellomessagingapp.model.User;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/home")
public class HelloMessageController
{

    /**
     * UC1 Create a Rest Controller to demonstrate the various HTTP Methods and respond
     * hello messages to the User. To begin with show Hello from BridgeLabz
     */
    @RequestMapping(value = {"","/", "/hello"})
    public String sayHello()
    {
        return "Hello From BridgeLabz !";
    }

   /**
    * UC2 Make REST Call to show Hello Mark from BridgeLabz
    * curl http://localhost:8080/home/query?Fname=Abhishek&Lname=Sagar
    */
    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "fName") String fName,@RequestParam(value = "lName") String lName)
    {
        return "Hello "+ fName +" "+ lName+" from BridgeLabz";
    }
    /**
     * UC3 Make REST Call to show Hello Mark from BridgeLabz
     * curl http://localhost:8080/hello/param/Abhishek
     */
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name)
    {
        return  "Hello " + name + " from BridgeLabz";
    }

    /**
     * UC4 Make REST Call to show Hello Mark Taylor from BridgeLabz
     * curl -X POST -H "Content-Type: application/json" -d
     * '{"firstName": ”Mark","lastName": ”Taylor"}'
     *curl "http://localhost:8080/home/post"
     */
    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " from bridgeLabz";
    }

    /**
     * UC5 Make REST Call to show Hello Mark Taylor from BridgeLabz
     * localhost:8080/hello/put/Mark/?lastName=Taylor
     */
    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}
