package com.gulimail.product.eventCenter.event;

import org.springframework.context.ApplicationEvent;

public class CateNameChange extends ApplicationEvent {
  private long cateId;
  private String name;


  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   *               which the event is associated (never {@code null})
   */
  public CateNameChange(Object source, long id, String name) {
    super(source);
    this.cateId = id;
    this.name = name;
  }

  public long getCateId() {
    return cateId;
  }

  public void setCateId(long cateId) {
    this.cateId = cateId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
