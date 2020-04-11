package com.marble.config;

import com.marble.domain.User;
import com.marble.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * @author marble
 * @date 2020/4/11 16:03
 * @description 路由器函数 配置
 */
@Configuration//spring为了替换xml文件
public class RouterFunctionConfiguration {
    /**
     * Servlet
     * 请求接口：ServletRequest 或 HttpServletRequest
     * 响应接口：ServletResponse 或 HttpServletResponse
     * Spring 5.0重新定义了服务请求和响应接口
     * 请求接口：ServerRequest
     * 响应接口：ServerResponse
     * 即可支持Servlet规范,也可以支持自定义的，如 Netty
     * <p>
     * 定义一个GET请求，并且返回所有的用户对象URI:/user/find/all
     * <p>
     * Flux是0-N个对象集合
     * Mono是0-1个对象集合
     * Reactive中的Flux或Mono是异步处理（非阻塞式）
     * 集合对象基本上是同步处理（阻塞）
     * Flux或者Mono都是Publisher
     *
     * 优点：异步非阻塞，提高吞吐量
     */
    @Bean
    @Autowired//不用写，为了规范
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {
        return RouterFunctions.route(RequestPredicates.GET("/find/all"),
                request -> {
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }

}
