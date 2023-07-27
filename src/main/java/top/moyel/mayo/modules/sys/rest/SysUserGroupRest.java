package top.moyel.mayo.modules.sys.rest;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.moyel.mayo.modules.sys.entity.SysUserGroup;
import top.moyel.mayo.modules.sys.mapstruct.SysUserGroupMapStruct;
import top.moyel.mayo.modules.sys.service.ISysUserGroupService;
import top.moyel.mayo.modules.sys.vo.SysUserGroupUpdateVO;
import top.moyel.mayo.modules.sys.vo.SysUserGroupVO;

import java.util.List;

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
        return sysUserGroupService.selectJoinList(SysUserGroupVO.class, new MPJLambdaWrapper<>());
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
}
