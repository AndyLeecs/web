package com.didispace.Chapter1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by qwe on 2018/1/30.
 */
@Component
public class BlogProperties {
    @Value("${title}")
    private String title;
    @Value("${name}")
    private String name;
    @Value("${sen}")
    private String sen;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSen() {
        return sen;
    }

    public void setSen(String sen) {
        this.sen = sen;
    }
}

