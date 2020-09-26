package org.myblog.project.vo.bolg.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkillInfo {
    private String skillName;
    private int skillPercentage;
}
