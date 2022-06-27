package com.core.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YamlConfig {
  String webUrl;
  Data data;
  Flags flags;
}