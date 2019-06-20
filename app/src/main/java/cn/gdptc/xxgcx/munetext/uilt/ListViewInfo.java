package cn.gdptc.xxgcx.munetext.uilt;

public class ListViewInfo {
    private String content;
    private int ImageId;

    public ListViewInfo(int imageId,String content) {
        this.content = content;
        ImageId = imageId;
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
}
