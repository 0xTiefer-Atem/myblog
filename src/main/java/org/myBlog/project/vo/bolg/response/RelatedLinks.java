package org.myblog.project.vo.bolg.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelatedLinks {
    /**
     * 网站链接
     * */
    private String webLink;
    /**
     * 网站图片
     * */
    private String webIcon;
}
