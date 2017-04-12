package com.my.bean;

import annotation.Member;
import annotation.Table;

/**
 * Created by mengyan on 2017/4/12.
 */

@Table(tableName = "t_logistics")
public class Logistics {
    @Member(type = "int(1)",field = "map_id",primaryKey = true,defaultNull = false)
    private Integer mapId;

    @Member(type = "int(1)",field = "logistics_id",primaryKey = true,defaultNull = false)
    private Integer logisticsId;

    @Member(type = "VARCHAR(20)",field = "logistics_name",defaultNull = false)
    private String logisticsName;

    @Member(type = "VARCHAR(20)",field ="logistics_time",defaultNull = false)
    private String logisticsTime;

    @Member(type = "int(1)",field = "captainlevel",defaultNull = false)
    private Integer captainlevel;

    @Member(type = "int(1)",field = "teamsnumber",defaultNull = false)
    private Integer teamsnumber;

    @Member(type = "int(1)",field = "manpower",defaultNull = false)
    private Integer manpower;

    @Member(type = "int(1)",field = "ammunition",defaultNull = false)
    private Integer ammunition;

    @Member(type = "int(1)",field = "pations",defaultNull = false)
    private Integer pations;

    @Member(type = "int(1)",field = "components",defaultNull = false)
    private Integer components;

    @Member(type = "VARCHAR(20)",field = "props")
    private String props;

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getLogisticsTime() {
        return logisticsTime;
    }

    public void setLogisticsTime(String logisticsTime) {
        this.logisticsTime = logisticsTime;
    }

    public Integer getCaptainlevel() {
        return captainlevel;
    }

    public void setCaptainlevel(Integer captainlevel) {
        this.captainlevel = captainlevel;
    }

    public Integer getTeamsnumber() {
        return teamsnumber;
    }

    public void setTeamsnumber(Integer teamsnumber) {
        this.teamsnumber = teamsnumber;
    }

    public Integer getManpower() {
        return manpower;
    }

    public void setManpower(Integer manpower) {
        this.manpower = manpower;
    }

    public Integer getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(Integer ammunition) {
        this.ammunition = ammunition;
    }

    public Integer getPations() {
        return pations;
    }

    public void setPations(Integer pations) {
        this.pations = pations;
    }

    public Integer getComponents() {
        return components;
    }

    public void setComponents(Integer components) {
        this.components = components;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "mapId=" + mapId +
                ", logisticsId=" + logisticsId +
                ", logisticsName='" + logisticsName + '\'' +
                ", logisticsTime='" + logisticsTime + '\'' +
                ", captainlevel=" + captainlevel +
                ", teamsnumber=" + teamsnumber +
                ", manpower=" + manpower +
                ", ammunition=" + ammunition +
                ", pations=" + pations +
                ", components=" + components +
                ", props='" + props + '\'' +
                '}';
    }
}
