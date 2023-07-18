package top.moyel.mayo.modules.sys.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author moyel
 */
@Data
public class ExcelTestVO {
    @ExcelProperty("信号配置支持1个字节与2个字节两种模板")
    private Integer index;
    @ExcelProperty("Bit7")
    private String bit7;
    @ExcelProperty("Bit6")
    private String bit6;
    @ExcelProperty("Bit5")
    private String bit5;
    @ExcelProperty("Bit4")
    private String bit4;
    @ExcelProperty("Bit3")
    private String bit3;
    @ExcelProperty("Bit2")
    private String bit2;
    @ExcelProperty("Bit1")
    private String bit1;
    @ExcelProperty("Bit0")
    private String bit0;
    @ExcelProperty("车载协议位置")
    private String trainProtocolPosition;
    @ExcelProperty("系统（整车为空，其他必填）")
    private String system;
}
