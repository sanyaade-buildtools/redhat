package com.codenvy.redhat.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Alexander Andrienko
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Command {
    @XmlAttribute
    private boolean required;
    @XmlAttribute
    private String returns;
    @XmlAttribute
    private String serialization;

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getReturns() {
        return returns;
    }

    public void setReturns(String returns) {
        this.returns = returns;
    }

    public String getSerialization() {
        return serialization;
    }

    public void setSerialization(String serialization) {
        this.serialization = serialization;
    }
}
