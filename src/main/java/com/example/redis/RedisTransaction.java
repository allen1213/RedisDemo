package com.example.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisTransaction {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);

        Transaction transaction = jedis.multi();

        transaction.set("handsome","allen");
        transaction.set("k1","k1");
        transaction.set("k2","k2");

        transaction.exec();

    }
}
