package com.yqh.demo.dubbo.base.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.yqh.demo.commons.enums.TraceLogType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

/**
 * @author : yangqh521
 * @date : 2019/12/13
 * @desc : Dubbo生产者拦截器
 */
@Slf4j
@Activate(group = {Constants.PROVIDER}, order = 1)
public class ProviderRpcTraceFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = RpcContext.getContext().getAttachment(TraceLogType.TRACE_ID.name());
        String URI = RpcContext.getContext().getAttachment(TraceLogType.URI.name());
        if (StringUtils.isBlank(traceId)) {
            traceId = TraceLogType.getTraceId();
        }
        MDC.put(TraceLogType.TRACE_ID.name(), traceId);
        MDC.put(TraceLogType.URI.name(), StringUtils.isNotBlank(URI) ? URI : "-");
        try{
            System.out.println("[ ProviderRpcTraceFilter ] URI:" + URI + ", TRACE_ID:" + traceId);
            Result result = invoker.invoke(invocation);
            return result;
        }finally{
            MDC.remove(TraceLogType.TRACE_ID.name());
            MDC.remove(TraceLogType.URI.name());
            MDC.remove(TraceLogType.API.name());
            RpcContext.getContext().clearAttachments();
        }
    }

}
