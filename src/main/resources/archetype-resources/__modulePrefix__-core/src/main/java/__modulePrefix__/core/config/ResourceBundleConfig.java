package ${groupId}.${modulePrefix}.core.config;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ResourceBundleConfig {

    @Bean
    public ResourceBundle resourceBundle() {

        return ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
    }

}
