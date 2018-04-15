package com.boot.study.endpoint;

import java.util.Date;
import java.util.Map;

public class MemStatus {
        public MemStatus(Date date, Map<String, Object> status) {
            this.date = date;
            this.status = status;
        }
        private Date date;
        private Map<String, Object> status;
        public Date getDate() {
            return date;
        }
        public Map<String, Object> getStatus() {
            return status;
        }
    }

