package com.learn.notification_service.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class AccountEventListener {

    private static final Logger log= LoggerFactory.getLogger(AccountEventListener.class);

    @KafkaListener(topics = "account-events",groupId = "notification-group")
    public void onAccountCreated(AccountCreatedEvent event, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,@Header(KafkaHeaders.OFFSET) long offset){
        log.info("Welcome notification -> {} (account {}) | partition={} offset={}",event.holderName(),event.accountId(),partition,offset);
    }
}
