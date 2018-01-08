package test;

import org.junit.Test;
import redis.study.redisInAction.Chapter05;

/**
 * @Author MoonLion
 * @Date Create in 2017/12/9 0009
 * @Description
 */
public class TestTedis02 {
    @Test
    public void testIP() {
        int i = new Chapter05().ipToScore("139.224.9.98");
        System.out.println(i);
    }
}
