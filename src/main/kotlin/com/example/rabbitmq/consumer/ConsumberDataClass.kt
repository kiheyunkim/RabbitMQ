package com.example.rabbitmq.consumer

import java.io.Serializable

/**
 * IDE : IntelliJ IDEA
 * Created by kiheyunkim@gmail.com on 2021-08-08
 * Github : http://github.com/kiheyunkim
 * Comment :
 */
data class ConsumerDataClass(private val number: Int, private val value: Int): Serializable
