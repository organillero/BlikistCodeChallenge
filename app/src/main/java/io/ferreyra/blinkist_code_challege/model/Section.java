package io.ferreyra.blinkist_code_challege.model;

import java.util.List;

/**
 * Created by carlos on 10/30/17.
 */

public class Section {
    private String header;
    private List<BlkBook> items;

    public Section(String header, List<BlkBook> items) {
        this.header = header;
        this.items = items;
    }

    public String getHeader() {
        return header;
    }

    public List<BlkBook> getItems() {
        return items;
    }
}
