package k.javine.myswipelist.model;

/**
 * Created by Administrator on 2016/4/3.
 */
public class UserInfo {
    private long id;
    private String name;
    private boolean isSelected;

    public UserInfo(long id, String name){
        this.id = id;
        this.name = name;
    }

    public UserInfo(){

    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
