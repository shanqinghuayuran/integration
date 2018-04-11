package com.example.yanruifeng.myapplication.bean;

/**
 * Created by yanruifeng on 2018/4/11.
 */

    public class MessageEvent{
        private String message;
        public  MessageEvent(String message){
            this.message=message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
