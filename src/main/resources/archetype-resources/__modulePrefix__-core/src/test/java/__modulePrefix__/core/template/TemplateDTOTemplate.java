package ${groupId}.${modulePrefix}.core.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import ${groupId}.${modulePrefix}.core.queue.dto.TemplateDTO;

public class TemplateDTOTemplate implements TemplateLoader {

    public enum Template {
        VALID
    }

    @Override
    public void load() {

        Fixture.of(TemplateDTO.class).addTemplate(Template.VALID.name(), new Rule() {

            {
                add("webHook", name());
            }
        });
    }

}
