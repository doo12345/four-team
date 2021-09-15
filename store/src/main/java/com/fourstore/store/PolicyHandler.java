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

            Store st = new Store();
            st.setOrderId(Long.valueOf(orderPaid.getOrderId()));
            st.setAddress(orderPaid.address);
            st.setDeliveryId((long)0);
            st.setDeliveryStatus("배송");
            st.setOrderId(Long.valueOf(orderPaid.getOrderId()));
            st.setQuantity(orderPaid.getQty());
            storeRepository.save(st);
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
