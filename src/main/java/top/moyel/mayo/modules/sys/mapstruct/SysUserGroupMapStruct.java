package top.moyel.mayo.modules.sys.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.moyel.mayo.modules.sys.entity.SysUserGroup;
import top.moyel.mayo.modules.sys.vo.SysUserGroupUpdateVO;
import top.moyel.mayo.modules.sys.vo.SysUserGroupVO;

/**
 * @author moyel
 */
@Mapper
public interface SysUserGroupMapStruct {
    SysUserGroupMapStruct INSTANCE = Mappers.getMapper(SysUserGroupMapStruct.class);

    SysUserGroup fromVO(SysUserGroupVO sysUserGroupVO);

    SysUserGroup fromUpdateVO(SysUserGroupUpdateVO sysUserGroupUpdateVO);
}
