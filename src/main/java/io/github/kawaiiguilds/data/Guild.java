package io.github.kawaiiguilds.data;

public interface Guild {

    String getTag();
    void setTag(String tag);

    String getName();
    void setName(String name);

    Cuboid getCuboid();

    int getLimit();
    void setLimit(int limit);

}
