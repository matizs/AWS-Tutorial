package com.example.Tutorial.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.example.Tutorial.Model.TestModel;
import com.example.Tutorial.Repository.TestRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    private final TestRepository testRepository;
    @PostConstruct
    private void init(){
        TestModel testModel = new TestModel();
        testModel.setName("AUTO");
        testRepository.save(testModel);
    }

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Optional<TestModel> findTestModel(Long id){
        return testRepository.findById(id);
    }
}
