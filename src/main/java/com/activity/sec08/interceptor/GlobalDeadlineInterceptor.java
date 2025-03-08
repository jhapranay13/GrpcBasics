package com.activity.sec08.interceptor;

import com.activity.common.GrpcClient;
import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class GlobalDeadlineInterceptor implements ClientInterceptor {
    private static final Logger log = LoggerFactory.getLogger(GlobalDeadlineInterceptor.class);


    private final Duration duration;

    public GlobalDeadlineInterceptor(Duration duration) {
        this.duration = duration;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT>
        interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,// incase you want to restrict an interceptor for a method
                      CallOptions callOptions, Channel channel) {
        log.info("Deadline interceptor called");
        // in case if it is also set during the call then that will be used
        callOptions = Objects.isNull(callOptions.getDeadline()) ?
                callOptions.withDeadline(Deadline.after(duration.toMillis(), TimeUnit.MILLISECONDS))
                : callOptions;
        return channel.newCall(methodDescriptor, callOptions); // if only this then forwarding
    }
}
