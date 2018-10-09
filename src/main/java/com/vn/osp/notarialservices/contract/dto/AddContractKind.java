/*package com.vn.osp.notarialservices.contractkind.dto;

*//**
 * Created by Admin on 7/6/2017.
 *//*
public class AddContractKind {
}*/
package com.vn.osp.notarialservices.contract.dto;

/**
 * Created by minh on 5/30/2017.
 */
public class AddContractKind {
    private String id;
    private String name;
    private Long update_user_id;
    private String update_user_name;



    private String code;

    public AddContractKind() {
    }

    public AddContractKind(String id, String name, Long update_user_id, String update_user_name, String code) {
        this.id = id;
        this.name = name;
        this.update_user_id = update_user_id;
        this.update_user_name = update_user_name;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
