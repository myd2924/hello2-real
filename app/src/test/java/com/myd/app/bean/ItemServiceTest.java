package com.myd.app.bean;

import com.myd.app.axon.service.ItemService;
import com.myd.app.bean.form.PersonForm;
import com.myd.app.bean.request.PersonRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/27 10:18
 * @Description:
 */
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Test
    public void test1(){
        final PersonForm personForm = PersonForm.builder()
                .formName("晨曦")
                .formSex("girl")
                .province("江苏")
                .city("南京")
                .age(5)
                .build();
        final PersonRequest request = itemService.copyBean(personForm);
        System.out.println(request);

    }

}
