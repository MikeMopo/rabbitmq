package zw.co.practice.rabbitmq.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zw.co.practice.rabbitmq.data.User;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMqProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    @Value("${rabbitmq.routing.person.key}")
    private String userRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        log.info(String.format("Message sent -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
    public void sendUser(User user) {
        log.info(String.format("User sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, userRoutingKey, user);
    }


}
