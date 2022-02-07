package com.example.rabbitmq.consumer

import java.io.Serializable

/**
 * IDE : IntelliJ IDEA
 * Created by kiheyunkim@gmail.com on 2021-08-08
 * Github : http://github.com/kiheyunkim
 * Comment : RabbitMQ로 전송하는 객체는 반드시 Seializable을 구현해야한다
 */
data class ConsumerDataClass(private val number: Int, private val value: Int): Serializable
