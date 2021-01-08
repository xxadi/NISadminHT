package me.zhengjie.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源路由配置
 *
 * @ClassName DynamicRoutingDataSource
 * @Author zhuzhh
 * @Date 2020/11/9
 */
@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
//        String dataSourceName = DynamicDataSourceContextHolder.getDataSourceRouterKey();
//        log.info("当前数据源是：{}", dataSourceName);
//        return com.medsys.datasource.common.config.DynamicDataSourceContextHolder.getDataSourceRouterKey();
        return me.zhengjie.config.DynamicDataSourceContextHolder.getDataSourceRouterKey();
    }
}
