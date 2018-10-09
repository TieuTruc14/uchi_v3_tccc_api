package com.vn.osp.notarialservices.common.converter;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by longtran on 02/11/2016.
 */
public interface Converter<T, K extends ResourceSupport> {
    T convert(K source);

    K convert(T source);
}
