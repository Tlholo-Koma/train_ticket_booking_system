package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Admin
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")


public class Admin   {
  @JsonProperty("admin_id")
  private Integer adminId = null;

  @JsonProperty("admin_email")
  private String adminEmail = null;

  public Admin adminId(Integer adminId) {
    this.adminId = adminId;
    return this;
  }

  /**
   * Get adminId
   * @return adminId
  **/
  @ApiModelProperty(value = "")


  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public Admin adminEmail(String adminEmail) {
    this.adminEmail = adminEmail;
    return this;
  }

  /**
   * Get adminEmail
   * @return adminEmail
  **/
  @ApiModelProperty(value = "")


  public String getAdminEmail() {
    return adminEmail;
  }

  public void setAdminEmail(String adminEmail) {
    this.adminEmail = adminEmail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Admin admin = (Admin) o;
    return Objects.equals(this.adminId, admin.adminId) &&
        Objects.equals(this.adminEmail, admin.adminEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adminId, adminEmail);
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

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

