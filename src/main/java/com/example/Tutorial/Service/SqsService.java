package com.example.Tutorial.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SqsService {

    private final AmazonSQS amazonSQS;

    @Value("${amazon.queue.name:TestSimpeQueue}")
    private String queueName;
    private String queueUrl;

    @PostConstruct
    public void init(){
        this.queueUrl = amazonSQS.getQueueUrl(queueName).getQueueUrl();
    }

    public SqsService(AmazonSQS amazonSQS) {
        this.amazonSQS = amazonSQS;
    }

    public SendMessageResult sendMessage(String message) {
        return this.amazonSQS.sendMessage(queueUrl, message);
    }
}
