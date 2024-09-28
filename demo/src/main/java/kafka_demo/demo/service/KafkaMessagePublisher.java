package kafka_demo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    public KafkaTemplate<String, Object> template;

    public void sendMessage(String message){
        CompletableFuture<SendResult<String, Object>> send = template.send("mahesh-test4", message);
        send.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("Sent message "+message+" with offset = "+result.getRecordMetadata().offset());
            }
            else{
                System.out.println("unable to send message "+message+" due to "+ex.getMessage());
            }
        });
    }

}
