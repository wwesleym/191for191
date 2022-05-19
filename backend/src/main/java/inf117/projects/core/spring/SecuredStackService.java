package inf117.projects.core.spring;

import com.codingsprojects.stack.core.spring.StackService;
import inf117.projects.core.security.JWTAuthenticationFilter;
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
