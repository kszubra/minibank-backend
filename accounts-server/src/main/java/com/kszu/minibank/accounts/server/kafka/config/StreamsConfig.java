package com.kszu.minibank.accounts.server.kafka.config;

import com.kszu.minibank.accounts.server.kafka.TransactionStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TransactionStreams.class)
public class StreamsConfig {
}
