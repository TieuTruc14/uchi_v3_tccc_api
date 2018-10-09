package com.vn.osp.notarialservices.manual.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

@XStreamAlias("Manual")
public class Manual extends BaseEntityBeans {
  private Long id;
  private String title;
  private String content;
  private String file_name;
  private String file_path;
  private Long entry_user_id;
  private String entry_user_name;
  private String entry_date_time;
  private Long update_user_id;
  private String update_user_name;
  private String update_date_time;

  @JsonCreator
  public Manual(
          @JsonProperty(value="id",required= true) final Long id,
          @JsonProperty(value="title", required = true) final String title,
          @JsonProperty(value="content", required= true) final String content,
          @JsonProperty(value="file_name", required= true) final String file_name,
          @JsonProperty(value="file_path", required= true) final String file_path,
          @JsonProperty(value="entry_user_id",required = true) final Long entry_user_id,
          @JsonProperty(value="entry_user_name", required= true) final String entry_user_name,
          @JsonProperty(value="entry_date_time", required = true) final String entry_date_time,
          @JsonProperty(value="update_user_id", required= true) final Long update_user_id,
          @JsonProperty(value="update_user_name",required= true) final String update_user_name,
          @JsonProperty(value="update_date_time", required=true) final String update_date_time
  ){
    this.id = id;
    this.title = title;
    this.content = content;
    this.file_name = file_name;
    this.file_path = file_path;
    this.entry_user_id = entry_user_id;
    this.entry_user_name = entry_user_name;
    this.entry_date_time = entry_date_time;
    this.update_user_id = update_user_id;
    this.update_user_name = update_user_name;
    this.update_date_time = update_date_time;
  }

  public Manual() {
  }

  public Long getMid() {
    return id;
  }

  public void setMid(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getFile_name() {
    return file_name;
  }

  public void setFile_name(String file_name) {
    this.file_name = file_name;
  }

  public String getFile_path() {
    return file_path;
  }

  public void setFile_path(String file_path) {
    this.file_path = file_path;
  }

  public Long getEntry_user_id() {
    return entry_user_id;
  }

  public void setEntry_user_id(Long entry_user_id) {
    this.entry_user_id = entry_user_id;
  }

  public String getEntry_user_name() {
    return entry_user_name;
  }

  public void setEntry_user_name(String entry_user_name) {
    this.entry_user_name = entry_user_name;
  }

  public String getEntry_date_time() {
    return entry_date_time;
  }

  public void setEntry_date_time(String entry_date_time) {
    this.entry_date_time = entry_date_time;
  }

  public Long getUpdate_user_id() {
    return update_user_id;
  }

  public void setUpdate_user_id(Long update_user_id) {
    this.update_user_id = update_user_id;
  }

  public String getUpdate_user_name() {
    return update_user_name;
  }

  public void setUpdate_user_name(String update_user_name) {
    this.update_user_name = update_user_name;
  }

  public String getUpdate_date_time() {
    return update_date_time;
  }

  public void setUpdate_date_time(String update_date_time) {
    this.update_date_time = update_date_time;
  }

}
