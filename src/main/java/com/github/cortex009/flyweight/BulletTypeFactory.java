package com.github.cortex009.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BulletTypeFactory {
    public static final Map<String, BulletType> CACHE = new HashMap<>();

    public static BulletType getBulletType(String bulletName){
        if(CACHE.containsKey(bulletName)){
            return CACHE.get(bulletName);
        }
        BulletType bulletType = createBulletType(bulletName);
        CACHE.put(bulletName,bulletType);
        return bulletType;
    }
    private static BulletType createBulletType(String bulletName){
        return switch (bulletName){
            case "AKM" -> new BulletType("GOLD",8.0,3.9,48,400,new byte[1024]);
            case "M416" -> new BulletType("SILVER",8.0,3.9,48,400, new byte[1024]);
            default -> new BulletType("GREY",7.0,3.0,30,300,new byte[1024]);
        };
    }
}
