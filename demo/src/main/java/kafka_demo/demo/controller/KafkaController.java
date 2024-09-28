package kafka_demo.demo.controller;

import kafka_demo.demo.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class KafkaController {
    @Autowired
    KafkaMessagePublisher kafkaMessagePublisher;


    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){

        try{
            kafkaMessagePublisher.sendMessage(message);
            return ResponseEntity.ok("Message published successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
