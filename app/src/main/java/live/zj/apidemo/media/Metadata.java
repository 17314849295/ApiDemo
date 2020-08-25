package live.zj.apidemo.media;

public class Metadata {

    private String mKey;
    private Object mValue;

    public Metadata(String key, Object value) {
        mKey = key;
        mValue = value;
    }

    /**
     * @return the mKey
     */
    public String getKey() {
        return mKey;
    }

    /**
     * @param mKey the mKey to set
     */
    public void setKey(String mKey) {
        this.mKey = mKey;
    }

    /**
     * @return the mValue
     */
    public Object getValue() {
        return mValue;
    }

    /**
     * @param mValue the mValue to set
     */
    public void setValue(Object mValue) {
        this.mValue = mValue;
    }
}
