package com.vn.osp.notarialservices.manual.dto;

/**
 * Created by minh on 3/27/2017.
 */
public class AddManual {
    private String title;
    private String content;
    private String file_name;
    private String file_path;
    private Long entry_user_id;
    private String entry_user_name;
    private Long update_user_id;
    private String update_user_name;



    public AddManual() {
    }
    public AddManual( String title, String content,String file_name ,String file_path , Long entry_user_id, String entry_user_name, Long update_user_id, String update_user_name) {
        this.title = title;
        this.content = content;
        this.file_name = file_name;
        this.file_path = file_path;
        this.entry_user_id = entry_user_id;
        this.entry_user_name = entry_user_name;
        this.update_user_id = update_user_id;
        this.update_user_name = update_user_name;
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
}
