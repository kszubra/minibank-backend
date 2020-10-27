package com.kszu.minibank.transactions.server.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
@AllArgsConstructor
public class TransactionMessageProducer {

    private final TransactionStreams transactionStreams;

    public void sendMessage(final OutgoingTransactionEventMessage message) {
        log.info("Sending transaction even message");
        MessageChannel messageChannel = transactionStreams.outgoingTransactions();
        messageChannel.send(MessageBuilder
                .withPayload(message)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
