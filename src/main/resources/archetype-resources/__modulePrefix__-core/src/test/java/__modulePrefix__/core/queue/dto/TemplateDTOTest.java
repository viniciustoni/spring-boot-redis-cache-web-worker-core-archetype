package ${groupId}.${modulePrefix}.core.queue.dto;

import org.junit.Test;
import org.meanbean.test.BeanTester;

import br.com.vinicius.helloWorld.core.TemplateCoreBaseTeste;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TemplateDTOTest extends TemplateCoreBaseTeste {

    @Test
    public void testGetterAndSetters() {

        new BeanTester().testBean(TemplateDTO.class);
    }

    @Test
    public void testHashCodeEquals() {

        EqualsVerifier.forClass(TemplateDTO.class).suppress(Warning.NONFINAL_FIELDS, Warning.STRICT_INHERITANCE).verify();
    }

}
