package com.fourstore.store;

import com.fourstore.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired StoreRepository storeRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void startMenu(@Payload OrderPaid orderPaid){

        if(orderPaid.isMe()){
            System.out.println("##### listener 주문정보받음 : " + orderPaid.toJson());

            Store 주문 = new Store();
            주문.setOrderId(Long.valueOf(orderPaid.getOrderId()));
            storeRepository.save(주문);
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void calcelOrder(@Payload OrderRefunded orderRefunded){

        if(orderRefunded.isMe()){
            System.out.println("##### listener 주문취소처리 : " + orderRefunded.toJson());

            storeRepository.findById(Long.valueOf(orderRefunded.getOrderId())).ifPresent(Store->{
                storeRepository.delete(Store);
            });

        }
    }

}
