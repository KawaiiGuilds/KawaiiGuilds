package io.github.kawaiiguilds.configuration;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.util.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Configuration {

    private File file;
    private Class<?> clazz;

    public Configuration(File file, Class<?> clazz) {
        this.file = file;
        this.clazz = clazz;
        this.reloadConfig();
    }

    private void parse(Class<?> clazz, YamlConfiguration config) {
        try {
            for (Field f : clazz.getFields()) {
                if (Modifier.isStatic(f.getModifiers()) && Modifier.isPublic(f.getModifiers())) {
                    if (!f.isAnnotationPresent(Ignore.class)) {
                        String path = f.getName().toLowerCase().replace('$', '.');
                        Object def = f.get(null);
                        Object value = config.get(path, def);
                        if (f.getType() == String.class && value instanceof String) {
                            value = ColorUtil.fixColor((String) value);
                        }
                        config.set(path, value);
                        f.set(null, value);
                    }
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void parseSave(Class<?> clazz, YamlConfiguration config) {
        try {
            for (Field f : clazz.getFields()) {
                if (Modifier.isStatic(f.getModifiers()) && Modifier.isPublic(f.getModifiers())) {
                    if (!f.isAnnotationPresent(Ignore.class)) {
                        String path = f.getName().toLowerCase().replace('$', '.');
                        Object value = f.get(null);
                        config.set(path, value);
                    }
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private File checkFile() {
        File configFile = this.file;
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();

            try {
                configFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        return configFile;
    }

    public synchronized void reloadConfig() {
        File configFile = this.checkFile();
        try {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
            this.parse(this.clazz, config);
            config.save(configFile);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(KawaiiGuilds.getProvidingPlugin(KawaiiGuilds.class));

        }
    }

    public synchronized void saveConfig() {
        File configFile = this.checkFile();
        try {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
            this.parseSave(this.clazz, config);
            config.save(configFile);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(KawaiiGuilds.getProvidingPlugin(KawaiiGuilds.class));
        }
    }
}

