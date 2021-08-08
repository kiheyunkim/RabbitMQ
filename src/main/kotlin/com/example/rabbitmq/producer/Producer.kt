package com.example.rabbitmq.producer

import com.example.rabbitmq.consumer.ConsumerDataClass
import com.rabbitmq.client.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Controller
import org.springframework.util.SerializationUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * IDE : IntelliJ IDEA
 * Created by kiheyunkim@gmail.com on 2021-08-07
 * Github : http://github.com/kiheyunkim
 * Comment :
 */
@Controller
class Producer(private val rabbitTemplate: RabbitTemplate) {
	@GetMapping("/test/send")
	@ResponseBody
	fun addProducer(): String {

		for (i in 1..1000) {
			val data = ConsumerDataClass((Math.random() * 100).toInt(), (Math.random() * 10).toInt())
			rabbitTemplate.convertAndSend("hello2", data)
		}

		return "OK"
	}
}