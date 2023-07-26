package top.moyel.mayo.modules.sys.service.impl;

import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.stereotype.Service;
import top.moyel.mayo.modules.sys.dto.SysRoleDTO;
import top.moyel.mayo.modules.sys.entity.SysRole;
import top.moyel.mayo.modules.sys.entity.SysUser;
import top.moyel.mayo.modules.sys.mapper.SysRoleMapper;
import top.moyel.mayo.modules.sys.service.ISysRoleService;

import java.util.List;

/**
 * @author moyel
 */
@Service
public class SysRoleServiceImpl extends MPJBaseServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Override
    public List<SysRoleDTO> listRoles() {
        MPJLambdaWrapper<SysRole> wrapper = new MPJLambdaWrapper<SysRole>()
                .selectAll(SysRole.class)
                .selectAs("u1", SysUser::getUsername, SysRoleDTO::getCreateUsername)
                .selectAs("u1", SysUser::getNickname, SysRoleDTO::getCreateNickname)
                .selectAs("u2", SysUser::getUsername, SysRoleDTO::getCreateUsername)
                .selectAs("u2", SysUser::getUsername, SysRoleDTO::getUpdateNickname)
                .leftJoin(SysUser.class, "u1", SysUser::getId, SysRole::getCreateUser)
                .leftJoin(SysUser.class, "u2", SysUser::getId, SysRole::getUpdateUser);

        return selectJoinList(SysRoleDTO.class, wrapper);
    }
}
