package com.gulimail.product.eventCenter.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;


public class BrandNameChange extends ApplicationEvent {
  private long brandId;
  private String brandName;

  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   *               which the event is associated (never {@code null})
   */
  public BrandNameChange(Object source, long brandId, String brandName) {
    super(source);
    this.brandId = brandId;
    this.brandName = brandName;
  }

  public long getBrandId() {
    return brandId;
  }

  public void setBrandId(long brandId) {
    this.brandId = brandId;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }
}
