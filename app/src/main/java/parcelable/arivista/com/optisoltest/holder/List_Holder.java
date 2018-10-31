package parcelable.arivista.com.optisoltest.holder;

import com.google.gson.annotations.SerializedName;

public class List_Holder {

    @SerializedName("albumId")
    int albumId;
    @SerializedName("id")
    int id;
    @SerializedName("url")
    String url;
    @SerializedName("title")
    String title;
    @SerializedName("thumbnailUrl")
    String thumbnailUrl;

    public List_Holder(int albumId, int id, String url, String title, String thumbnailUrl) {
        this.albumId=albumId;
        this.id = id;
        this.url = url;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}