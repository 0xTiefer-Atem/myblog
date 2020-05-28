package org.myBlog.project.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillInfo {
    private String skillName;
    private int skillPercentage;
}
