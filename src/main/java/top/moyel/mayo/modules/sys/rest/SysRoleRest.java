package top.moyel.mayo.modules.sys.rest;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.moyel.mayo.dto.SysRoleDTO;
import top.moyel.mayo.modules.sys.service.ISysRoleService;

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
}
