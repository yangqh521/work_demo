package com.yqh.demo.dubbo.base.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.*;
import com.yqh.demo.commons.enums.TraceLogType;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @author : yangqh521
 * @date : 2019/12/13
 * @desc : Dubbo消费者拦截器
 */
@Slf4j
@Activate(group = {Constants.CONSUMER})
public class ConsumerRpcTraceFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String URI = MDC.get(TraceLogType.URI.name());
        String traceId = MDC.get(TraceLogType.TRACE_ID.name());
        if (StringUtils.isBlank(traceId)) {
            traceId = TraceLogType.getTraceId();
        }
        RpcContext.getContext().setAttachment(TraceLogType.URI.name(), URI);
        RpcContext.getContext().setAttachment(TraceLogType.TRACE_ID.name(), traceId);
        System.out.println("[ ConsumerRpcTraceFilter ] URI:" + URI + ", TRACE_ID:" + traceId);
        return invoker.invoke(invocation);
    }

}
