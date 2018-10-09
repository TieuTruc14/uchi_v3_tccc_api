package com.vn.osp.notarialservices.transaction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by nmha on 3/17/2017.
 */
public class SynchronizeContractTag {

    private  String notaryOfficeCode;
    private  String contractKindCode;
    private Long code_template;
    private  String contractNumber;
    private  int typeSynchronize;
    private  String contractName;
    private  String transactionContent;
    private  String notaryDate;
    private  String notaryOfficeName;
    private  String notaryPerson;
    private  String notaryPlace;
    private Long notaryFee;
    private Long remunerationCost;
    private Long notaryCostTotal;
    private  String relationObjects;
    private  String contractPeriod;
    private  Long mortageCancelFlag;
    private  String mortageCancelDate;
    private  String mortageCancelNote;
    private  Long cancelStatus;
    private  String cancelDescription;
    private  String entryUserName;
    private  String entryDateTime;
    private  String updateUserName;
    private  String updateDateTime;
    private  String bankCode;
    private  String contractNote;
    private  String propertyInfo;
    private  String json_property;
    private  String json_person;

    @JsonCreator
    public SynchronizeContractTag(@JsonProperty("notaryOfficeCode") String notaryOfficeCode,
                                  @JsonProperty("contractKindCode") String contractKindCode,
                                  @JsonProperty("code_template") Long code_template,
                                  @JsonProperty("contractNumber") String contractNumber,
                                  @JsonProperty("typeSynchronize") int typeSynchronize,
                                  @JsonProperty("contractName") String contractName,
                                  @JsonProperty("transactionContent") String transactionContent,
                                  @JsonProperty("notaryDate") String notaryDate,
                                  @JsonProperty("notaryOfficeName") String notaryOfficeName,
                                  @JsonProperty("notaryPerson") String notaryPerson,
                                  @JsonProperty("notaryPlace") String notaryPlace,
                                  @JsonProperty("notaryFee") Long notaryFee,
                                  @JsonProperty("remunerationCost") Long remunerationCost,
                                  @JsonProperty("notaryCostTotal") Long notaryCostTotal,
                                  @JsonProperty("relationObjects") String relationObjects,
                                  @JsonProperty("contractPeriod") String contractPeriod,
                                  @JsonProperty("mortageCancelFlag") Long mortageCancelFlag,
                                  @JsonProperty("mortageCancelDate") String mortageCancelDate,
                                  @JsonProperty("mortageCancelNote") String mortageCancelNote,
                                  @JsonProperty("cancelStatus") Long cancelStatus,
                                  @JsonProperty("cancelDescription") String cancelDescription,
                                  @JsonProperty("entryUserName") String entryUserName,
                                  @JsonProperty("entryDateTime") String entryDateTime,
                                  @JsonProperty("updateUserName") String updateUserName,
                                  @JsonProperty("updateDateTime") String updateDateTime,
                                  @JsonProperty("bankCode") String bankCode,
                                  @JsonProperty("contractNote") String contractNote,
                                  @JsonProperty("propertyInfo") String propertyInfo,
                                  @JsonProperty("json_property") String json_property,
                                  @JsonProperty("json_person") String json_person) {

        this.notaryOfficeCode = notaryOfficeCode;
        this.contractKindCode = contractKindCode;
        this.code_template=code_template;
        this.contractNumber = contractNumber;
        this.typeSynchronize = typeSynchronize;
        this.contractName = contractName;
        this.transactionContent = transactionContent;
        this.notaryDate = notaryDate;
        this.notaryOfficeName = notaryOfficeName;
        this.notaryPerson = notaryPerson;
        this.notaryPlace = notaryPlace;
        this.notaryFee=notaryFee;
        this.remunerationCost=remunerationCost;
        this.notaryCostTotal=notaryCostTotal;
        this.relationObjects = relationObjects;
        this.contractPeriod = contractPeriod;
        this.mortageCancelFlag = mortageCancelFlag;
        this.mortageCancelDate = mortageCancelDate;
        this.mortageCancelNote = mortageCancelNote;
        this.cancelStatus = cancelStatus;
        this.cancelDescription = cancelDescription;
        this.entryUserName = entryUserName;
        this.entryDateTime = entryDateTime;
        this.updateUserName = updateUserName;
        this.updateDateTime = updateDateTime;
        this.bankCode = bankCode;
        this.contractNote = contractNote;
        this.propertyInfo = propertyInfo;
        this.json_property = json_property;
        this.json_person = json_person;
    }

    public SynchronizeContractTag() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"notaryOfficeCode\":\"").append(notaryOfficeCode).append("\",");
        sb.append("\"contractKindCode\":\"").append(contractKindCode).append("\",");
        sb.append("\"code_template\":\"").append(code_template).append("\",");
        sb.append("\"contractNumber\":\"").append(contractNumber).append("\",");
        sb.append("\"typeSynchronize\":\"").append(typeSynchronize).append("\",");
        sb.append("\"contractName\":\"").append(contractName).append("\",");
        sb.append("\"transactionContent\":\"").append(transactionContent).append("\",");
        sb.append("\"notaryDate\":\"").append(notaryDate).append("\",");
        sb.append("\"notaryOfficeName\":\"").append(notaryOfficeName).append("\",");
        sb.append("\"notaryPerson\":\"").append(notaryPerson).append("\",");
        sb.append("\"notaryPlace\":\"").append(notaryPlace).append("\",");
        sb.append("\"notaryFee\":\"").append(notaryFee).append("\",");
        sb.append("\"remunerationCost\":\"").append(remunerationCost).append("\",");
        sb.append("\"notaryCostTotal\":\"").append(notaryCostTotal).append("\",");
        sb.append("\"relationObjects\":\"").append(relationObjects).append("\",");
        sb.append("\"contractPeriod\":\"").append(contractPeriod).append("\",");
        sb.append("\"mortageCancelFlag\":\"").append(mortageCancelFlag).append("\",");
        sb.append("\"mortageCancelDate\":\"").append(mortageCancelDate).append("\",");
        sb.append("\"mortageCancelNote\":\"").append(mortageCancelNote).append("\",");
        sb.append("\"cancelStatus\":\"").append(cancelStatus).append("\",");
        sb.append("\"cancelDescription\":\"").append(cancelDescription).append("\",");
        sb.append("\"entryUserName\":\"").append(entryUserName).append("\",");
        sb.append("\"entryDateTime\":\"").append(entryDateTime).append("\",");
        sb.append("\"updateUserName\":\"").append(updateUserName).append("\",");
        sb.append("\"updateDateTime\":\"").append(updateDateTime).append("\",");
        sb.append("\"bankCode\":\"").append(bankCode).append("\",");
        sb.append("\"contractNote\":\"").append(contractNote).append("\",");
        sb.append("\"propertyInfo\":\"").append(propertyInfo).append("\",");
        sb.append("\"json_property\":\"").append(json_property).append("\",");
        sb.append("\"json_person\":\"").append(json_person).append("\"");

        sb.append('}');
        return sb.toString();
    }


    public String getNotaryOfficeCode() {
        return notaryOfficeCode;
    }

    public void setNotaryOfficeCode(String notaryOfficeCode) {
        this.notaryOfficeCode = notaryOfficeCode;
    }

    public String getContractKindCode() {
        return contractKindCode;
    }

    public void setContractKindCode(String contractKindCode) {
        this.contractKindCode = contractKindCode;
    }

    public Long getCode_template() {
        return code_template;
    }

    public void setCode_template(Long code_template) {
        this.code_template = code_template;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public int getTypeSynchronize() {
        return typeSynchronize;
    }

    public void setTypeSynchronize(int typeSynchronize) {
        this.typeSynchronize = typeSynchronize;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getTransactionContent() {
        return transactionContent;
    }

    public void setTransactionContent(String transactionContent) {
        this.transactionContent = transactionContent;
    }

    public String getNotaryDate() {
        return notaryDate;
    }

    public void setNotaryDate(String notaryDate) {
        this.notaryDate = notaryDate;
    }

    public String getNotaryOfficeName() {
        return notaryOfficeName;
    }

    public void setNotaryOfficeName(String notaryOfficeName) {
        this.notaryOfficeName = notaryOfficeName;
    }

    public String getNotaryPerson() {
        return notaryPerson;
    }

    public void setNotaryPerson(String notaryPerson) {
        this.notaryPerson = notaryPerson;
    }

    public String getNotaryPlace() {
        return notaryPlace;
    }

    public void setNotaryPlace(String notaryPlace) {
        this.notaryPlace = notaryPlace;
    }

    public String getRelationObjects() {
        return relationObjects;
    }

    public void setRelationObjects(String relationObjects) {
        this.relationObjects = relationObjects;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public Long getMortageCancelFlag() {
        return mortageCancelFlag;
    }

    public void setMortageCancelFlag(Long mortageCancelFlag) {
        this.mortageCancelFlag = mortageCancelFlag;
    }

    public String getMortageCancelDate() {
        return mortageCancelDate;
    }

    public void setMortageCancelDate(String mortageCancelDate) {
        this.mortageCancelDate = mortageCancelDate;
    }

    public String getMortageCancelNote() {
        return mortageCancelNote;
    }

    public void setMortageCancelNote(String mortageCancelNote) {
        this.mortageCancelNote = mortageCancelNote;
    }

    public Long getCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(Long cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public String getCancelDescription() {
        return cancelDescription;
    }

    public void setCancelDescription(String cancelDescription) {
        this.cancelDescription = cancelDescription;
    }

    public String getEntryUserName() {
        return entryUserName;
    }

    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    public String getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(String entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getContractNote() {
        return contractNote;
    }

    public void setContractNote(String contractNote) {
        this.contractNote = contractNote;
    }

    public String getPropertyInfo() {
        return propertyInfo;
    }

    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    public String getJson_property() {
        return json_property;
    }

    public void setJson_property(String json_property) {
        this.json_property = json_property;
    }

    public String getJson_person() {
        return json_person;
    }

    public void setJson_person(String json_person) {
        this.json_person = json_person;
    }

    public Long getNotaryFee() {
        return notaryFee;
    }

    public void setNotaryFee(Long notaryFee) {
        this.notaryFee = notaryFee;
    }

    public Long getRemunerationCost() {
        return remunerationCost;
    }

    public void setRemunerationCost(Long remunerationCost) {
        this.remunerationCost = remunerationCost;
    }

    public Long getNotaryCostTotal() {
        return notaryCostTotal;
    }

    public void setNotaryCostTotal(Long notaryCostTotal) {
        this.notaryCostTotal = notaryCostTotal;
    }
}
