package ${groupId}.${modulePrefix}.ws.template.properties;

import ${groupId}.${modulePrefix}.core.config.properties.MyApplicationProperties;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class InfoTemplate implements TemplateLoader {

    public enum Template {
        VALID
    }

    @Override
    public void load() {

        createValidsTemplate();
    }

    private void createValidsTemplate() {

        Fixture.of(MyApplicationProperties.Info.class).addTemplate(Template.VALID.name(), new Rule() {

            {
                add("projectName", "${modulePrefix}");
                add("version", "${version}");
                add("timestamp", "12345");
            }
        });

    }

}
