package com.industry.platform.utils;

import java.util.Collection;

public class CollectionUtils {

    public static Boolean isNotEmpty(Collection collection){
        if(collection!=null && collection.size()>0){
            return true;
        }
        return false;
    }
}
