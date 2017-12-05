package studyTest;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @Author MoonLion
 * @Date Create in 2017/12/4 0004
 * @Description
 */
public class TestRedis_String {
    private static Jedis conn = null;

    @Before
    public void init() {
        conn = new Jedis("192.168.25.138");
        conn.select(1);
    }

    @Test
    public void test01() {
        Transaction multi = conn.multi();
        multi.set("a", "1");
        multi.set("b", "2");
        multi.set("c", "3");
        multi.set("d", "4");
        multi.exec();
    }

    @Test
    public void test02() {
        Pipeline multi = conn.pipelined();
        multi.multi();
        multi.set("a", "1");
        multi.set("b", "2");
        multi.set("c", "3");
        multi.set("d", "4");
        multi.exec();
        multi.sync();
    }

    @Test
    public void flushDB() {
        conn.flushDB();
    }
}
