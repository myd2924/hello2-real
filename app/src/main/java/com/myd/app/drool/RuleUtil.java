package com.myd.app.drool;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/28 17:36
 * @Description: TODO
 */
public class RuleUtil {

    private static KieContainer kieContainer;

    public static KieContainer getKieContainer(){
        return kieContainer;
    }

    /**
     * 执行规则
     * @param fact
     * @param agendaGroup
     */
    public static void execute(Object fact, String agendaGroup) {
        KieSession kieSession = RuleUtil.getKieContainer().newKieSession();
        FactHandle factHandle = kieSession.getFactHandle(fact);
        if(factHandle != null) {
            kieSession.update(factHandle, fact);
        } else {
            kieSession.insert(fact);
        }
        kieSession.getAgenda().getAgendaGroup(agendaGroup).setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    public static void setKieContainer(KieContainer kieContainer){
        RuleUtil.kieContainer = kieContainer;
    }

}
