package com.yqh.demo.vaild.config;

import com.yqh.demo.vaild.anno.PersisterScan;
import com.yqh.demo.vaild.anno.ProcessorScan;
import com.yqh.demo.vaild.anno.ValidatorScan;
import com.yqh.demo.vaild.persister.Persister;
import com.yqh.demo.vaild.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @Author: yangqinghui@cfhy.com
 * @Description:
 * @Date: Created in 11:44 2025/7/25
 * @Modified By:
 */
@Component
public class ValidatorManager {

    @Autowired
    private ApplicationContext context;

    private Map<String, List<Validator>> sceneValidatorMap = new HashMap<>();

    @PostConstruct
    public void init() {
        // 扫描所有 Validator 组件
        Map<String, Validator> validatorMap = context.getBeansOfType(Validator.class);
        // 按场景分类
        validatorMap.forEach((name, validator) -> {
            ValidatorScan validatorScan = validator.getClass().getAnnotation(ValidatorScan.class);
            ProcessorScan processorScan = validator.getClass().getAnnotation(ProcessorScan.class);
            if (validatorScan != null) {
                for (String scene : validatorScan.scenes()) {
                    sceneValidatorMap.computeIfAbsent(scene, k -> new ArrayList<>()).add(validator);
                }
            }
        });
    }

    private void process(Validator validator, String[] scenes, int order) {
        for (String scene : scenes) {
            sceneValidatorMap.computeIfAbsent(scene, k -> new ArrayList<>()).add(validator);
        }
        // 对每个场景的validator按顺序排序
        sceneValidatorMap.forEach((scene, validators) ->
                validators.sort(Comparator.comparingInt(v -> order))
        );
    }

    public List<Validator> getValidators(String scene) {
        return sceneValidatorMap.getOrDefault(scene, Collections.emptyList());
    }


}
