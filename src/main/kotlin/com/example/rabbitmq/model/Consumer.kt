package com.example.rabbitmq.model

import com.example.rabbitmq.consumer.ConsumerDataClass
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import org.springframework.util.SerializationUtils

/**
 * IDE : IntelliJ IDEA
 * Created by kiheyunkim@gmail.com on 2021-08-07
 * Github : http://github.com/kiheyunkim
 * Comment : 각각은 RabbitMQ의 데이터를 수신하는 Listener
 */
@Component
class Consumer {
	@RabbitListener(queues = ["hello2"])
	fun receiveMessage(message:Message){
		val deserialize: ConsumerDataClass = SerializationUtils.deserialize(message.body) as ConsumerDataClass
		println(deserialize)
	}

	@RabbitListener(queues = ["hello2"])
	fun receiveMessage2(message:Message){
		val deserialize: ConsumerDataClass = SerializationUtils.deserialize(message.body) as ConsumerDataClass
		println(deserialize)
	}

	@RabbitListener(queues = ["hello2"])
	fun receiveMessage3(message:Message){
		val deserialize: ConsumerDataClass = SerializationUtils.deserialize(message.body) as ConsumerDataClass
		println(deserialize)
	}

	@RabbitListener(queues = ["hello2"])
	fun receiveMessage4(message:Message){
		val deserialize: ConsumerDataClass = SerializationUtils.deserialize(message.body) as ConsumerDataClass
		println(deserialize)
	}
}