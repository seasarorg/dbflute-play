/*
 * Copyright 2004-2013 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.dbflute.sastruts.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import com.example.dbflute.sastruts.dbflute.allcommon.*;
import com.example.dbflute.sastruts.dbflute.exentity.*;

/**
 * The DB meta of REGION. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class RegionDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final RegionDbm _instance = new RegionDbm();
    private RegionDbm() {}
    public static RegionDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgRegionId(), "regionId");
        setupEpg(_epgMap, new EpgRegionName(), "regionName");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public class EpgRegionId implements PropertyGateway {
        public Object read(Entity et) { return ((Region)et).getRegionId(); }
        public void write(Entity et, Object vl) {
            ColumnInfo col = columnRegionId();
            ccls(col, vl);
            ((Region)et).setRegionIdAsRegion((CDef.Region)gcls(col, vl));
        }
    }
    public static class EpgRegionName implements PropertyGateway {
        public Object read(Entity et) { return ((Region)et).getRegionName(); }
        public void write(Entity et, Object vl) { ((Region)et).setRegionName((String)vl); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "REGION";
    protected final String _tablePropertyName = "region";
    protected final TableSqlName _tableSqlName = new TableSqlName("REGION", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }
    protected final String _tableAlias = "地域";
    public String getTableAlias() { return _tableAlias; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnRegionId = cci("REGION_ID", "REGION_ID", null, "地域ID", true, "regionId", Integer.class, true, false, "INTEGER", 10, 0, null, false, null, null, null, "memberAddressList", CDef.DefMeta.Region);
    protected final ColumnInfo _columnRegionName = cci("REGION_NAME", "REGION_NAME", null, "地域名称", true, "regionName", String.class, false, false, "VARCHAR", 50, 0, null, false, null, null, null, null, null);

    public ColumnInfo columnRegionId() { return _columnRegionId; }
    public ColumnInfo columnRegionName() { return _columnRegionName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnRegionId());
        ls.add(columnRegionName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnRegionId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    public ReferrerInfo referrerMemberAddressList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnRegionId(), MemberAddressDbm.getInstance().columnRegionId());
        return cri("FK_MEMBER_ADDRESS_REGION", "memberAddressList", this, MemberAddressDbm.getInstance(), mp, false, "region");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.sastruts.dbflute.exentity.Region"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.sastruts.dbflute.cbean.RegionCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.sastruts.dbflute.exbhv.RegionBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Region> getEntityType() { return Region.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public Region newMyEntity() { return new Region(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Region)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Region)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
