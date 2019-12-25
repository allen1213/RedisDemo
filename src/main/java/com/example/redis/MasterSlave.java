package com.example.redis;

import redis.clients.jedis.Jedis;

public class MasterSlave {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
    }
}
