package com.ctr.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderCreateFrom {
    @NotNull
    private Integer shippingId;
}
