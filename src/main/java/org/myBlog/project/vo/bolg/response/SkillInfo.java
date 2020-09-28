package org.myBlog.project.vo.bolg.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkillInfo {
    /**
     * 技术站名称
     * */
    private String skillName;
    /**
     * 技术栈熟练度
     * */
    private int skillPercentage;
}
