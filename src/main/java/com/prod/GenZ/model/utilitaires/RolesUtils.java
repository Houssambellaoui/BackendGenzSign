package com.prod.GenZ.model.utilitaires;

import java.util.List;

public class RolesUtils {
    public static boolean isIn(List<Object> list, Object... itmes){
        for (var item:
             itmes) {
            if(list.stream().anyMatch( i -> i.equals(item))){
                return true;
            }
        }
        return false;
    }
}
