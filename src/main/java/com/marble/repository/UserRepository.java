package com.marble.repository;

import com.marble.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author marble
 * @date 2020/4/11 12:50
 * @description 创建用户持久层
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {
    /**
     * 基于内存存储对象
     */
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();
    private static final AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户对象
     *
     * @param user {@link User}用户对象
     * @return 如果存储成功 返回<code>true</code>
     * 如果存储失败 返回<code>false</code>
     */
    public boolean save(User user) {
        //ID从1开始
        int id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }

    ;
}
