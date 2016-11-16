package com.colm.app;
/***************************************************************
 * Copyright (c) 2016 Errigal Inc.
 *
 * This software is the confidential and proprietary information
 * of Errigal, Inc.  You shall not disclose such confidential
 * information and shall use it only in accordance with the
 * license agreement you entered into with Errigal.
 *
 *************************************************************** */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by Colm Carew on 16/11/2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection;
        Channel channel;
        String replyQueueName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.0.13");
        factory.setPassword("admin");
        factory.setUsername("admin");
        factory.setVirtualHost("admin");
        connection = factory.newConnection();
        channel = connection.createChannel();
        String queneNAme = "rabbitmq_test";
        channel.queueDeclare(queneNAme, false, false, false, null);
        String message = "Something Else";
        for (int i = 0; i < 1000; i++) {
            channel.basicPublish("", queneNAme, null, message.getBytes());
        }
        System.out.println("Sent '" + message + "'");
        channel.close();
        connection.close();

    }
}
