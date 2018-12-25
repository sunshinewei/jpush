package izijia.ccpress.com.jpushdemo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2018/4/12.
 */

public class ProDetailBean  implements Serializable{




    private String name;

    private String title;

    private int type; //布局类型

    private String key;

    private int onClick;

    private int gride; //控制网格 1，网格


    public int getGride() {
        return gride;
    }

    public ProDetailBean setGride(int gride) {
        this.gride = gride;
        return this;
    }

    public ProDetailBean setOnClick(int onClick) {
        this.onClick = onClick;
        return this;
    }

    public int getOnClick() {
        return onClick;
    }

    private ArrayList<String> propoty;


    public String getName() {
        return name;
    }

    public ProDetailBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ProDetailBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getType() {
        return type;
    }

    public ProDetailBean setType(int type) {
        this.type = type;
        return this;
    }

    public ArrayList<String> getPropoty() {
        return propoty;
    }

    public ProDetailBean setPropoty(ArrayList<String> propoty) {
        this.propoty = propoty;
        return this;
    }

    public String getKey() {
        return key;
    }

    public ProDetailBean setKey(String key) {
        this.key = key;
        return this;
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
