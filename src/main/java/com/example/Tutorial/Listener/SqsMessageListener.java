package com.example.Tutorial.Listener;

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

@Configuration
public class SqsMessageListener {
    @SqsListener(value = "TestSimpleQueue", deletionPolicy = SqsMessageDeletionPolicy.ALWAYS)
    public void listen(@Payload String payload, @Headers Map<String, String> headers) {
        System.out.println(payload);
        System.out.println(headers);
//        System.out.println(acknowledgment);
    }
}
