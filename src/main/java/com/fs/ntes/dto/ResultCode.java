package com.fs.ntes.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "code", locations = "classpath:result_code.yml")
public class ResultCode {

    private Common common;

    public Common getCommon() {
        return common;
    }

    public void setCommon(Common common) {
        this.common = common;
    }

    public static class Common {
        private String success;
        private String paramNone;
        private String paramIllgal;
        private String addFailed;
        private String addSuccess;
        private String updateFailed;
        private String updateSuccess;
        private String saveFailed;
        private String saveSuccess;
        private String delFailed;
        private String delSuccess;

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public String getParamNone() {
            return paramNone;
        }

        public void setParamNone(String paramNone) {
            this.paramNone = paramNone;
        }

        public String getParamIllgal() {
            return paramIllgal;
        }

        public void setParamIllgal(String paramIllgal) {
            this.paramIllgal = paramIllgal;
        }

        public String getAddFailed() {
            return addFailed;
        }

        public void setAddFailed(String addFailed) {
            this.addFailed = addFailed;
        }

        public String getAddSuccess() {
            return addSuccess;
        }

        public void setAddSuccess(String addSuccess) {
            this.addSuccess = addSuccess;
        }

        public String getUpdateFailed() {
            return updateFailed;
        }

        public void setUpdateFailed(String updateFailed) {
            this.updateFailed = updateFailed;
        }

        public String getUpdateSuccess() {
            return updateSuccess;
        }

        public void setUpdateSuccess(String updateSuccess) {
            this.updateSuccess = updateSuccess;
        }

        public String getSaveFailed() {
            return saveFailed;
        }

        public void setSaveFailed(String saveFailed) {
            this.saveFailed = saveFailed;
        }

        public String getSaveSuccess() {
            return saveSuccess;
        }

        public void setSaveSuccess(String saveSuccess) {
            this.saveSuccess = saveSuccess;
        }

        public String getDelFailed() {
            return delFailed;
        }

        public void setDelFailed(String delFailed) {
            this.delFailed = delFailed;
        }

        public String getDelSuccess() {
            return delSuccess;
        }

        public void setDelSuccess(String delSuccess) {
            this.delSuccess = delSuccess;
        }
    }
}
