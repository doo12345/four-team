package com.fourstore.pay;

import com.fourstore.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{


    @Autowired PayHistoryRepository 결제이력Repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void orderRefund(@Payload OrderCanceled orderCanceled){

        if(orderCanceled.isMe()){
            System.out.println("##### listener 결재취소함 : " + orderCanceled.toJson());

            PayHistory payHistory = new PayHistory();

            payHistory.setPayStatus("취소");

            결제이력Repository.save(payHistory);
        }
    }

}
