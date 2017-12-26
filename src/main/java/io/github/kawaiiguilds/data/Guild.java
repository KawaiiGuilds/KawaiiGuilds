package io.github.kawaiiguilds.data;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private String tag;
    private String name;
    private User owner;

    private final List<User> members = new ArrayList<>();

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
