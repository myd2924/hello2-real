package com.myd.app.component;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/26 19:49
 * @Description:
 */
@Component
public class ItemBeanMapApi implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap()
    }
}
