package com.example.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class RedisConnection {

    public static void main(String[] args) {

    }

    private static void test01() {
        Jedis jedis = new Jedis("127.0.0.1",6379);


        jedis.set("name","hebo");
        System.out.println(jedis.get("name"));

        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
