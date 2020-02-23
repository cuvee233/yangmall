package com.weiyi.ymall.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @param
 * @return
 */
@Data
public class PmsBaseCatalog2 implements Serializable {
    private String id;
    private String name;
    private String catalog1Id;

    private List<PmsBaseCatalog3> catalog3List;


}