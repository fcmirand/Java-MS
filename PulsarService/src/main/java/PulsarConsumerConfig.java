package com.example.pulsarservice;

import org.apache.pulsar.client.api.*;

public class PulsarConsumerConfig {
    public static Consumer<String> createConsumer(PulsarClient client, String topic, String subscriptionName) throws PulsarClientException {
        return client.newConsumer(Schema.STRING)
                .topic(topic)
                .subscriptionName(subscriptionName)
                .subscribe();
    }
}