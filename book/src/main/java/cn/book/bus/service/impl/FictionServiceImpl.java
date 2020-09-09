package cn.book.bus.service.impl;

import cn.book.bus.aop.HttpAspect;
import cn.book.bus.domain.Fiction;
import cn.book.bus.mapper.FictionMapper;
import cn.book.bus.service.IFictionService;
import cn.book.bus.vo.FictionVo;
import cn.book.bus.common.DataGridView;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 追风
 * @since 2019-12-16
 */
@Service
public class FictionServiceImpl extends ServiceImpl<FictionMapper, Fiction> implements IFictionService {

    /**
     * 默认参数
     */
    private final  static Integer  CURR=1;
    private final  static Integer  LIMIT=20;
    private final  static Integer  VIEW_TYPE=2;
    private final  static Integer  TYPE=0;


    @Resource
    private IFictionService iFictionService;

    @Autowired
    private FictionMapper fictionMapper;

    private static final Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @Override
    public List<Fiction> queryLike(String v) {
        QueryWrapper<Fiction> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("fiction_name", v);
        return list(queryWrapper);
    }


    @Override
    public DataGridView queryAllFiction(FictionVo fictionVo) {

        //当前页和页数
        if (null==fictionVo.getCurr()) {
            fictionVo.setCurr(CURR);
            fictionVo.setLimit(LIMIT);
        }
        //图片模式或者列表模式
        Integer viewType =null;
        if (null==fictionVo.getViewType()) {
            viewType = VIEW_TYPE;
        }else {
            viewType=fictionVo.getViewType();
        }
        if (null==fictionVo.getType()){
            fictionVo.setType(TYPE);
        }
        //构建分页
        Page<Fiction> page = new Page<>(fictionVo.getCurr(), fictionVo.getLimit());
        QueryWrapper<Fiction> qw = new QueryWrapper<>();
        //0代表所有分类
        if (null!=fictionVo.getType()&&fictionVo.getType().equals(TYPE)) {
            qw.eq(StringUtils.isNoneBlank(getFictionName(fictionVo.getType())), "type", getFictionName(fictionVo.getType()));
        }
        qw.orderByDesc("create_date");
        this.fictionMapper.selectPage(page, qw);
        //获取分页后查询出的记录
        List<Fiction> records = page.getRecords();
        return new DataGridView(page.getCurrent(), page.getSize(), page.getTotal(), records, viewType, fictionVo.getType());
    }

    @Override
    public void addView(Fiction fiction) {
        int i = fiction.getViews();
        int v = i + 1;
        fiction.setViews(v);
        iFictionService.updateById(fiction);
    }
    //获取小说分类
    private String getFictionName(Integer index) {
        String name = "";

        switch (index) {
            case 1:
                name = "玄幻魔法";
                break;
            case 2:
                name = "武侠修真";
                break;
            case 3:
                name = "都市言情";
                break;
            case 4:
                name = "历史军事";
                break;
            case 5:
                name = "侦探推理";
                break;
            case 6:
                name = "网游动漫";
                break;
            case 7:
                name = "科幻灵异";
                break;
            case 8:
                name = "连载中";
                break;
            case 9:
                name = "完本";
                break;
            default:
                name = null;
                break;
        }
        return  name;
    }
}
