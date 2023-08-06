package top.moyel.mayo.modules.sys.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.moyel.mayo.modules.sys.entity.SysUser;
import top.moyel.mayo.modules.sys.mapper.SysUserMapper;
import top.moyel.mayo.modules.sys.service.ISysUserService;

/**
 * @author moyel
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
}
