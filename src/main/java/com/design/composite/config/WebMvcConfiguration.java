package com.design.composite.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;


@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * json序列化
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig converterConfig = new FastJsonConfig();
        converterConfig.setSerializerFeatures(
                PrettyFormat,
                WriteNullListAsEmpty,
                WriteNullStringAsEmpty,
                WriteMapNullValue);
        converter.setFastJsonConfig(converterConfig);
        converters.add(converter);
    }

}
