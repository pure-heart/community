package com.jhly.community.dto;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/19
 * @Description:com.jhly.community.dto
 * @Version:1.0
 */
@Data
@Repository
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevious;
    private Boolean showFirstPage;
    private Boolean showNext;
    private Boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();//当前展示的页数项
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        //计算总页数
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        this.page = page;

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                /**
                 * 在此列表中的指定位置插入指定的元素。 将当前位于该位置的元素（如果有）和任何后续元素（向其索引添加一个）移动。
                 *  index - 要插入指定元素的索引
                 *  element - 要插入的元素
                 */
                pages.add(0,page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        //是否展示第一页
        if (pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }
        //是否展示最后一页
        if (pages.contains(totalPage)){
            showEndPage = false;
        }else {
            showEndPage = true;
        }
    }
}
