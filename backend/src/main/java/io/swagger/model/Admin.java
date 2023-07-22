package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @JsonProperty("admin_id")
    @ApiModelProperty(value = "")
    private Integer adminId;

    @Column(name = "email", nullable = false)
    @JsonProperty("admin_email")
    @ApiModelProperty(value = "")
    private String adminEmail;

    @Column(name = "created_by", nullable = false)
    private final String createdBy = "SYSTEM";

    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    @Column(name = "date_updated", nullable = false)
    private Date dateUpdated;
    
    @PrePersist
    protected void onCreate() {
      dateCreated = new Date();
      dateUpdated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
      dateUpdated = new Date();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Admin {\n");

        sb.append("    adminId: ").append(toIndentedString(adminId)).append("\n");
        sb.append("    adminEmail: ").append(toIndentedString(adminEmail)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
