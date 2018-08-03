package com.lycoo.tweetengine.restdemo.Twitter.api;

import java.io.Serializable;
import java.util.Arrays;

/**
 * A representation of embedded ticker symbol entity.
 * @author Craig Walls
 */
public class TickerSymbolEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tickerSymbol;

    private String url;

    private int[] indices;

    public TickerSymbolEntity(String tickerSymbol, String url, int[] indices) {
        this.tickerSymbol = tickerSymbol;
        this.url = url;
        this.indices = indices;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public String getUrl() {
        return url;
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

        TickerSymbolEntity that = (TickerSymbolEntity) o;

        if (tickerSymbol != null ? !tickerSymbol.equals(that.tickerSymbol) : that.tickerSymbol != null) {
            return false;
        }

        if (url != null ? !url.equals(that.url) : that.url != null) {
            return false;
        }

        return true;
    }


    @Override
    public int hashCode() {
        int result = tickerSymbol.hashCode() ^ (tickerSymbol.hashCode());
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (indices != null ? Arrays.hashCode(indices) : 0);
        return result;
    }
}
