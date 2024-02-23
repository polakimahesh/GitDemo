package com.aws.sqslistner.DemoAWS.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


//@Service
//@Slf4j
public class AwsSqsService {
//    @Autowired
//    private SqsClient sqsClient;
//    @Value("${ribbon.demo.example.sqs}")
//    private String demoQueue;
//    @PostConstruct
//    public void startPollingMessages() {
//        while (true) {
//            try {
//                ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
//                        .queueUrl(demoQueue)
//                        .maxNumberOfMessages(5)
//                        .build();
//                List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();
//                for (Message message : messages) {
//                    System.out.println("Message received: " + message.body());
//                    sqsClient.deleteMessage(DeleteMessageRequest.builder()
//                            .queueUrl(demoQueue)
//                            .receiptHandle(message.receiptHandle())
//                            .build());
//                }
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            } catch (SqsException e) {
//                System.err.println(e.awsErrorDetails().errorMessage());
//            }
//        }
//    }
}




