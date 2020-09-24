package br.com.erudio.data.vo;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

import org.springframework.hateoas.ResourceSupport;

public class PersonVO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String firstName;

    private String lastName;

    private String gender;

    private String address;

    public Long getKey() {
        return this.key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonVO)) {
            return false;
        }
        PersonVO personVO = (PersonVO) o;
        return Objects.equals(key, personVO.key) && Objects.equals(firstName, personVO.firstName)
                && Objects.equals(lastName, personVO.lastName) && Objects.equals(gender, personVO.gender)
                && Objects.equals(address, personVO.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, firstName, lastName, gender, address);
    }

}
