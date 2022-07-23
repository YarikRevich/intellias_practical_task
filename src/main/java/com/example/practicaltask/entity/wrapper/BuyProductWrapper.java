package com.example.practicaltask.entity.wrapper;

import java.io.Serializable;

public class BuyProductWrapper implements Serializable{
    private long userId;
    private long productId;

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
