package org.example.bo;

import org.example.bo.custom.IMPL.CustometBOImpl;
import org.example.bo.custom.IMPL.ItemBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM
    }


    public SuperBo getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustometBOImpl();
            case ITEM:
                return new ItemBOImpl();
            default:
                return null;
        }
    }
}
