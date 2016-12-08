package ru.karachurin.docflow.web;

import org.springframework.util.Assert;

/**
 * Created by Денис on 08.12.2016.
 */
public class Range {
    private static final String RANGE_PREFIX = "items=";
    private Integer limit = 0;
    private Integer offset = 0;

    public Range(String header) {
        String range = header.replaceAll(RANGE_PREFIX, "");
        String[] parsed = range.split("-");
        Assert.isTrue(parsed.length == 2, "Range header in an unexpected format.");
        this.limit = new Integer(parsed[0]);
        this.offset = new Integer(parsed[1]);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}

