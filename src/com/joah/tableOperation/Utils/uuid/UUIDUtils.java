package com.joah.tableOperation.Utils.uuid;

import java.util.UUID;

public class UUIDUtils {
    /**
     * uuid (Universally Unique Identifier)
     * 产生uuid
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }
}
