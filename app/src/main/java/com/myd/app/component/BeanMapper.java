package com.myd.app.component;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/26 17:59
 * @Description: bean
 */
@Component
@ConditionalOnClass({MapperFacade.class})
public class BeanMapper implements ApplicationContextAware {

    private static MapperFacade mapperFacade;

    public static <TSrc, TDest> TDest map(TSrc src, Class<TDest> destClass) {
        return src != null ? mapperFacade.map(src, destClass) : null;
    }

    public static <TSrc, TDest> TDest map(TSrc src, TDest dest) {
        if (src != null && dest != null) {
            mapperFacade.map(src, dest);
        }

        return dest;
    }

    public static <TSrc1, TSrc2, TDest> TDest map(TSrc1 src1, TSrc2 src2, Class<TDest> destClass) {
        TDest dest = map(src1, destClass);
        map(src2, dest);
        return dest;
    }

    public static <TSrc, TDest> List<TDest> mapAsList(Iterable<TSrc> srcs, Class<TDest> destClass) {
        return srcs != null ? mapperFacade.mapAsList(srcs, destClass) : null;
    }

    public static <TSrc, TDest> List<TDest> mapAsList(Iterable<TSrc> srcs, Class<TDest> destClass, BiConsumer<TSrc, TDest> customMapper) {
        List<TDest> destList = new ArrayList();
        if (srcs != null) {
            srcs.forEach((src) -> {
                TDest dest = map(src, destClass);
                customMapper.accept(src, dest);
                destList.add(dest);
            });
        }

        return destList;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        mapperFacade = (MapperFacade)applicationContext.getBean(MapperFacade.class);
    }
}
