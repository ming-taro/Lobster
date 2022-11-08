package com.twopark1jo.lobster.department.department.member;

import com.twopark1jo.lobster.workspace.WorkspaceMemberPK;
import lombok.*;

import javax.persistence.*;

@Entity(name = "department_member")
@Table(name = "department_member")
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
@IdClass(MemberPK.class)
public class Member {
    @Id
    @Column(name = "department_id")
    private String departmentId;

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "department_role")
    private String departmentRole;

    @Column(name = "department_grade")
    private String departmentGrade;
}
