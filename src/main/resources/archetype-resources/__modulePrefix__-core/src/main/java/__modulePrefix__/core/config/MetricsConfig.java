package ${groupId}.${modulePrefix}.core.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

@Configuration
@EnableMetrics
public class MetricsConfig extends MetricsConfigurerAdapter {

    @Override
    public void configureReporters(final MetricRegistry metricRegistry) {

        registerReporter(ConsoleReporter.forRegistry(metricRegistry).build()).start(1, TimeUnit.MINUTES);
    }

}
