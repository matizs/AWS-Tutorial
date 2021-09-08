package com.example.Tutorial.Controller;


import com.example.Tutorial.Model.TestModel;
import com.example.Tutorial.Service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/external")
public class ExternalRestController {

    private final TestService testService;

    public ExternalRestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/print/{value}")
    public String print(@PathVariable Optional<String> value){
        return value.orElse("Default");
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable Long id) {
        Optional<TestModel> testModel = testService.findTestModel(id);
        if(testModel.isPresent()) {
            return testModel.get().getName();
        }
        return "Empty";
    }
}
