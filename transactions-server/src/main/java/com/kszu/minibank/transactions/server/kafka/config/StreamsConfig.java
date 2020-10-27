package com.kszu.minibank.transactions.server.kafka.config;

import com.kszu.minibank.transactions.server.kafka.TransactionStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TransactionStreams.class)
public class StreamsConfig {
}
