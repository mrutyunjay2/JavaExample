package mtj.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BlogWrapper {

    @SerializedName("data")
    private List<Blog>blogList ;
    @SerializedName("error")
    private String mError ;
    @SerializedName("message")
    private List<Blog>message ;

    @SerializedName("status")
    private String mStatus;

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public String getmError() {
        return mError;
    }

    public void setmError(String mError) {
        this.mError = mError;
    }

    public List<Blog> getMessage() {
        return message;
    }

    public void setMessage(List<Blog> message) {
        this.message = message;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }
}
