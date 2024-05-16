package zw.co.practice.rabbitmq.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.practice.rabbitmq.data.User;
import zw.co.practice.rabbitmq.publisher.RabbitMqProducer;

@RestController
@RequestMapping("/rabbitmq")
@RequiredArgsConstructor
@Slf4j
public class RabbitMqController {

    private final RabbitMqProducer rabbitMqProducer;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMqProducer.sendMessage(message);
        log.info("Message sent: " + message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @PostMapping("/send/user")
    public ResponseEntity<String> sendMessageToUser(@RequestBody User user ) {
        rabbitMqProducer.sendUser(user);
        log.info("User sent: " + user.toString());
        return ResponseEntity.ok("User sent successfully");
    }

}
