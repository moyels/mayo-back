package top.moyel.mayo.modules.sys.service;

import com.mybatisflex.core.service.IService;
import top.moyel.mayo.modules.sys.dto.SysRoleDTO;
import top.moyel.mayo.modules.sys.entity.SysRole;

import java.util.List;

/**
 * @author moyel
 */
public interface ISysRoleService extends IService<SysRole> {
    /**
     * 列出role dto
     *
     * @return role dto列表
     */
    List<SysRoleDTO> listRoles();
}
