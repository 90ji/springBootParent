package test;

import com.qinxiaozhou.redis.SpringbootApplication;
import com.qinxiaozhou.redis.model.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.study.redisInAction.Chapter05;

/**
 * Create by qxz on 2017/11/29
 * Description:
 */
@SpringBootTest(classes=SpringbootApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate<String,UserInfo> Template;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testobjSerializer() throws InterruptedException {
        UserInfo user = new UserInfo("111111","snow","112358");
        Template.opsForValue().set("User:snow",user);
//        Assert.assertEquals(true,redisTemplate.hasKey("User:snow"));
        stringRedisTemplate.opsForValue().get("User:snow");
    }
    @Test
    public void testobj() throws InterruptedException {
        UserInfo user = new UserInfo("15201803745","snow","112358");
        ValueOperations<String,UserInfo> operations = redisTemplate.opsForValue();
        operations.set("User:zzp",user);
        operations.set("User:zzq",user);
        Assert.assertEquals(true,redisTemplate.hasKey("User:zzp"));
        Assert.assertEquals(true,redisTemplate.hasKey("User:zzq"));
    }


}