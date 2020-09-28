package org.myBlog.project.vo.bolg.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogTag {
    /**
    * 名字
    * */
    private String name;
}
