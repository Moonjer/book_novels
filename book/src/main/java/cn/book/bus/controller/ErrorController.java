package cn.book.bus.controller;


import cn.book.bus.domain.Chapter;
import cn.book.bus.domain.ChapterContent;
import cn.book.bus.domain.Fiction;
import cn.book.bus.service.IChapterContentService;
import cn.book.bus.service.IChapterService;
import cn.book.bus.service.IFictionService;
import cn.book.bus.vo.ChapterVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 文章章节 控制器
 */
@Controller
@RequestMapping("error")
public class ErrorController {

    //返回一本小说
    @RequestMapping("404")
    public String error() {

        return "error/404";
    }
}