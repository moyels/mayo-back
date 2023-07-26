package top.moyel.mayo.modules.sys.service.impl;

import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;
import top.moyel.mayo.modules.sys.entity.SysUser;
import top.moyel.mayo.modules.sys.mapper.SysUserMapper;
import top.moyel.mayo.modules.sys.service.ISysUserService;

/**
 * @author moyel
 */
@Service
public class SysUserServiceImpl extends MPJBaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
}
