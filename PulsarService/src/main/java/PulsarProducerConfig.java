package com.example.pulsarservice;

import org.apache.pulsar.client.api.*;

public class PulsarProducerConfig {
    public static Producer<String> createProducer(PulsarClient client, String topic) throws PulsarClientException {
        return client.newProducer(Schema.STRING)
                .topic(topic)
                .create();
    }
}