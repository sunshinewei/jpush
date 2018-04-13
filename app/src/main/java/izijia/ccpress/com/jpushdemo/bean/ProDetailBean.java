package izijia.ccpress.com.jpushdemo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2018/4/12.
 */

public class ProDetailBean {

    private String name;

    private String title;

    private String type;

    private String key;

    private ArrayList<String> propoty;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getPropoty() {
        return propoty;
    }

    public void setPropoty(ArrayList<String> propoty) {
        this.propoty = propoty;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ProDetailBean{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", key='" + key + '\'' +
                ", propoty=" + propoty +
                '}';
    }
}
