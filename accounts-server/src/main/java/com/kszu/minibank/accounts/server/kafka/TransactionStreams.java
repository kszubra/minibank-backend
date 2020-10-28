package com.kszu.minibank.accounts.server.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TransactionStreams {
    String OUTPUT = "transaction-responses";
    String INPUT = "transaction-requests";

    @Input(INPUT)
    SubscribableChannel incomingTransactionRequests();

    @Output(OUTPUT)
    MessageChannel outgoingTransactionResponses();


}
