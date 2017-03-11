package ${groupId}.${modulePrefix}.ws.converters;

import org.springframework.stereotype.Service;

import ${groupId}.${modulePrefix}.core.utils.Mapper;
import ${groupId}.${modulePrefix}.ws.api.v1.resources.InfoDTO;
import ${groupId}.${modulePrefix}.core.config.properties.MyApplicationProperties.Info;

@Service
public class InfoDTOConverter extends Mapper<Info, InfoDTO> {

    @Override
    public Info from(InfoDTO arg0) {
        throw new IllegalAccessError("Method not implemented.");
    }

    @Override
    public InfoDTO to(Info info) {

        InfoDTO infoDTO = null;
        
        if (info != null) {
            
            infoDTO = new InfoDTO();
            
            infoDTO.setProjectName(info.getProjectName());
            infoDTO.setTimestamp(info.getTimestamp());
            infoDTO.setVersion(info.getVersion());
        }
        
        return infoDTO;
    }
    
}
