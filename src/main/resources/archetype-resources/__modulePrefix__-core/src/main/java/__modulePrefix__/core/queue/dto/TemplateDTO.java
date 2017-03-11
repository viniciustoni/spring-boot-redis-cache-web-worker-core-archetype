package ${groupId}.${modulePrefix}.core.queue.dto;

import java.io.Serializable;

import br.com.vinicius.helloWorld.core.queue.dto.TemplateDTO;

public class TemplateDTO implements Serializable {

    private static final long serialVersionUID = -7667155476374155072L;

    private String webHook;

    public String getWebHook() {

        return webHook;
    }

    public void setWebHook(String webHook) {

        this.webHook = webHook;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((webHook == null) ? 0 : webHook.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof TemplateDTO)) return false;
        TemplateDTO other = (TemplateDTO) obj;
        if (webHook == null) {
            if (other.webHook != null) return false;
        } else if (!webHook.equals(other.webHook)) return false;

        return true;
    }

    @Override
    public String toString() {

        return "TemplateDTO [webHook=" + webHook + "]";
    }

}
