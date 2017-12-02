package com.e_wallet.entity.user;

import com.e_wallet.entity.group.Group;
import com.e_wallet.entity.role.Role;
import com.e_wallet.util.DbObjectNameUtil;
import com.e_wallet.util.enums.yes_no.YesNoEnum;
import com.e_wallet.util.enums.yes_no.YesNoEnumConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Redpike
 */
@Entity
@Table(name = DbObjectNameUtil.USERS_TABLE, schema = DbObjectNameUtil.SCHEMA)
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 3, nullable = false, unique = true)
    private Integer id;

    @NotNull
    @Column(name = "username", length = 20, nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "passwd", nullable = false)
    private String password;

    @NotNull
    @Column(name = "passwd2", nullable = false)
    private String secondPassword;

    @Column(name = "first_name", length = 80)
    private String firstName;

    @Column(name = "last_name", length = 80)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "app_role_id")
    private Role role;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "avatar")
    private byte[] avatar;

    @Convert(converter = YesNoEnumConverter.class)
    @Column(name = "blocked")
    private YesNoEnum blocked;

    @Convert(converter = YesNoEnumConverter.class)
    @Column(name = "deleted")
    private YesNoEnum deleted;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = DbObjectNameUtil.GROUPS_TABLE,
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private Set<Group> groupSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public YesNoEnum getBlocked() {
        return blocked;
    }

    public void setBlocked(YesNoEnum blocked) {
        this.blocked = blocked;
    }

    public YesNoEnum getDeleted() {
        return deleted;
    }

    public void setDeleted(YesNoEnum deleted) {
        this.deleted = deleted;
    }

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (secondPassword != null ? !secondPassword.equals(user.secondPassword) : user.secondPassword != null)
            return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (!Arrays.equals(avatar, user.avatar)) return false;
        if (blocked != user.blocked) return false;
        if (deleted != user.deleted) return false;
        return groupSet != null ? groupSet.equals(user.groupSet) : user.groupSet == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (secondPassword != null ? secondPassword.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(avatar);
        result = 31 * result + (blocked != null ? blocked.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (groupSet != null ? groupSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", secondPassword='" + secondPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", avatar=" + Arrays.toString(avatar) +
                ", blocked=" + blocked +
                ", deleted=" + deleted +
                ", groupSet=" + groupSet +
                '}';
    }
}
