package com.myd.app.component;

import com.myd.app.bean.form.PersonForm;
import com.myd.app.bean.request.PersonDataRequest;
import com.myd.app.bean.request.PersonRequest;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
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
        mapperFactory.classMap(PersonForm.class, PersonRequest.class)
                .customize(new CustomMapper<PersonForm, PersonRequest>() {
                    @Override
                    public void mapAtoB(PersonForm personForm, PersonRequest personRequest, MappingContext context) {
                        personRequest.setPersonDataRequest(mapperFacade.map(personForm, PersonDataRequest.class));
                    }
                })
                .register();
        mapperFactory.classMap(PersonForm.class,PersonDataRequest.class)
                .field("formName","requestName")
                .field("formSex","requestSex")
                .field("province","address.province")
                .field("city","address.city")
                .byDefault()
                .register();
    }
}
