package com.example.pulsarservice;

import org.apache.pulsar.client.api.*;

public class PulsarService {
    public static void main(String[] args) {
        try (PulsarClient client = PulsarClient.builder()
                .serviceUrl(System.getenv("PULSAR_SERVICE_URL")) // gettign names from deployment.yaml
                .build()) {

            // Create a consumer
            Consumer<String> consumer = PulsarConsumerConfig.createConsumer(client,
                    System.getenv("INPUT_TOPIC"),
                    System.getenv("SUBSCRIPTION_NAME"));

            // Create a producer
            Producer<String> producer = PulsarProducerConfig.createProducer(client,
                    System.getenv("OUTPUT_TOPIC"));

            System.out.println("Service started. Waiting for messages...");

            while (true) {
                // Receive message
                Message<String> msg = consumer.receive();
                try {
                    String content = msg.getValue();
                    System.out.println("Received message: " + content);

                    // Process message and send to producer
                    String processedMessage = MessageProcessor.processMessage(content);
                    producer.send(processedMessage);

                    // Acknowledge message
                    consumer.acknowledge(msg);
                } catch (Exception e) {
                    consumer.negativeAcknowledge(msg);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}