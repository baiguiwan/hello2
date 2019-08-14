package com.example.demo2.dto;


import lombok.Data;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Data
public class PageDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages= new ArrayList<>();
    private Integer totalpage;

    public void setPagination(Integer total, Integer page, Integer size) {
        if(total % size==0){
            totalpage=total/size;
        }else{
            totalpage=total/size+1;
        }
        page=page<1?1:page;
        page=page>totalpage?totalpage:page;
        this.page=page;
        pages.add(page);
        for (int i = 1; i <=3; i++) {
            if(page-i>0){
                pages.add(page-i);
            }
            if(page+i<=totalpage){
                pages.add(page+i);
            }
        }
        pages.sort(Comparator.comparing(Integer::intValue));
        showPrevious=page!=1;//是否展示上一页
        showNext=page!=totalpage;//是否展示下一页
        //判断是否展示第一页 （pages contains (1)）
        showFirstPage=!pages.contains(1);
        //判断是否展示最后一夜 （pages contains (totalpage)）
        showEndPage=!pages.contains(totalpage);
    }
}

