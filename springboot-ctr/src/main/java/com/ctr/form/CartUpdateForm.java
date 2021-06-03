package com.ctr.form;

import com.sun.el.parser.BooleanNode;
import lombok.Data;

@Data
public class CartUpdateForm {
    private Integer quantity;
    private Boolean selected;
}
