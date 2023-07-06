package top.moyel.mayo.modules.sys.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.moyel.mayo.modules.sys.entity.SysUser;
import top.moyel.mayo.modules.sys.vo.SysUserVO;

/**
 * @author moyel
 */
@Mapper
public interface SysUserMapStruct {
    SysUserMapStruct INSTANCE = Mappers.getMapper(SysUserMapStruct.class);

    SysUserVO toVO(SysUser sysUser);
}
