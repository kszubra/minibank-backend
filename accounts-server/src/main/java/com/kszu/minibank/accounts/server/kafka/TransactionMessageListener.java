package com.kszu.minibank.accounts.server.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionMessageListener {

    @StreamListener(TransactionStreams.INPUT)
    public void consumeMessage(@Payload IncomingTransactionEventMessage message) {
        log.info("Received message: {}", message.toString());
    }
}
