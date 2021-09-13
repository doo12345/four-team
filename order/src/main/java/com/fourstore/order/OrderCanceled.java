package com.fourstore.order;

public class OrderCanceled extends AbstractEvent {

    private Long id;

    public OrderCanceled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
