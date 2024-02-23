package com.aws.sqslistner.DemoAWS.sqs;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.QueueMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.PayloadMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Value("${cloud.aws.region.static}")
    private String region;
    @Value("${cloud.aws.credentials.access-key}")
    private String AWS_ACCESS_KEY_ID;
    @Value("${cloud.aws.credentials.secret-key}")
    private String AWS_SECRET_ACCESS_KEY;

    public AWSCredentials credentials() {
        AWSCredentials credentials = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);
        return credentials;
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate() {
        return new QueueMessagingTemplate(amazonSQSAsync());
    }

    @Bean
    @Primary
    public AmazonSQSAsync amazonSQSAsync() {
        return AmazonSQSAsyncClientBuilder.standard().withRegion(Regions.EU_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY)))
                .build();
    }

    @Bean
    public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory() {
        SimpleMessageListenerContainerFactory factory = new SimpleMessageListenerContainerFactory();
        factory.setAmazonSqs(amazonSQSAsync());
        return factory;
    }

    @Bean
    public QueueMessageHandler queueMessageHandler() {
        QueueMessageHandlerFactory factory = new QueueMessageHandlerFactory();
        factory.setAmazonSqs(amazonSQSAsync());
        QueueMessageHandler handler = factory.createQueueMessageHandler();
        List<HandlerMethodArgumentResolver> list = new ArrayList<>();
        HandlerMethodArgumentResolver resolver = new PayloadMethodArgumentResolver(new MappingJackson2MessageConverter());
        list.add(resolver);
        handler.setArgumentResolvers(list);
        return handler;
    }



    //    @Bean
//    public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory(){
//        SimpleMessageListenerContainerFactory factor = new SimpleMessageListenerContainerFactory();
//        factor.setAmazonSqs( amazonSQSAsync());
//        factor.setAutoStartup(true);
//        return factor;
//    }
//
//
//    @Bean
//    @Primary
//    public AmazonSQSAsync amazonSQSAsync() {
//        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);
//        return AmazonSQSAsyncClientBuilder.standard()
//                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//                .withRegion("us-west-2").build();
//    }
//
//    @Bean
//    public QueueMessagingTemplate queueMessagingTemplate() {
//        return new QueueMessagingTemplate(amazonSQSAsync());
//    }

//
//    @Bean
//    public SqsClient getSqsClient() {
//        AwsCredentialsProvider awsCredentialsProvider;
//
//        if (System.getenv("spring_profiles_active") == null) {
//            awsCredentialsProvider = ContainerCredentialsProvider.builder().build();
//        } else {
//            awsCredentialsProvider = EnvironmentVariableCredentialsProvider.create();
//        }
//        return SqsClient.builder()
//                .region(Region.EU_WEST_2)
//                .credentialsProvider(awsCredentialsProvider)
//                .build();
//    }
//
//
//    @Bean
//    @Primary
//    public AmazonSQSAsync amazonSQSAsync() {
//        AwsCredentialsProvider awsCredentialsProvider;
//        if (System.getenv("spring_profiles_active") == null) {
//            awsCredentialsProvider = ContainerCredentialsProvider.builder().build();
//        } else {
//            awsCredentialsProvider = EnvironmentVariableCredentialsProvider.create();
//        }
//        return AmazonSQSAsyncClientBuilder
//                .standard()
//                .withRegion(String.valueOf(Region.EU_WEST_2))
//                .withCredentials(new AWSStaticCredentialsProvider(
//                        new BasicAWSCredentials(awsCredentialsProvider.resolveCredentials().accessKeyId(), awsCredentialsProvider.resolveCredentials().secretAccessKey())))
//                .build();
//    }
//
//    @Bean
//    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
//        return new QueueMessagingTemplate(amazonSQSAsync);
//    }


}
