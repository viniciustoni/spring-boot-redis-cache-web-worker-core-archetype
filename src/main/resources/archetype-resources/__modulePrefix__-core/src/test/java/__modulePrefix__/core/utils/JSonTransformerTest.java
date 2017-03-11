package ${groupId}.${modulePrefix}.core.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import ${groupId}.${modulePrefix}.core.TemplateCoreBaseTeste;
import ${groupId}.${modulePrefix}.core.queue.dto.TemplateDTO;
import ${groupId}.${modulePrefix}.core.template.TemplateDTOTemplate;

public class JSonTransformerTest extends TemplateCoreBaseTeste {

    @Test
    public void testConvertToJson() {

        final TemplateDTO templateDTO = Fixture.from(TemplateDTO.class).gimme(TemplateDTOTemplate.Template.VALID.name());

        final String json = JSonTransformer.convertToJson(templateDTO);

        assertNotNull(json);
    }

    @Test
    public void testConvertToJsonNull() {

        final String json = JSonTransformer.convertToJson(null);

        assertNull(json);

    }

    @Test
    public void testConvertToObject() {

        final TemplateDTO templateDTO = Fixture.from(TemplateDTO.class).gimme(TemplateDTOTemplate.Template.VALID.name());

        final String json = JSonTransformer.convertToJson(templateDTO);

        final TemplateDTO templateConvertedDTO = JSonTransformer.convertToObject(json, TemplateDTO.class);

        assertEquals(templateDTO.getWebHook(), templateConvertedDTO.getWebHook());
    }

    @Test
    public void testConvertToObjectNull() {

        final TemplateDTO templateConvertedDTO = JSonTransformer.convertToObject(null, TemplateDTO.class);

        assertNull(templateConvertedDTO);

    }

}
