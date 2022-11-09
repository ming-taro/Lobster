package com.twopark1jo.lobster.department.department.member;

import com.twopark1jo.lobster.department.department.Department;
import com.twopark1jo.lobster.department.department.DepartmentRepository;
import com.twopark1jo.lobster.exception.GlobalExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentMemberController {
    private final DepartmentMemberRepository departmentMemberRepository;
    private final DepartmentRepository departmentRepository;
    @Autowired
    private GlobalExceptionHandler exceptionHandler;

    //해당 부서의 모든 멤버 목록
    @GetMapping("/members")
    public ResponseEntity<List<DepartmentMember>> getMemberByDepartment(@RequestParam String departmentId){
        boolean isDepartment = departmentRepository.existsById(departmentId);

        if(isDepartment){
            return new ResponseEntity<>(departmentMemberRepository.findAllByDepartmentId(departmentId), HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();
    }

}
