package com.fourstore.store;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Store_table")
public class Store {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    Long menuId;
    int quantity;
    String address;
    Long orderId;
    Long deliveryId;
    String deliveryStatus;

    @PostPersist
    public void onPostPersist(){
        DeliveryStarted 배달시작됨 = new DeliveryStarted();
        배달시작됨.setOrderId(Long.valueOf(getOrderId()));
        BeanUtils.copyProperties(this, 배달시작됨);
        배달시작됨.publish();
    }


    public Long getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDeliveryId() {
        return this.deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryStatus() {
        return this.deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

}
