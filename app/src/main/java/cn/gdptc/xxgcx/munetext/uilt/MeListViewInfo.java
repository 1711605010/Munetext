package cn.gdptc.xxgcx.munetext.uilt;

public class MeListViewInfo {
    private String content;
    private int ImageId,right;
    public MeListViewInfo(int imageId,String content,int right) {
        this.content = content;
       this.ImageId = imageId;
       this.right=right;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
