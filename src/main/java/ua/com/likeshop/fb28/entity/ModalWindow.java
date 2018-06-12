package ua.com.likeshop.fb28.entity;


import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
public class ModalWindow  extends AbstractPersistable<Long> {


    String fullName;
    String Number;

    public ModalWindow() {
    }

    public ModalWindow(String fullName, String number) {
        this.fullName = fullName;
        Number = number;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
