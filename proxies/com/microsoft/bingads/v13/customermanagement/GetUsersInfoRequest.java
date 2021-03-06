
package com.microsoft.bingads.v13.customermanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="StatusFilter" type="{https://bingads.microsoft.com/Customer/v13/Entities}UserLifeCycleStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customerId",
    "statusFilter"
})
@XmlRootElement(name = "GetUsersInfoRequest")
public class GetUsersInfoRequest {

    @XmlElement(name = "CustomerId")
    protected Long customerId;
    @XmlElement(name = "StatusFilter", nillable = true)
    @XmlSchemaType(name = "string")
    protected UserLifeCycleStatus statusFilter;

    /**
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerId(Long value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the statusFilter property.
     * 
     * @return
     *     possible object is
     *     {@link UserLifeCycleStatus }
     *     
     */
    public UserLifeCycleStatus getStatusFilter() {
        return statusFilter;
    }

    /**
     * Sets the value of the statusFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserLifeCycleStatus }
     *     
     */
    public void setStatusFilter(UserLifeCycleStatus value) {
        this.statusFilter = value;
    }

}
