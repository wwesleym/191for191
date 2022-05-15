package com.github.klefstad_teaching.cs122b.core.spring;

import com.github.klefstad_teaching.cs122b.core.security.JWTAuthenticationFilter;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({
    JWTAuthenticationFilter.class,
})
@StackService
public @interface SecuredStackService
{
}
