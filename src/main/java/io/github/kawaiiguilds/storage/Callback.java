package io.github.kawaiiguilds.storage;

public interface Callback<V> {

    void result(V param) throws Exception;
}
