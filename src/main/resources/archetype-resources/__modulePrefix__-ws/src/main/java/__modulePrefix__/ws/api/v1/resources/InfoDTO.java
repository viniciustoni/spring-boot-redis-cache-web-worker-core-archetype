package ${groupId}.${modulePrefix}.ws.api.v1.resources;

import java.io.Serializable;

public class InfoDTO implements Serializable {

    private static final long serialVersionUID = -7179572722349789441L;

    private String projectName;

    private String version;

    private String timestamp;

    public String getProjectName() {

        return projectName;
    }

    public void setProjectName(String projectName) {

        this.projectName = projectName;
    }

    public String getVersion() {

        return version;
    }

    public void setVersion(String version) {

        this.version = version;
    }

    public String getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(String timestamp) {

        this.timestamp = timestamp;
    }

}
