package com.aws.sqslistner.DemoAWS.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

//@Service
//@Slf4j
//@EnableScheduling
public class SQSService {
//    @Autowired
//    private SqsClient sqsClient;
//    @Value("${ribbon.demo.example.sqs}")
//    private String demoQueue;
//    @Scheduled(fixedDelay = 10000)
//    public void receiveMessages() {
//        try {
//            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
//                    .queueUrl(demoQueue)
//                    .maxNumberOfMessages(5)
//                    .build();
//            List<Message> sqsMessages = sqsClient.receiveMessage(receiveMessageRequest)
//                    .messages();
//            log.info(sqsMessages.toString());
//            if(!sqsMessages.isEmpty()){
//                sqsClient.deleteMessage(DeleteMessageRequest.builder().queueUrl(demoQueue).receiptHandle(sqsMessages.get(0).receiptHandle()).build());
//            }
//        } catch (SqsException e) {
//            log.info(e.getMessage());
//            throw new RuntimeException("Error receiving messages from SQS", e);
//        }
//    }
//    @PreDestroy
//    public void cleanUp() {
//        if (sqsClient != null) {
//            sqsClient.close();
//        }
//    }
}