/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.commonApplications.businessLogic;

import et.gov.commonApplications.entity.LookUp;
import et.gov.commonApplications.mapper.LookUpFacade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;

/**
 *
 * @author Tsehayu Tilahun
 */
@Stateless
public class LookUpBean implements LookUpBeanLocal {

    @EJB
    LookUp lookUp;

    @EJB
    LookUpFacade lookUpFacade;

    /**
     *
     * @param systemPrefix
     * @return
     */
    @Override
    public ArrayList<String> getLookUpTables(String systemPrefix) {
        return lookUpFacade.getLookUpTables(systemPrefix);
    }

    /**
     *
     * @param lookUp
     * @return
     */
    @Override
    public ArrayList<String> getColumns(LookUp lookUp) {
        return lookUpFacade.getColumns(lookUp);
    }

    /**
     *
     * @param tableInfo
     * @return
     */
    @Override
    public ArrayList<String[]> selectData(HashMap tableInfo) {
//        LookUp lookUpEntity = new LookUp();
        lookUp.setTableName(tableInfo.get("name").toString());
        lookUp.setNoColumn((Integer) tableInfo.get("noColumn"));
        return lookUpFacade.selectData(lookUp);
    }

    /**
     *
     * @param tableName
     * @return
     */
    @Override
    public ArrayList<String> checkForeignKey(String tableName) {
        return lookUpFacade.checkForeignKey(tableName);
    }

    /**
     *
     * @param tableName
     * @return
     */
    @Override
    public String checkPrimaryKey(String tableName) {
        return lookUpFacade.selectPkCol(tableName);
    }

    /**
     *
     * @param tableName
     * @param columnName
     * @return
     */
    @Override
    public String checkRequiredOrNot(String tableName, String columnName) {
        return lookUpFacade.checkRequiredOrNot(tableName, columnName);
    }

    /**
     *
     * @param tableName
     * @param columnName
     * @return
     */
    @Override
    public ArrayList<SelectItem> refTableDetail(String tableName, String columnName) {
        try {
            ArrayList<SelectItem> tableColumn = new ArrayList<SelectItem>();
            List<Object[]> result = lookUpFacade.selectAllFromRef(tableName, columnName);
            for (Object[] resultElement : result) {
                tableColumn.add(new SelectItem(resultElement[0], resultElement[1].toString()));
            }
            if (tableColumn != null) {
                return tableColumn;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param tableName
     * @param columnNames
     * @param values
     * @return
     */
    @Override
    public int saveLookUp(String tableName, String columnNames, String values) {
        int message = -1;
        try {
            LookUp lookUpEntity = new LookUp();
            lookUpEntity.setTableName(tableName);
            lookUpEntity.setColumnNames(columnNames);
            lookUpEntity.setValues(values);
            message = lookUpFacade.insert(lookUpEntity);
            return message;
        } catch (Exception ex) {
            ex.printStackTrace();
            return message;
        }
    }

    /**
     *
     * @param tableName
     * @param columnNames
     * @param values
     * @return
     */
    public int updateLookUp(String tableName, String columnNames, String values) {
        int message = -1;
        try {
            LookUp lookUpEntity = new LookUp();
            lookUpEntity.setTableName(tableName);
            lookUpEntity.setColumnNames(columnNames);
            lookUpEntity.setValues(values);
            message = lookUpFacade.update(lookUpEntity);
            return message;
        } catch (Exception ex) {
            ex.printStackTrace();
            return message;
        }
    }

    @Override
    public String getLookUpLabelName(String tableName) {
        String lableName = "";
        if (tableName.equalsIgnoreCase("HR_LU_ADRESS_TYPE")) {
            lableName = "ADRESS TYPE";
        } else if (tableName.equalsIgnoreCase("HR_LU_BANKS")) {
            lableName = "BANKS";
        } else if (tableName.equalsIgnoreCase("HR_LU_ALLOWED_LEAVE")) {
            lableName = "ALLOWED LEAVE";
        } else if (tableName.equalsIgnoreCase("HR_LU_BANK_BRANCHES")) {
            lableName = "BANK BRANCHES";
        } else if (tableName.equalsIgnoreCase("HR_LU_BENEFIT_TYPE")) {
            lableName = "BENEFIT TYPE";
        } else if (tableName.equalsIgnoreCase("HR_LU_BRANCH")) {
            lableName = "BRANCH TOWN";
        } else if (tableName.equalsIgnoreCase("HR_LU_COMMITTEE_TYPES")) {
            lableName = "COMMITTEE TYPES";
        } else if (tableName.equalsIgnoreCase("HR_LU_CRITERIA_TYPE")) {
            lableName = "CRITERIA TYPE";
        } else if (tableName.equalsIgnoreCase("HR_LU_EDUCATION_QUL")) {
            lableName = "EDUCATION LEVEL TYPE";
        } else if (tableName.equalsIgnoreCase("HR_LU_EDUC_LEVELS")) {
            lableName = "EDUCATION LEVELS";
        } else if (tableName.equalsIgnoreCase("HR_LU_EDUC_TYPES")) {
            lableName = "EDUCATION TYPES";
        } else if (tableName.equalsIgnoreCase("HR_LU_ETHINICITIES")) {
            lableName = "ETHINICITIES";
        } else if (tableName.equalsIgnoreCase("HR_LU_GRADES")) {
            lableName = "GRADES";
        } else if (tableName.equalsIgnoreCase("HR_LU_GRADE_LEVEL")) {
            lableName = "GRADE & SERVICE TYPES";
        } else if (tableName.equalsIgnoreCase("HR_LU_HEALTH_STATUS")) {
            lableName = "HEALTH STATUS";
        } else if (tableName.equalsIgnoreCase("HR_LU_HOLIDAY_NAMES")) {
            lableName = "HOLIDAY NAMES";
        } else if (tableName.equalsIgnoreCase("HR_LU_INSURANCES")) {
            lableName = "INSURANCES";
        } else if (tableName.equalsIgnoreCase("HR_LU_INSURANCE_BRANCHES")) {
            lableName = "INSURANCE BRANCHES";
        } else if (tableName.equalsIgnoreCase("HR_LU_JOB_CATEGORIES")) {
            lableName = "JOB CATEGORIES";
        } else if (tableName.equalsIgnoreCase("HR_LU_JOB_LEVELS")) {
            lableName = "SERVICE TYPES";
        } else if (tableName.equalsIgnoreCase("HR_LU_JOB_TYPES")) {
            lableName = "JOB TYPES";
        } else if (tableName.equalsIgnoreCase("HR_LU_LANGUAGES")) {
            lableName = "LANGUAGES";
        } else if (tableName.equalsIgnoreCase("HR_LU_LEAVE_TYPES")) {
            lableName = "LEAVE TYPES";
        } else if (tableName.equalsIgnoreCase("HR_LU_LEAVE_YEAR")) {
            lableName = "LEAVE YEAR";
        } else if (tableName.equalsIgnoreCase("HR_LU_MEDIA_TYPES")) {
            lableName = "MEDIA TYPES";
        } else if (tableName.equalsIgnoreCase("HR_LU_MEMBERSHIPS")) {
            lableName = "MEMBERSHIPS";
        } else if (tableName.equalsIgnoreCase("HR_LU_NATION")) {
            lableName = "NATION";
        } else if (tableName.equalsIgnoreCase("HR_LU_NATIONALITIES")) {
            lableName = "NATIONALITIES";
        } else if (tableName.equalsIgnoreCase("HR_LU_PHYSICAL_STATUS")) {
            lableName = "PHYSICAL STATUS";
        } else if (tableName.equalsIgnoreCase("HR_LU_PROM_EXP_RELATION")) {
            lableName = "PROMOTION EXPERIANCE RELATION";
        } else if (tableName.equalsIgnoreCase("HR_LU_PROMO_CRITERIA_NAME")) {
            lableName = "PROMOTION CRITERIA NAME";
        } else if (tableName.equalsIgnoreCase("HR_LU_REGIONS")) {
            lableName = "REGIONS";
        } else if (tableName.equalsIgnoreCase("HR_LU_RELIGIONS")) {
            lableName = "RELIGIONS";
        } else if (tableName.equalsIgnoreCase("HR_LU_RETIRMENTREASON")) {
            lableName = "RETIRMENT REASON";
        } else if (tableName.equalsIgnoreCase("HR_LU_SALARY_STEPS")) {
            lableName = "SALARY STEPS";
        } else if (tableName.equalsIgnoreCase("HR_LU_TERMINATIONREASON")) {
            lableName = "TERMINATION REASON";
        } else if (tableName.equalsIgnoreCase("HR_LU_TITLES")) {
            lableName = "TITLES";
        } else if (tableName.equalsIgnoreCase("HR_LU_TRANSFER_TYPES")) {
            lableName = "TRANSFER TYPES";
        }
        return lableName;
    }
}
