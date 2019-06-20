package cn.gdptc.xxgcx.munetext.uilt;

public class ListViewInfo {
    private String content,text;
    private int ImageId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ListViewInfo(int imageId, String content, String text) {
        this.content = content;
       this.ImageId = imageId;
        this.text=text;
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
