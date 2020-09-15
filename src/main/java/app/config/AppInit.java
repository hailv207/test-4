package app.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import sun.misc.CharacterEncoder;

import javax.servlet.Filter;
import java.io.IOException;
import java.io.OutputStream;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncoder = new CharacterEncodingFilter();
        characterEncoder.setEncoding("UTF-8");
        characterEncoder.setForceEncoding(true);
        return new Filter[]{characterEncoder};
    }
}