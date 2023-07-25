package top.moyel.mayo.modules.sys.rest;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.moyel.mayo.constant.TipsConstant;
import top.moyel.mayo.modules.sys.dto.SysRoleDTO;
import top.moyel.mayo.modules.sys.entity.SysRole;
import top.moyel.mayo.modules.sys.mapstruct.SysRoleMapStruct;
import top.moyel.mayo.modules.sys.service.ISysRoleService;
import top.moyel.mayo.modules.sys.vo.SysRoleSaveVO;
import top.moyel.mayo.modules.sys.vo.SysRoleUpdateVO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统管理/角色管理
 *
 * @author moyel
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/role")
public class SysRoleRest {
    private final ISysRoleService sysRoleService;

    /**
     * 角色树形列表
     *
     * @return 角色树形列表
     */
    @GetMapping("/tree")
    public List<Tree<Long>> treeListRoles() {
        List<SysRoleDTO> sysRoleDTOList = sysRoleService.listRoles();

        List<TreeNode<Long>> sysRoleTreeNodeList = sysRoleDTOList.stream().map(sysRole -> {
            TreeNode<Long> treeNode = new TreeNode<>(sysRole.getId(), sysRole.getParentRole(), sysRole.getRoleName(), sysRole.getSortNo());
            treeNode.setExtra(JSONUtil.parseObj(sysRole));
            return treeNode;
        }).collect(Collectors.toList());

        return TreeUtil.build(sysRoleTreeNodeList, null);
    }

    /**
     * 新增角色
     *
     * @param sysRoleSaveVO 角色数据
     * @return 新增是否成功
     */
    @PostMapping
    public Boolean saveRole(@Validated @RequestBody SysRoleSaveVO sysRoleSaveVO) {
        SysRole sysRole = SysRoleMapStruct.INSTANCE.fromSaveVO(sysRoleSaveVO);
        return sysRoleService.save(sysRole);
    }

    /**
     * 更新角色
     *
     * @param sysRoleUpdateVO 角色更新实例
     * @return 更新是否成功
     */
    @PutMapping
    public Boolean updateRole(@Validated @RequestBody SysRoleUpdateVO sysRoleUpdateVO) {
        SysRole sysRole = SysRoleMapStruct.INSTANCE.fromUpdateVO(sysRoleUpdateVO);
        return sysRoleService.updateById(sysRole);
    }

    /**
     * 删除角色
     *
     * @param roleIdList 角色id列表
     * @return 删除是否成功
     */
    @DeleteMapping
    public Boolean deleteRoles(@RequestParam(value = "ids") List<Long> roleIdList) {
        if (CollectionUtil.isEmpty(roleIdList)) {
            throw new RuntimeException(TipsConstant.PARAM_LIST_IS_EMPTY);
        }

        return sysRoleService.removeByIds(roleIdList);
    }
}
