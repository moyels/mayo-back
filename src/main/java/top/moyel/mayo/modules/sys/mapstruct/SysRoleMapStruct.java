package top.moyel.mayo.modules.sys.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.moyel.mayo.modules.sys.entity.SysRole;
import top.moyel.mayo.modules.sys.vo.SysRoleSaveVO;
import top.moyel.mayo.modules.sys.vo.SysRoleUpdateVO;

/**
 * 角色的data转换
 *
 * @author moyel
 */
@Mapper
public interface SysRoleMapStruct {
    SysRoleMapStruct INSTANCE = Mappers.getMapper(SysRoleMapStruct.class);

    SysRole fromSaveVO(SysRoleSaveVO sysRoleSaveVO);

    SysRole fromUpdateVO(SysRoleUpdateVO sysRoleUpdateVO);
}
