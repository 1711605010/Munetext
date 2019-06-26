package cn.gdptc.xxgcx.munetext.uilt;

public class Userinfo {

    private String name;

    private String psw;

    public Userinfo(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {

        this.psw = psw;
    }

    public Userinfo() {

    }
}
