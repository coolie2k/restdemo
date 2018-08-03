package com.lycoo.tweetengine.restdemo.Twitter.api;

import java.io.Serializable;
import java.util.Arrays;

/**
 * <p>A representation of tweet hashtags.</p>
 * @author bowen
 */
public class HashTagEntity extends TwitterObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private String text;

    private int[] indices;

    public String getText() {
        return this.text;
    }

    public HashTagEntity(String text, int[] indices) {
        this.text = text;
        this.indices = indices;
    }

    public int[] getIndices() {
        if (this.indices == null || this.indices.length <= 0) {
            return new int[0];
        }
        return this.indices;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HashTagEntity that = (HashTagEntity) o;

        if (!Arrays.equals(indices, that.indices)) {
            return false;
        }
        if (text != null ? !text.equals(that.text) : that.text != null) {
            return false;
        }

        return true;
    }


    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (indices != null ? Arrays.hashCode(indices) : 0);
        return result;
    }
}
