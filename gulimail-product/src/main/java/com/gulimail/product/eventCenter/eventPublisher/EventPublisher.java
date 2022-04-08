package com.gulimail.product.eventCenter.eventPublisher;

import com.gulimail.product.eventCenter.event.BrandNameChange;
import com.gulimail.product.eventCenter.event.CateNameChange;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher applicationContext;
  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationContext = applicationEventPublisher;
  }

  public void publishBrandNameChange(long id, String newName){
    BrandNameChange event = new BrandNameChange(this, id, newName);
    applicationContext.publishEvent(event);
  }

  public void publishCateNameChange(long id, String newName){
    CateNameChange event = new CateNameChange(this, id, newName);
    applicationContext.publishEvent(event);
  }
}
