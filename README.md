## 개발환경 준비

```bash
#rabbitMQ docker Run
docker run -itd --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.9-management
```

# RabbitMQ

RabbitMQ는 Erlang으로 AMQP를 구현한 것

### 메세지 큐

* 메시지 큐의 종류
	* RabbitMQ
	* ActiveMQ
	* ZeroMQ
	* Kafka
	* 등등

## AMQP?

클라이언트가 메시지 미들웨어 브로커가 통신할 수 있게 해주는 메세지 프로토콜

## 용어

Producer: 메세지를 생성하고 발송하는 주체 - Queue에 직접 접근하지않고 항상 Exchange를 통해 접근

Consumer: 메세지를 수순하는 주체. - Queue에 직접 접근함.

ExChange: Producer들에게서 전달받은 메세지들을 어떤 Queue에 전송할지 결정하는 객체

Binding: Exchange에게 메세지를 라우팅 할 규칙을 지정하는 행위. 조건에 맞는 메세지를 특정 큐에 전송할 수 있도록 할 수 있음(Exchange와 Queue는 m:n binding이 가능)


## Exchange의 네가지 타입

| 타입  | 특징  | 비고  |
|---|---|---|
|  Direct | Unicast  |  Routing key가 정확하게 일치하는 Queue에 메세지 전송  |
|  Topic | Multicast   |  Routing key가 정확하게 일치하는 Queue에 메세지 전송  |
|  Headers | Multicast  |  key:value로 이루어진 header값을 기준으로 일치하는 Queue에 메세지 전송 |
|  Fanout |  Broadcast |   해당 Exchange에 등록된 모든 Queue에 메세지 전송|


## Message Queue와 Message 보존
RabbitMQ server가 종료 후 재기동하면, 기본적으로 Queue는 모두 제거됨.

이를 막기 위해서는 Queue를 생성할 떄 Durable 옵션에 true를 주고 생성해야함.

Producer가 메세지를 발송할 떄, PERSISTENT_TEXT_PLAIN옵션을 주어야 메세지가 보존 됨.


## Prefetch Count

하나의 Queue에 여러 Consumer가 존재할 경우, Queue는 기본적으로 Round-Robin방식으로 메세지 분배

그런데, Consumer가 2개인 상황에서 홀수번째 메세지는 처리 시간이 짧고, 짝수번째 메세지는 처리 시간이 매우 긴 경우, 계속해서 하나의 Consumer만 일을 하게 되는 상황이 발생할 수 있음

이를 예방하기 위해, prefetch count를 1로 설정해 두면, 하나의 메세지가 처리되기 전(Ack를 보내기 전)에는 새로운 메세지를 받지 않게 되므로, 작업을 분산시킬 수 있음.[링크](https://www.cloudamqp.com/blog/how-to-optimize-the-rabbitmq-prefetch-count.html)
