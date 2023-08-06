package top.moyel.mayo.modules.sys.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.moyel.mayo.modules.sys.entity.SysUserGroupRole;
import top.moyel.mayo.modules.sys.mapper.SysUserGroupRoleMapper;
import top.moyel.mayo.modules.sys.service.ISysUserGroupRoleService;

/**
 * @author moyel
 */
@Service
public class SysUserGroupRoleServiceImpl extends ServiceImpl<SysUserGroupRoleMapper, SysUserGroupRole>
        implements ISysUserGroupRoleService {
}
