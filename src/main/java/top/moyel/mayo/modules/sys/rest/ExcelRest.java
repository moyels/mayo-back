package top.moyel.mayo.modules.sys.rest;

import com.pig4cloud.plugin.excel.annotation.RequestExcel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.moyel.mayo.modules.sys.vo.ExcelTestVO;

import java.util.List;

/**
 * Excel测试
 *
 * @author moyel
 */
@RestController
@RequestMapping("/excel")
public class ExcelRest {
    /**
     * 测试
     *
     * @param excel excel文件解析结果
     */
    @PostMapping("/test")
    public void test(@RequestExcel List<ExcelTestVO> excel) {
        System.out.println(excel);
    }
}
