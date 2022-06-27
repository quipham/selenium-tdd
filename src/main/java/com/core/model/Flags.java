package com.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Flags {
  @JsonProperty("browser")
  private String browser;

  @JsonProperty("isHeadless")
  private boolean isHeadless;
}
