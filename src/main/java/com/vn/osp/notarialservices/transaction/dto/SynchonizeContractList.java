package com.vn.osp.notarialservices.transaction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by nmha on 3/18/2017.
 */
public class SynchonizeContractList {

    private  String synAccount;
    private  String synPass;
    private  List<SynchronizeContractTag> synchonizeContractList;

    public String getSynAccount() {
        return synAccount;
    }

    public void setSynAccount(String synAccount) {
        this.synAccount = synAccount;
    }

    public String getSynPass() {
        return synPass;
    }

    public void setSynPass(String synPass) {
        this.synPass = synPass;
    }

    public List<SynchronizeContractTag> getSynchonizeContractList() {
        return synchonizeContractList;
    }

    public void setSynchonizeContractList(List<SynchronizeContractTag> synchonizeContractList) {
        this.synchonizeContractList = synchonizeContractList;
    }

    public SynchonizeContractList() {
    }

    @JsonCreator
    public SynchonizeContractList(@JsonProperty("synAccount") String synAccount,
                                  @JsonProperty("synPass") String synPass,
                                  @JsonProperty("synchonizeContractList") List<SynchronizeContractTag> synchonizeContractList) {
        this.synAccount = synAccount;
        this.synPass = synPass;
        this.synchonizeContractList = synchonizeContractList;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"synAccount\":\"").append(synAccount).append("\",");
        sb.append("\"synPass\":\"").append(synPass).append("\",");

        if(synchonizeContractList != null && synchonizeContractList.size() > 0){
            sb.append("\"synchonizeContractList\":");
            sb.append("[");
            for(int i = 0; i < synchonizeContractList.size(); i++){
                SynchronizeContractTag synchonizeContractListCur = synchonizeContractList.get(i);
                sb.append(synchonizeContractListCur.toString());
                if(i < synchonizeContractList.size() -1){
                    sb.append(",");
                }
            }
            sb.append("]");

        }
        sb.append('}');
        return sb.toString();
    }
    public String convertToJson(){
        JSONObject obj = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
