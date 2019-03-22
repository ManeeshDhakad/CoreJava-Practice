package com.java.jms.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;

public class ProducerQueue {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String subject = "MyQueue";
	public ProducerQueue() throws JMSException, NamingException {
			
		// Look up a JMS connection factory
		ConnectionFactory conFactory = new ActiveMQConnectionFactory(url);
		Connection connection;
		// Getting JMS connection from the server and starting it
		connection = conFactory.createConnection();
		try {
			connection.start();
			// JMS messages are sent and received using a Session. We will
			// create here a non-transactional session object. If you want
			// to use transactions you should set the first parameter to 'true'
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(subject);
			// MessageProducer is used for sending messages (as opposed
			// to MessageConsumer which is used for receiving them)
			MessageProducer producer = session.createProducer(destination);
			// We will send a small text message saying 'Hello World!'
			TextMessage message = session.createTextMessage("Hello World -  2 !");
			// Here we are sending the message!
			producer.send(message);
			System.out.println("Sent message '" + message.getText() + "'");
		} finally {
			connection.close();
		}
	}
	public static void main(String[] args) throws JMSException {
		try {
			BasicConfigurator.configure();
			new ProducerQueue();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}