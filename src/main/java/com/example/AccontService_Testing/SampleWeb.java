package com.example.AccontService_Testing;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleWeb  {

    @GetMapping("/webmsg")
    public String getMessage(@RequestParam(value = "message", defaultValue = "Hello") String message) {
        return message;
    }
}
