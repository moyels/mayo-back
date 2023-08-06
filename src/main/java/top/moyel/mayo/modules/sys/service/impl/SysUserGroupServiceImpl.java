package top.moyel.mayo.modules.sys.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.moyel.mayo.modules.sys.entity.SysUserGroup;
import top.moyel.mayo.modules.sys.mapper.SysUserGroupMapper;
import top.moyel.mayo.modules.sys.service.ISysUserGroupService;

/**
 * @author moyel
 */
@Service
public class SysUserGroupServiceImpl extends ServiceImpl<SysUserGroupMapper, SysUserGroup> implements ISysUserGroupService {
}
