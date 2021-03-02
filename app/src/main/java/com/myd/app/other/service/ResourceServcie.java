package com.myd.app.other.service;

import com.myd.client.family.Family;
import com.myd.client.family.FamilyResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/26 15:33
 * @Description:
 */
@Service
public class ResourceServcie {

    public Family getFamilyByName(String name,String id){
        if(StringUtils.isEmpty(id)){
            id = "";
        }
        return FamilyResource.getFamilyByName(name,id);
    }
}
