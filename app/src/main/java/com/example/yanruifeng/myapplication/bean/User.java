package com.example.yanruifeng.myapplication.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yanruifeng on 2018/4/19.
 */
@Entity
public class User {
        @Id(autoincrement = true)
        private Long id;
        private String name;
        private int age;
        private String sex;
        @Generated(hash = 689493095)
        public User(Long id, String name, int age, String sex) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        @Generated(hash = 586692638)
        public User() {
        }
        public Long getId() {
            return this.id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getName() {
            return this.name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return this.age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getSex() {
            return this.sex;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }
}
