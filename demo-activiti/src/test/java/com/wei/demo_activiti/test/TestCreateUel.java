package com.wei.demo_activiti.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCreateUel {

    /**
     * 使用 activiti 提供的默认方法创建MySQL表
     */
    @Test
    public void testCreateDbTable() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }

    /**
     * 部署流程
     */
    @Test
    public void testDeployment() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .name("出差申请流程-部署")
                .addClasspathResource("process/process02.bpmn20.xml")
                .addClasspathResource("process/process02.png")
                .deploy();

        System.out.println(deployment);
    }

    /**
     * 启动流程实例
     */
    @Test
    public void testStartProcess() {
        Map<String, Object> vars = new HashMap<>();
        vars.put("var01", "zhangsanuel");
        vars.put("var02", "lisiuel");
        vars.put("var03", "wangwuuel");
        vars.put("var04", "zhaoliuuel");

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("process02", vars);

        System.out.println(instance);
    }

    /**
     * 查询个人待执行任务
     */
    @Test
    public void testFindPersonalTaskList() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("myProcess01")
                .taskAssignee("zhangsan")
                .list();

        System.out.println(taskList);
    }

    /**
     * 查询个人待执行任务
     */
    @Test
    public void testCompleteTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        taskService.complete("");
    }

    /**
     * 删除流程定义
     */
    @Test
    public void testDeleteProcess() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.deleteDeployment(""); // 不存在未结束流程时可以删除
        repositoryService.deleteDeployment("", true); // 存在未结束流程，关联删除
    }

    /**
     * 下载文件资源
     */
    @Test
    public void testDownloadFile() throws IOException {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("myProcess01")
                .singleResult();
        String deploymentId = processDefinition.getDeploymentId();

        String pngName = processDefinition.getDiagramResourceName();
        InputStream pngInput = repositoryService.getResourceAsStream(deploymentId, pngName);
        String fileName = processDefinition.getResourceName();
        InputStream xmlInput = repositoryService.getResourceAsStream(deploymentId, fileName);

        File pngFile = new File("c:/aaa.png");
        FileOutputStream pngOs = new FileOutputStream(pngFile);
        IOUtils.copy(pngInput, pngOs);

        File xmlFile = new File("c:/aaa.xml");
        FileOutputStream xmlOs = new FileOutputStream(xmlFile);
        IOUtils.copy(xmlInput, xmlOs);

        pngInput.close();
        xmlInput.close();
        pngOs.close();
        xmlOs.close();

    }

}
