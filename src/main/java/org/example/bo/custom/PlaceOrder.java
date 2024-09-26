package org.example.bo.custom;

import org.example.bo.SuperBo;

public interface PlaceOrder extends SuperBo {
    void placeOrder(String cid, String oid, String iid, double prize, int qtyy, double tot, String des, int qtOnHand);
}
