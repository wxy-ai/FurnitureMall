package com.ctr.enums;

import lombok.Getter;

@Getter
public enum ProductSatusEnum {
    ON_SALE(1),
    OFF_SALE(2),
    DELETE(3),
    ;
    Integer code;
    ProductSatusEnum(Integer code){
        this.code = code;
    }
}
