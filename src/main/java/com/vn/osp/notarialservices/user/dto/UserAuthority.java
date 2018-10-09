package com.vn.osp.notarialservices.user.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;


@XStreamAlias("UserAuthority")
public class UserAuthority extends BaseEntityBeans {
  private Long user_id;
  private Long groupid;

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public Long getGroupid() {
    return groupid;
  }

  public void setGroupid(Long groupid) {
    this.groupid = groupid;
  }
}
