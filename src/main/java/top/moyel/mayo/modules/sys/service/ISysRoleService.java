package top.moyel.mayo.modules.sys.service;

import com.github.yulichang.base.MPJBaseService;
import top.moyel.mayo.modules.sys.dto.SysRoleDTO;
import top.moyel.mayo.modules.sys.entity.SysRole;

import java.util.List;

/**
 * @author moyel
 */
public interface ISysRoleService extends MPJBaseService<SysRole> {
    /**
     * 列出role dto
     *
     * @return role dto列表
     */
    List<SysRoleDTO> listRoles();
}
