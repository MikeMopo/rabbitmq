package zw.co.practice.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import zw.co.practice.rabbitmq.data.User;

@Service
@Slf4j
public class RabbitMqConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeFromQueue(String message) {
        log.info(String.format("Message received -> %s", message));
    }

    @RabbitListener(queues = "${rabbitmq.queue.person.name}")
    public void consumeUserFromQueue(User user) {
        log.info(String.format("User received -> %s", user.toString()));
    }

}
