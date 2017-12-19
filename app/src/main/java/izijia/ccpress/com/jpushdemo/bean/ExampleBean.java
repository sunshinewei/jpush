package izijia.ccpress.com.jpushdemo.bean;

/**
 * Created by Administrator on 2017/12/10.
 */

public class ExampleBean {


    private boolean isClick = false;

    private String id;

    private String image;

    public ExampleBean(boolean isClick, String id, String image) {
        this.isClick = isClick;
        this.id = id;
        this.image = image;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
