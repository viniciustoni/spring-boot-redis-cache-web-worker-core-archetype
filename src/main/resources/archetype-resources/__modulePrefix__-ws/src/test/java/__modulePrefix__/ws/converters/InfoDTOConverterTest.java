package ${groupId}.${modulePrefix}.ws.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.mockito.InjectMocks;

import ${groupId}.${modulePrefix}.ws.TemplateWsBaseTeste;
import ${groupId}.${modulePrefix}.ws.api.v1.resources.InfoDTO;
import ${groupId}.${modulePrefix}.ws.template.properties.InfoTemplate;
import ${groupId}.${modulePrefix}.core.config.properties.MyApplicationProperties.Info;
import br.com.six2six.fixturefactory.Fixture;

public class InfoDTOConverterTest extends TemplateWsBaseTeste {

    @InjectMocks
    private InfoDTOConverter infoDTOConverter;

    @Test(expected = IllegalAccessError.class)
    public void testFrom() {

        infoDTOConverter.from(null);
    }

    @Test
    public void testTo() {

        final Info info = Fixture.from(Info.class).gimme(InfoTemplate.Template.VALID.name());

        final InfoDTO infoDTO = infoDTOConverter.to(info);

        assertNotNull(infoDTO);
        assertEquals(info.getProjectName(), infoDTO.getProjectName());
        assertEquals(info.getTimestamp(), infoDTO.getTimestamp());
        assertEquals(info.getVersion(), infoDTO.getVersion());

    }

    @Test
    public void testToNull() {

        final InfoDTO infoDTO = infoDTOConverter.to(null);
        assertNull(infoDTO);
    }

}
