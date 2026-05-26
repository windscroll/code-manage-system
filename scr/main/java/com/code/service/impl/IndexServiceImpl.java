package com.code.service.impl;

import com.code.entity.QuestionSolution;
import com.code.entity.SysUser;
import com.code.entity.TreeNode;
import com.code.mapper.SolutionMapper;
import com.code.mapper.SysUserMapper;
import com.code.mapper.TreeNodeMapper;
import com.code.service.IndexService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private TreeNodeMapper treeNodeMapper;
    @Resource
    private SolutionMapper solutionMapper;

    @Override
    public SysUser login(SysUser user) {
        return sysUserMapper.login(user.getUsername(),user.getPassword());
    }

    @Override
    public List<TreeNode> getTreeList() {
        List<TreeNode> allList = treeNodeMapper.getAllNode();
        return buildTree(allList,0);
    }

    private List<TreeNode> buildTree(List<TreeNode> list,Integer parentId){
        List<TreeNode> tree = new ArrayList<>();
        for(TreeNode node : list){
            if(node.getParentId().equals(parentId)){
                node.setChildren(buildTree(list,node.getId()));
                tree.add(node);
            }
        }
        return tree;
    }

    @Override
    public void addNode(TreeNode treeNode) {
        treeNodeMapper.addNode(treeNode);
    }

    @Override
    public void editNode(TreeNode treeNode) {
        treeNodeMapper.editNode(treeNode);
    }

    @Override
    public void deleteNode(Integer id) {
        treeNodeMapper.deleteNode(id);
    }

    @Override
    public List<QuestionSolution> getSolutionList(Integer nodeId) {
        return solutionMapper.getSolutionByNodeId(nodeId);
    }

    @Override
    public void saveSolution(QuestionSolution solution) {
        solutionMapper.saveSolution(solution);
    }

    @Override
    public void deleteSolution(Integer id) {
        solutionMapper.deleteSolution(id);
    }
}