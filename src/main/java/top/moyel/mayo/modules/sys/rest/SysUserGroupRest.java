package top.moyel.mayo.modules.sys.rest;

import com.mybatisflex.core.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.moyel.mayo.modules.sys.entity.SysRole;
import top.moyel.mayo.modules.sys.entity.SysUserGroup;
import top.moyel.mayo.modules.sys.mapstruct.SysUserGroupMapStruct;
import top.moyel.mayo.modules.sys.service.ISysUserGroupService;
import top.moyel.mayo.modules.sys.vo.SysUserGroupUpdateVO;
import top.moyel.mayo.modules.sys.vo.SysUserGroupVO;

import java.util.List;

import static top.moyel.mayo.modules.sys.entity.table.SysRoleTableDef.SYS_ROLE;
import static top.moyel.mayo.modules.sys.entity.table.SysUserGroupRoleTableDef.SYS_USER_GROUP_ROLE;
import static top.moyel.mayo.modules.sys.entity.table.SysUserGroupTableDef.SYS_USER_GROUP;

/**
 * 系统管理/用户组管理
 *
 * @author moyel
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/user/group")
public class SysUserGroupRest {
    private final ISysUserGroupService sysUserGroupService;

    /**
     * 用户组列表
     *
     * @return 用户组列表
     */
    @GetMapping
    public List<SysUserGroupVO> list() {
        return sysUserGroupService.listAs(QueryWrapper.create(), SysUserGroupVO.class);
    }

    /**
     * 新增用户组
     *
     * @param sysUserGroupVO 用户组参数
     * @return 是否新增成功
     */
    @PostMapping
    public Boolean save(@Validated @RequestBody SysUserGroupVO sysUserGroupVO) {
        SysUserGroup sysUserGroup = SysUserGroupMapStruct.INSTANCE.fromVO(sysUserGroupVO);
        return sysUserGroupService.save(sysUserGroup);
    }

    /**
     * 修改用户组信息
     *
     * @param sysUserGroupUpdateVO 用户组更新信息
     * @return 是否更新成功
     */
    @PutMapping
    public Boolean update(@Validated @RequestBody SysUserGroupUpdateVO sysUserGroupUpdateVO) {
        SysUserGroup sysUserGroup = SysUserGroupMapStruct.INSTANCE.fromUpdateVO(sysUserGroupUpdateVO);
        return sysUserGroupService.updateById(sysUserGroup);
    }

    /**
     * 删除用户组
     *
     * @param ids 用户组id列表
     * @return 是否删除成功
     */
    @DeleteMapping
    public Boolean remove(@RequestParam(name = "ids") List<Long> ids) {
        return sysUserGroupService.removeByIds(ids);
    }

    /**
     * 获取用户组对应的角色列表
     *
     * @param userGroupCode 用户组编码
     * @return 角色列表
     */
    @GetMapping("/roles")
    public List<SysRole> listUserGroupRoles(@RequestParam String userGroupCode) {
        return sysUserGroupService.queryChain()
                .select(SYS_ROLE.ALL_COLUMNS)
                .leftJoin(SYS_USER_GROUP_ROLE).on(SYS_USER_GROUP_ROLE.USER_GROUP_ID.eq(SYS_USER_GROUP.ID))
                .leftJoin(SYS_ROLE).on(SYS_ROLE.ID.eq(SYS_USER_GROUP_ROLE.ROLE_ID))
                .where(SYS_USER_GROUP.USER_GROUP_CODE.eq(userGroupCode))
                .listAs(SysRole.class);
    }
}
