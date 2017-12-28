package io.github.kawaiiguilds.storage;

import java.io.IOException;

public interface Storage {

    void loadAll() throws IOException;

    void saveAll() throws IOException;
}
