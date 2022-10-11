package com.example.Challenges2.model;

import java.util.Date;

public class Account {
        private long id;
        private String account_type;
        private String account_name;
        private int bal;
        private Date date;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getAccount_type() {
            return account_type;
        }

        public void setAccount_type(String account_type) {
            this.account_type = account_type;
        }

        public String getAccount_name() {
            return account_name;
        }

        public void setAccount_name(String account_name) {
            this.account_name = account_name;
        }

        public int getBal() {
            return bal;
        }

        public void setBal(int bal) {
            this.bal = bal;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

    }
}
