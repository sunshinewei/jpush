package izijia.ccpress.com.jpushdemo.bean;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/10.
 */

public class ExampleBean implements Serializable{



    private boolean isClick = false;

    private String id;

    private String image;

    private int age;

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


    private void writeObject(java.io.ObjectOutputStream stream)
            throws java.io.IOException
    {
        // "Encrypt"/obscure the sensitive data
        age = age << 2;
        stream.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws java.io.IOException, ClassNotFoundException
    {
        stream.defaultReadObject();

        // "Decrypt"/de-obscure the sensitive data
        age = age << 2;
    }

}
