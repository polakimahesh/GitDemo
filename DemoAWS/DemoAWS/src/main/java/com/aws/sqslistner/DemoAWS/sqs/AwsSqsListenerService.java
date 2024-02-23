package com.aws.sqslistner.DemoAWS.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AwsSqsListenerService {
    @SqsListener(value = "${ribbon.demo.sqs.listener}")
    public void receiveStringMessage(String message) {
        log.info("message received {}",message);
    }

}
