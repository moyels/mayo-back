package top.moyel.mayo.modules.sys.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.moyel.mayo.modules.sys.dto.SysRoleDTO;
import top.moyel.mayo.modules.sys.entity.SysRole;
import top.moyel.mayo.modules.sys.mapper.SysRoleMapper;
import top.moyel.mayo.modules.sys.service.ISysRoleService;

import java.util.List;

import static top.moyel.mayo.modules.sys.entity.table.SysRoleTableDef.SYS_ROLE;
import static top.moyel.mayo.modules.sys.entity.table.SysUserTableDef.SYS_USER;

/**
 * @author moyel
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Override
    public List<SysRoleDTO> listRoles() {
        QueryWrapper wrapper = QueryWrapper.create()
                .select(SYS_ROLE.ALL_COLUMNS)
                .select("u1.username as create_username", "u1.nickname as create_nickname", "u2.username as update_username", "u2.nickname as update_nickname")
                .from(SYS_ROLE.as("r"))
                .leftJoin(SYS_USER).as("u1")
                .on(SYS_USER.ID.eq(SYS_ROLE.CREATE_USER))
                .leftJoin(SYS_USER).as("u2")
                .on(SYS_USER.ID.eq(SYS_ROLE.UPDATE_USER));

        return listAs(wrapper, SysRoleDTO.class);
    }
}
