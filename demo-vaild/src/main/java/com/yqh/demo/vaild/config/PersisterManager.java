package com.yqh.demo.vaild.config;

import com.google.common.collect.Lists;
import com.yqh.demo.vaild.anno.PersisterScan;
import com.yqh.demo.vaild.anno.ProcessorScan;
import com.yqh.demo.vaild.persister.Persister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;


@Component
public class PersisterManager {

    @Autowired
    private ApplicationContext context;

    private Map<String, List<Persister>> scenePersisterMap = new HashMap<>();

    @PostConstruct
    public void init() {

        // 扫描所有Persister组件
        Map<String, Persister> persisterMap = context.getBeansOfType(Persister.class);

        // 按场景分类
        persisterMap.forEach((name, persister) -> {
            PersisterScan persisterScan = persister.getClass().getAnnotation(PersisterScan.class);
            ProcessorScan processorScan = persister.getClass().getAnnotation(ProcessorScan.class);
            if (persisterScan != null) {
                process(persister, persisterScan.scenes(), persisterScan.value());
            } else if (processorScan != null) {
                process(persister, processorScan.scenes(), processorScan.value());
            }
        });
    }

    private void process(Persister persister, String[] scenes, int order) {
        for (String scene : scenes) {
            scenePersisterMap.computeIfAbsent(scene, k -> new ArrayList<>()).add(persister);
        }
        scenePersisterMap.forEach((scene, persisters) ->
                persisters.sort(Comparator.comparingInt(v -> order))
        );
    }

    public List<Persister> getPersisters(String scene) {
        return scenePersisterMap.getOrDefault(scene, Collections.emptyList());
    }


}
