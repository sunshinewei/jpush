package com.example.myapplication.bean;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by mm on 2018/10/15.
 */

public class HomeBean implements Serializable{

    private String barCode;
    private int categoryId;
    private String characteristic;
    private int commission;
    private int commissionType;
    private String dateAdd;
    private String dateStart;
    private String dateUpdate;
    private int gotScore;
    private int gotScoreType;
    private int id;
    private boolean kanjia;
    private int kanjiaPrice;
    private int logisticsId;
    private int originalPrice;
    private int minScore;
    private String name;
    private int numberFav;
    private int numberGoodReputation;
    private int numberOrders;
    private int numberSells;
    private int minPrice;
    private int paixu;
    private String pic;
    private boolean pingtuan;
    private int pingtuanPrice;
    private String propertyIds;
    private int recommendStatus;
    private String recommendStatusStr;
    private int shopId;
    private int status;
    private String statusStr;
    private int stores;
    private int userId;
    private int views;
    private int weight;
    private boolean scanShow;
    private int scanPrice;
    private Drawable drawablePic;

    public void setDrawablePic(Drawable drawablePic) {
        this.drawablePic = drawablePic;
    }

    public Drawable getDrawablePic() {
        return drawablePic;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(int commissionType) {
        this.commissionType = commissionType;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getGotScore() {
        return gotScore;
    }

    public void setGotScore(int gotScore) {
        this.gotScore = gotScore;
    }

    public int getGotScoreType() {
        return gotScoreType;
    }

    public void setGotScoreType(int gotScoreType) {
        this.gotScoreType = gotScoreType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isKanjia() {
        return kanjia;
    }

    public void setKanjia(boolean kanjia) {
        this.kanjia = kanjia;
    }

    public int getKanjiaPrice() {
        return kanjiaPrice;
    }

    public void setKanjiaPrice(int kanjiaPrice) {
        this.kanjiaPrice = kanjiaPrice;
    }

    public int getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(int logisticsId) {
        this.logisticsId = logisticsId;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberFav() {
        return numberFav;
    }

    public void setNumberFav(int numberFav) {
        this.numberFav = numberFav;
    }

    public int getNumberGoodReputation() {
        return numberGoodReputation;
    }

    public void setNumberGoodReputation(int numberGoodReputation) {
        this.numberGoodReputation = numberGoodReputation;
    }

    public int getNumberOrders() {
        return numberOrders;
    }

    public void setNumberOrders(int numberOrders) {
        this.numberOrders = numberOrders;
    }

    public int getNumberSells() {
        return numberSells;
    }

    public void setNumberSells(int numberSells) {
        this.numberSells = numberSells;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getPaixu() {
        return paixu;
    }

    public void setPaixu(int paixu) {
        this.paixu = paixu;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public boolean isPingtuan() {
        return pingtuan;
    }

    public void setPingtuan(boolean pingtuan) {
        this.pingtuan = pingtuan;
    }

    public int getPingtuanPrice() {
        return pingtuanPrice;
    }

    public void setPingtuanPrice(int pingtuanPrice) {
        this.pingtuanPrice = pingtuanPrice;
    }

    public String getPropertyIds() {
        return propertyIds;
    }

    public void setPropertyIds(String propertyIds) {
        this.propertyIds = propertyIds;
    }

    public int getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(int recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public String getRecommendStatusStr() {
        return recommendStatusStr;
    }

    public void setRecommendStatusStr(String recommendStatusStr) {
        this.recommendStatusStr = recommendStatusStr;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public int getStores() {
        return stores;
    }

    public void setStores(int stores) {
        this.stores = stores;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isScanShow() {
        return scanShow;
    }

    public void setScanShow(boolean scanShow) {
        this.scanShow = scanShow;
    }

    public int getScanPrice() {
        return scanPrice;
    }

    public void setScanPrice(int scanPrice) {
        this.scanPrice = scanPrice;
    }

}
