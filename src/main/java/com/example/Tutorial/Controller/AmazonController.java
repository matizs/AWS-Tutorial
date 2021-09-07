package com.example.Tutorial.Controller;

import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.Tutorial.Model.MessageModel;
import com.example.Tutorial.Service.SqsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/amazon")
public class AmazonController {

    private final SqsService sqsService;

    public AmazonController(SqsService sqsService) {
        this.sqsService = sqsService;
    }

    @PostMapping
    public String sendMessage(@RequestBody MessageModel messageModel){
        SendMessageResult sendMessageResult = sqsService.sendMessage(messageModel.getData());
        return sendMessageResult.getMessageId();
    }
}
