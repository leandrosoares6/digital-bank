package com.leandro.digitalbank.shared.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class AppException {
  private Integer status;
  private LocalDateTime dateTime;
  private String title;
  private List<Field> fields;

  @Getter
  @Setter
  @AllArgsConstructor
  public static class Field{
    private String name;
    private String message;
  }
}
