package cn.book.bus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 用于接收前端请求参数
 * @author coffee
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FictionVo {
    /**
     *页数
     */
    private Integer curr;
    /**
     *每页数
     */
    private Integer limit;
    /**
     *总数
     */
    private Integer count;
    /**
     *小说类型
     */
    private Integer type;

    /**
     *小说名称
     */
    private String fictionName;

    /**
     * 首页展示列表模式
     */
    private Integer viewType;
    /**
     *小说id
     */
    private String fictionId;

}
