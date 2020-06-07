package my.ceshi;

public class Boys {


    private int id;
    private String boyName;
    private int userCP;

    public Boys(int id, String boyName, int userCP) {
        this.id = id;
        this.boyName = boyName;
        this.userCP = userCP;


    }
    public Boys(){//在这里创建一个无参构造，别的类里面反射会用到
super();
    }


    @Override
    public String toString() {
        return "Boys[" +
                "id=" + id +
                ", boyName='" + boyName + '\'' +
                ", userCP=" + userCP +
                ']';
    }

    public String getBoyName() {
        return boyName;
    }

    public void setBoyName(String boyName) {
        this.boyName = boyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserCP() {
        return userCP;
    }

    public void setUserCP(int userCP) {
        this.userCP = userCP;
    }
}
