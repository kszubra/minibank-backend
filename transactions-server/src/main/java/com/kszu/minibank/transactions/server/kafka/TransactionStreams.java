package com.kszu.minibank.transactions.server.kafka;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TransactionStreams {
    String INPUT = "transaction-responses";
    String OUTPUT = "transaction-requests";

    @Input(INPUT)
    SubscribableChannel incomingTransactionResponses();

    @Output(OUTPUT)
    MessageChannel outgoingTransactions();


}
