package ${groupId}.${modulePrefix}.ws.api.v1;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import ${groupId}.${modulePrefix}.ws.api.v1.resources.InfoDTO;
import ${groupId}.${modulePrefix}.ws.converters.InfoDTOConverter;
import ${groupId}.${modulePrefix}.core.config.properties.MyApplicationProperties;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/status")
public class StatusRest {

    @Autowired
    private MyApplicationProperties MyApplicationProperties;
    
    @Autowired
    private InfoDTOConverter infoDTOConverter;
    
    @Timed
    @RequestMapping(method = RequestMethod.GET, path = "/")
    @ApiOperation(value = "Show application status", nickname = "Show application status")
    @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Success"), 
                @ApiResponse(code = 401, message = "Unauthorized"),
                @ApiResponse(code = 403, message = "Forbidden"), 
                @ApiResponse(code = 404, message = "Not Found"),
                @ApiResponse(code = 500, message = "Failure") 
    })
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public ResponseEntity<InfoDTO> status() {
        
        final InfoDTO infoDTO = infoDTOConverter.to(MyApplicationProperties.getInfo());
        return ResponseEntity.ok(infoDTO);
    }
    
}
