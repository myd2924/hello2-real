package com.myd.client.family;

import com.myd.client.util.ResourceUtils;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;


import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/26 11:30
 * @Description:
 */
@UtilityClass
public class FamilyResource {
    private final List<Family> familyList = ResourceUtils.loadArry("template.json",Family.class);

    public Family getFamilyById(String id){
        return familyList.stream().filter(f-> StringUtils.endsWithIgnoreCase(id,f.getId())).findFirst().orElse(null);
    }

    public Family getFamilyByName(String name,String id){
        return familyList
                .stream()
                .filter(f-> StringUtils.endsWithIgnoreCase(name,f.getName()) && (StringUtils.isEmpty(id) || StringUtils.endsWithIgnoreCase(id,f.getId())))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        System.out.println(getFamilyByName("丁家学",""));
        System.out.println(getFamilyById("f01"));
        System.out.println(getFamilyById("d01"));
    }
}
