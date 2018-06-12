package ua.com.likeshop.fb28.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity

public class Image extends AbstractPersistable<Long>{
    @Lob
    @Column(length=100000)
    private byte[] data;


    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
