package com.myd.client.family;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/26 10:09
 * @Description:
 */
public enum FamilyType {
    /**
     * 祖父
     */
    grandfather,
    /**
     * 祖母
     */
    grandmother,
    /**
     * 父亲
     */
    father,
    /**
     * 母亲
     */
    mother,
    /**
     * 子
     */
    son,
    /**
     * 女
     */
    daughter;

    public static FamilyType of(final String name){
        return Arrays.stream(values()).filter(v-> StringUtils.endsWithIgnoreCase(v.name(),name)).findFirst().orElse(null);
    }
}
