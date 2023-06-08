package com.wei.demo_activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.jupiter.api.Test;

public class TestCreate {

    /**
     * 使用 activiti 提供的默认方法创建MySQL表
     */
    @Test
    public void testCreateDbTable() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }

}
