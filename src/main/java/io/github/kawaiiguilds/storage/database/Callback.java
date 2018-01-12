package io.github.kawaiiguilds.storage.database;

public interface Callback<V> {

    void result(V param) throws Exception;

}
