package com.zjl.webgetway.predicate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 自定义断言工厂
 */
@Slf4j
@Component
public class TokenRoutePredicateFactory extends AbstractRoutePredicateFactory<TokenConfig> {


    public TokenRoutePredicateFactory() {
        super(TokenConfig.class);

    }

    public TokenRoutePredicateFactory(Class<TokenConfig> configClass) {
        super(configClass);
    }

    @Override
    public ShortcutType shortcutType() {
        return super.shortcutType();
    }

    /**
     * 返回list
     *
     * @return 字段
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("token");
    }

    @Override
    public String shortcutFieldPrefix() {
        return super.shortcutFieldPrefix();
    }

    @Override
    public Predicate<ServerWebExchange> apply(Consumer<TokenConfig> consumer) {
        return super.apply(consumer);
    }

    @Override
    public AsyncPredicate<ServerWebExchange> applyAsync(Consumer<TokenConfig> consumer) {
        return super.applyAsync(consumer);
    }

    @Override
    public void beforeApply(TokenConfig config) {
        super.beforeApply(config);
    }

    @Override
    public Predicate<ServerWebExchange> apply(TokenConfig config) {
        return e -> {
            MultiValueMap<String, String> valueMap = e.getRequest().getQueryParams();

            AtomicReference<String> token = new AtomicReference<>("uknown");

            valueMap.forEach((k, v) -> {
                if (k.equals("token")) {
                    if (v != null && v.size() > 0) {
                        token.set(v.get(0));
                    }
                }
            });

            if ("123456".equals(token.get())){
                return true;
            }

            return false;
        };
    }

    @Override
    public AsyncPredicate<ServerWebExchange> applyAsync(TokenConfig config) {
        return super.applyAsync(config);
    }

    @Override
    public String name() {
        return super.name();
    }
}
