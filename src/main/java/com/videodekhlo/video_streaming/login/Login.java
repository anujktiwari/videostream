package com.videodekhlo.video_streaming.login;

import jakarta.persistence.*;

@Entity
@Table(name ="User")
public class Login {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long ID;
        private String LOGINID;
        private String PASSWORD;

        public Login(){
        };

        public Login(Long ID, String LOGINID, String PASSWORD) {
                this.ID = ID;
                this.LOGINID = LOGINID;
                this.PASSWORD = PASSWORD;
        }

        public Long getID() {
                return ID;
        }

        public void setID(Long ID) {
                this.ID = ID;
        }

        public String getLOGINID() {
                return LOGINID;
        }

        public void setLOGINID(String LOGINID) {
                this.LOGINID = LOGINID;
        }

        public String getPASSWORD() {
                return PASSWORD;
        }

        public void setPASSWORD(String PASSWORD) {
                this.PASSWORD = PASSWORD;
        }
}
