package com.core.utils;

import static com.core.constant.Env.DEV;
import static java.lang.ThreadLocal.withInitial;

import com.core.model.YamlConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtils {
  private static final ThreadLocal<Map<String, YamlConfig>> context = withInitial(HashMap::new);

  public static String getRunningEnv() {
    //TODO sample repo so I just hard the DEV environment
    return DEV;
  }

  public static void setYamlConfig() {
    context.get().put(
        getRunningEnv(),
        yamlToObject(
            YamlConfig.class, getResourceDir() + String.format("config-%s.yml", getRunningEnv())));
  }

  public static YamlConfig getYamlConfig() {
    return context.get().get(getRunningEnv());
  }

  /*** HANDLE PATH UTILS ***/
  public static String getAbsolutePath(String path) {
    File file = new File(path);
    return file.getAbsolutePath();
  }

  public static String getRootDir() {
    return System.getProperty("user.dir");
  }

  public static String getResourceDir() {
    return getRootDir() + "/src/main/resources/";
  }

  /*** CONVERT TYPE METHODS ***/
  public static <T> T throwableWrapper(ThrowableSupplier<T> supplier) {
    return supplier.get();
  }

  public static <T> T yamlToObject(Class<T> clazz, String filePath) {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    return throwableWrapper(() -> mapper.readValue(new File(filePath), clazz));
  }

  public static <T> T stringToObject(String source, Class<T> clazz) {
    ObjectMapper mapper = new ObjectMapper();
    return throwableWrapper(() -> mapper.readValue(source, clazz));
  }

  private CommonUtils() {}
}
